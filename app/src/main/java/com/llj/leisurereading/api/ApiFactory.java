package com.llj.leisurereading.api;

/**
 * Created by llj on 2017/3/7.
 */

public class ApiFactory {

  public static ZhApiService zhApiService;

  public static ZhApiService getZhApi() {
    if (zhApiService == null) {
      synchronized (ApiFactory.class) {
        if (zhApiService == null) {
          zhApiService = new ApiRetrofit().getZhApiService();
        }
      }
    }
    return zhApiService;
  }

}
