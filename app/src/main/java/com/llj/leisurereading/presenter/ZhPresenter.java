package com.llj.leisurereading.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.llj.leisurereading.R;
import com.llj.leisurereading.ZhDetailActivity;
import com.llj.leisurereading.api.ApiFactory;
import com.llj.leisurereading.bean.NewsTimeLine;
import com.llj.leisurereading.bean.NewsTimeLine.StoriesBean;
import com.llj.leisurereading.contract.ZhContract;
import com.llj.leisurereading.fragment.ZhFragment;
import com.llj.leisurereading.weight.recyclerview.CommonAdapter;
import com.llj.leisurereading.weight.recyclerview.MultiItemTypeAdapter;
import com.llj.leisurereading.weight.recyclerview.MultiItemTypeAdapter.OnItemClickListener;
import com.llj.leisurereading.weight.recyclerview.base.ViewHolder;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by llj on 2017/3/6. 知乎Presenter
 */

public class ZhPresenter implements ZhContract.ZPresenter<ZhFragment> {

  private static final String TAG = "ZhPresenter";
  private Context mContext;
  private ZhContract.ZView zhView;
  private RecyclerView mZhRecyclerView;
  private CommonAdapter<StoriesBean> mZhCommonAdapter;
  private CompositeDisposable mCompositeDisposable=new CompositeDisposable();

  public CompositeDisposable getmCompositeDisposable() {
    return mCompositeDisposable;
  }

  public ZhPresenter(Context mContext) {
    this.mContext = mContext;
  }

  @Override
  public void attachView(ZhFragment view) {
    this.zhView = view;
  }

  @Override
  public void detachView() {
    zhView = null;

  }

  public void getLatestNews() {
    if (zhView != null) {
      mZhRecyclerView = zhView.getRecyclerView();
      ApiFactory.getZhApi().getLatestNews()
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(new Observer<NewsTimeLine>() {
        @Override
        public void onSubscribe(Disposable d) {
          Log.d(TAG, "onSubscribe: "+d);
          mCompositeDisposable.add(d);
        }

        @Override
        public void onNext(NewsTimeLine newsTimeLine) {
          handleData(newsTimeLine,mZhRecyclerView);
          Log.d(TAG, "onNext: "+newsTimeLine);
        }

        @Override
        public void onError(Throwable e) {
          Log.d(TAG, "onError: "+e.getMessage());

        }

        @Override
        public void onComplete() {
          Log.d(TAG, "onComplete: ");

        }
      });
    }

  }

  public void handleData(final NewsTimeLine newsTimeLine, RecyclerView mZhRecyclerView) {

    mZhCommonAdapter = new CommonAdapter<StoriesBean>(mContext, R.layout.item_fragment_zh,
        newsTimeLine.getStories()) {
      @Override
      protected void convert(ViewHolder holder, StoriesBean storiesBean, int position) {
        //设置图片
        ImageView imageView = holder.getView(R.id.iv_stories_img);
        Glide.with(mContext.getApplicationContext()).load(storiesBean.getImages().get(0)).into(imageView);
        //Picasso.with(getActivity()).load(s.getImages().get(0)).into(imageView);
        //设置文字
        TextView tv = holder.getView(R.id.tv_stories_title);
        tv.setText(storiesBean.getTitle());
      }
    };
    mZhCommonAdapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener() {
      @Override
      public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
        int id=newsTimeLine.getStories().get(position).getId();
        Bundle b=new Bundle();
        b.putInt("id",id);
        Intent intent=new Intent(mContext,ZhDetailActivity.class);
        intent.putExtras(b);
        mContext.startActivity(intent);
      }

      @Override
      public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
        return false;
      }
    });
    mZhRecyclerView.setAdapter(mZhCommonAdapter);


  }
}
