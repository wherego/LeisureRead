package com.llj.leisurereading;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;
import butterknife.BindView;
import com.llj.leisurereading.adapter.MainPagerAdapter;
import com.llj.leisurereading.base.BaseActivity;
import com.llj.leisurereading.constants.Constants;
import com.llj.leisurereading.fragment.FragmentFactory;
import com.llj.leisurereading.weight.SplashView;
import com.llj.leisurereading.weight.SplashView.OnSplashViewActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * SplashView 实现闪屏页(广告页)
 */
public class MainActivity extends BaseActivity implements OnNavigationItemSelectedListener {

  @BindView(R.id.toolbar)
  Toolbar mToolbar;
  @BindView(R.id.tablayout_main)
  TabLayout mTablayoutMain;
  @BindView(R.id.viewpager_main)
  ViewPager mViewPager;
  @BindView(R.id.nav_view)
  NavigationView mNavView;
  @BindView(R.id.drawer_layout)
  DrawerLayout mDrawerLayout;
  private List<Fragment> mFragmentList;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  protected int provideLayoutId() {
    return R.layout.activity_main;
  }

  @Override
  protected void initView() {
    //初始化闪屏页
    //initSplash();
    //初始化ToolBar
    setSupportActionBar(mToolbar);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      mToolbar.setTitleTextColor(Color.WHITE);
      actionBar.setTitle("休闲阅读");
      actionBar.setDisplayHomeAsUpEnabled(true);//返回键启用
      actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu);//返回键图标
    }
    //初始化集合数据-->装载Fragment
    initFragments();
    //为ViewPager设置Adapter
    mViewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), mFragmentList));
    //设置viewPager和tabLayout的联动,注意此方法会清除tab，解决方法1，此方法之后添加tab文本，2，在adapter里重写getPageTitle天添加
    mTablayoutMain.setupWithViewPager(mViewPager);
    //为侧边栏item设置监听
    mNavView.setNavigationItemSelectedListener(this);
  }


  private void initFragments() {
    mFragmentList = new ArrayList<>();
    mFragmentList.add(FragmentFactory.getFragmentInstance(Constants.FRAGMENT_ZHIHU));
    mFragmentList.add(FragmentFactory.getFragmentInstance(Constants.FRAGMENT_GUOKE));
    mFragmentList.add(FragmentFactory.getFragmentInstance(Constants.FRAGMENT_DOUBAN));
  }

  private void initSplash() {
    // call this method anywhere to update splash view data
    SplashView
        .updateSplashData(this, "http://ww2.sinaimg.cn/large/72f96cbagw1f5mxjtl6htj20g00sg0vn.jpg",
            "http://www.baidu.com");
    SplashView.showSplashView(this, 3, R.drawable.default_img,
        new OnSplashViewActionListener() {
          @Override
          public void onSplashImageClick(String actionUrl) {
            Log.d("SplashView", "img clicked. actionUrl: " + actionUrl);
            Toast.makeText(MainActivity.this, "img clicked." + actionUrl, Toast.LENGTH_SHORT)
                .show();
          }

          @Override
          public void onSplashViewDismiss(boolean initiativeDismiss) {
            Log.d("SplashView", "dismissed, initiativeDismiss: " + initiativeDismiss);
          }
        });
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
      //开启侧边栏
      mDrawerLayout.openDrawer(GravityCompat.START);
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onBackPressed() {
    if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
      //关闭侧边栏
      mDrawerLayout.closeDrawers();
    }else{
      super.onBackPressed();
    }

  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    // Handle navigation view item clicks here.
    int itemId = item.getItemId();
    if (itemId == R.id.setting) {
      // Handle the setting action
    } else if (itemId == R.id.about) {
      // Handle the about action
    } else if (itemId == R.id.share) {
      // Handle the share action
    }
    mDrawerLayout.closeDrawer(GravityCompat.START);
    return true;
  }
}
