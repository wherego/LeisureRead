package com.llj.leisurereading.base;

/**
 * Created by llj on 2017/3/3.
 * 基类Presenter层
 */

public interface BasePresenter<V> {

  //绑定View层
  void attachView(V view);

  //解除绑定
  void detachView();

}
