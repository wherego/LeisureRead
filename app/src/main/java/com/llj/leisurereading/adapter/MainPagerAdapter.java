package com.llj.leisurereading.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

/**
 * Created by llj on 2017/3/3.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

  private String[] mTitles={"知乎日报","果壳精选","豆瓣一刻"};
  private List<Fragment> mainList;
  public MainPagerAdapter(FragmentManager fm,List<Fragment> mainList) {
    super(fm);
    this.mainList=mainList;
  }

  @Override
  public Fragment getItem(int position) {
    return mainList.get(position);
  }

  @Override
  public int getCount() {
    return mainList.size();
  }
}
