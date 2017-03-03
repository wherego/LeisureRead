package com.llj.leisurereading.fragment;

import android.support.v4.app.Fragment;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by llj on 2017/3/3.
 * Fragment工厂类
 */

public class FragmentFactory {

  private static Map<Integer, Fragment> mFragmentMap=new HashMap<>();

  public static Fragment getFragmentInstance(int position) {
    Fragment fragment;
    fragment = mFragmentMap.get(position);
    if (fragment == null) {
      switch (position) {
        case 0:
          fragment = new ZhFragment();
          break;
        case 1:
          fragment = new GkFragment();
          break;
        case 2:
          fragment = new DbFragment();
          break;
      }
      if(fragment!=null){
        mFragmentMap.put(position,fragment);
      }
    }
    return fragment;
  }

}
