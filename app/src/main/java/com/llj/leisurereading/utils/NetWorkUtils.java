package com.llj.leisurereading.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by llj on 2017/3/3.
 * 网络状态工具类
 */

public class NetWorkUtils {

  //检测是否连接到网络
  public static boolean netWorkConnected(Context context) {
    if (context != null) {
      ConnectivityManager connectManager = (ConnectivityManager) context
          .getSystemService(Context.CONNECTIVITY_SERVICE);
      NetworkInfo networkInfo = connectManager.getActiveNetworkInfo();
      if (networkInfo != null) {
        return networkInfo.isAvailable();
      }
    }
    return false;
  }

  //检测WIFI是否连接
  public static boolean connectWifi(Context context) {
    if (context != null) {
      ConnectivityManager connectManager = (ConnectivityManager) context
          .getSystemService(Context.CONNECTIVITY_SERVICE);
      NetworkInfo networkInfo = connectManager.getActiveNetworkInfo();
      if (networkInfo != null) {
        if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
          return networkInfo.isAvailable();
        }
      }
    }
    return false;

  }

  //检测移动网络是否连接
  public static boolean connectMobile(Context context) {
    if (context != null) {
      ConnectivityManager connectManager = (ConnectivityManager) context
          .getSystemService(Context.CONNECTIVITY_SERVICE);
      NetworkInfo networkInfo = connectManager.getActiveNetworkInfo();
      if (networkInfo != null) {
        if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
          return networkInfo.isAvailable();
        }
      }
    }
    return false;
  }

}
