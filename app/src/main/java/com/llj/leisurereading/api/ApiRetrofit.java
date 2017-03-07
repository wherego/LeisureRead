package com.llj.leisurereading.api;



import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by llj on 2017/3/7.
 */

public class ApiRetrofit {
  private static final String ZH_BASE_URL="http://news-at.zhihu.com/api/4/";
  private static final String GANK_BASE_URL="";
  private static final String DAILY_BASE_URL="";
  private ZhApiService zhApiService;

  public ZhApiService getZhApiService() {
    return zhApiService;
  }


  public ApiRetrofit() {
    //zhihu
    Retrofit retrofit=new Retrofit.Builder()
        .baseUrl(ZH_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
      zhApiService=retrofit.create(ZhApiService.class);
  }
}
