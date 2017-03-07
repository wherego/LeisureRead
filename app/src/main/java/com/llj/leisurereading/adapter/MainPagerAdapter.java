package com.llj.leisurereading.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

/**
 * Created by llj on 2017/3/3.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

  private List<Fragment> mainList;

  public MainPagerAdapter(FragmentManager fm, List<Fragment> mainList) {
    super(fm);
    this.mainList = mainList;
  }

  @Override
  public Fragment getItem(int position) {
    return mainList.get(position);
  }

  @Override
  public int getCount() {
    return mainList.size();
  }

  @Override
  public CharSequence getPageTitle(int position) {
    switch (position) {
      case 0:
        return "知乎日报";
      case 1:
        return "果壳精选";
      case 2:
        return "豆瓣一刻";
    }
    return null;
  }
}
