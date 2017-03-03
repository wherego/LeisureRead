package com.llj.leisurereading.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;

/**
 * Created by llj on 2017/3/3. 基类Activity
 */
public abstract class BaseActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(provideLayoutId());
    //绑定View到ButterKnife
    ButterKnife.bind(this);
    initView();
  }

  //提供布局文件
  protected abstract int provideLayoutId();
  //初始化相关view
  protected abstract void initView();
}
