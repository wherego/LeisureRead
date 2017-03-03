package com.llj.leisurereading.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import butterknife.BindView;
import com.llj.leisurereading.R;
import com.llj.leisurereading.base.BaseFragment;
import com.llj.leisurereading.view.recyclerview.CommonAdapter;
import com.llj.leisurereading.view.recyclerview.base.ViewHolder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by llj on 2017/3/3.
 */

public class ZhFragment extends BaseFragment {

  private static final String TAG = "ZhFragment";

  @BindView(R.id.recyclerview_zhihu)
  RecyclerView mRecyclerviewZhihu;
  @BindView(R.id.swipeRefresh_zhihu)
  SwipeRefreshLayout mSwipeRefreshZhihu;
  private CommonAdapter<String> mZhiHuCommonAdapter;
  private List<String> mZhList;

  @Override
  protected int provideLayoutId() {
    return R.layout.fragment_zhihu;
  }

  @Override
  protected void initView() {
    //SwipeRefreshLayout设置刷新监听
    mSwipeRefreshZhihu.setOnRefreshListener(new OnRefreshListener() {
      @Override
      public void onRefresh() {
      }
    });
    //初始化RecyclerView
    mRecyclerviewZhihu.setLayoutManager(new LinearLayoutManager(getActivity()));
    mRecyclerviewZhihu.addItemDecoration(
        new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
    //初始化adapter数据
    initData();
    //初始化adapter
    mZhiHuCommonAdapter = new CommonAdapter<String>(getActivity(),
        R.layout.item_fragment_zhihu, mZhList) {
      @Override
      protected void convert(ViewHolder holder, String s, int position) {
        TextView tv=holder.getView(R.id.tv_zhihu);
        tv.setText(s);
      }
    };
    //给recyclerView设置adapter
    mRecyclerviewZhihu.setAdapter(mZhiHuCommonAdapter);


  }

  private void initData() {
    mZhList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      mZhList.add("测试数据" + i);
    }
  }

}
