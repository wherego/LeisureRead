package com.llj.leisurereading.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

/**
 * Created by llj on 2017/3/3.
 * 基类Fragment
 */

public abstract class BaseFragment extends Fragment {

  private View mContentView;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    // mContentView的复用
    if (mContentView == null) {
      mContentView = inflater.inflate(provideLayoutId(), container, false);
      //绑定ButterKnife
      ButterKnife.bind(this,mContentView);
      //初始化view数据
      initView();
    }
    ViewGroup viewParent = (ViewGroup) mContentView.getParent();
    // 缓存的rootView需要判断是否已经被加过parent，如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
    if (viewParent != null) {
      viewParent.removeView(mContentView);
    }
    return mContentView;
  }

  //提供布局文件
  protected abstract int provideLayoutId();

  //初始化相关view
  protected abstract void initView();
}
