package com.llj.leisurereading;

/**
 * Created by llj on 2017/3/6.
 */

public interface RetrofitListener<T> {
  void success(T data);
  void failed(String msg);

}
