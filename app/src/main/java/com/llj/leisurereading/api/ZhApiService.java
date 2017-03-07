package com.llj.leisurereading.api;

import com.llj.leisurereading.bean.NewsTimeLine;
import com.llj.leisurereading.bean.ZhBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by llj on 2017/3/6. 创建业务请求接口 http://gank.io/api/data/福利/10/ http://gank.io/api/
 */

public interface ZhApiService {

  @GET("data/福利/10/{page}")
  Observable<ZhBean> getZhData(@Path("page") int page);

  @GET("news/latest")
  Observable<NewsTimeLine> getLatestNews();

  @GET("news/before/{time}")
  Observable<NewsTimeLine> getBeforetNews(@Path("time") String time);

 /* @GET("news/{id}")
  Call<News> getDetailNews(@Path("id") String id);*/
}
