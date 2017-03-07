package com.llj.leisurereading.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import com.llj.leisurereading.R;
import com.llj.leisurereading.base.BaseFragment;
import com.llj.leisurereading.bean.NewsTimeLine.StoriesBean;
import com.llj.leisurereading.contract.ZhContract;
import com.llj.leisurereading.presenter.ZhPresenter;
import com.llj.leisurereading.weight.recyclerview.CommonAdapter;
import com.llj.leisurereading.weight.recyclerview.base.ViewHolder;
import com.llj.leisurereading.weight.recyclerview.wrapper.LoadMoreWrapper;
import com.llj.leisurereading.weight.recyclerview.wrapper.LoadMoreWrapper.OnLoadMoreListener;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Created by llj on 2017/3/3.
 */

public class ZhFragment extends BaseFragment implements ZhContract.ZView {

  private static final String TAG = "ZhFragment";

  @BindView(R.id.recyclerview_zhihu)
  RecyclerView mRecyclerviewZhihu;
  @BindView(R.id.swipeRefresh_zhihu)
  SwipeRefreshLayout mSwipeRefreshZhihu;
  private ZhPresenter zhPresenter;

  @Override
  protected int provideLayoutId() {
    return R.layout.fragment_zhihu;
  }
  @Override
  protected void initView() {
    //初始化RecyclerView
    mRecyclerviewZhihu.setLayoutManager(new LinearLayoutManager(getActivity()));
    mRecyclerviewZhihu.addItemDecoration(
        new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
    //初始化一个presenter
    zhPresenter = new ZhPresenter(getActivity());
    //绑定view
    zhPresenter.attachView(this);
    //让presenter去拿数据
    zhPresenter.getLatestNews();
  }

  @Override
  public void showLoading(boolean isShow) {

  }

  @Override
  public void showMessage(String message) {
    Toast.makeText(getActivity(), "请求成功", Toast.LENGTH_SHORT).show();

  }

  @Override
  public RecyclerView getRecyclerView() {
    return mRecyclerviewZhihu;
  }

  @Override
  public SwipeRefreshLayout getSwipeRefreshLayout() {
    return mSwipeRefreshZhihu;
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    zhPresenter.getmCompositeDisposable().clear();
  }
}
