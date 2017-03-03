package com.llj.leisurereading.base;

/**
 * Created by llj on 2017/3/3.
 * 基类View层的封装
 */

public interface BaseView<T> {

  //设置数据
  void setData(T data);

  //显示加载进度条
  void showLoading(boolean isShow);

  //显示信息
  void showMessage(String message);
}
