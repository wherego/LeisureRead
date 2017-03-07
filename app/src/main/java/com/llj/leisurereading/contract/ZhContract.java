package com.llj.leisurereading.contract;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import com.llj.leisurereading.base.BasePresenter;
import com.llj.leisurereading.base.BaseView;

/**
 * Created by llj on 2017/3/6.
 */

public class ZhContract {
  public interface ZView<T> extends BaseView<T>{
    RecyclerView getRecyclerView();
    SwipeRefreshLayout getSwipeRefreshLayout();
  }
  public interface ZPresenter<T> extends BasePresenter<T>{

  }

}
