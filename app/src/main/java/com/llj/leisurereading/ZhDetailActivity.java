package com.llj.leisurereading;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ZhDetailActivity extends AppCompatActivity {

  public static final String ZH_DETAIL_URL="http://news-at.zhihu.com/api/4/news/";
  @BindView(R.id.wb_zh)
  WebView mWbZh;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_zh_detail);
    ButterKnife.bind(this);
    int id=getIntent().getExtras().getInt("id");
    if(id!=0){
      String url=ZH_DETAIL_URL+id;
      mWbZh.loadUrl(url);
    }
    mWbZh.setWebViewClient(new WebViewClient(){
      @Override
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
      }
    });
  }


}
