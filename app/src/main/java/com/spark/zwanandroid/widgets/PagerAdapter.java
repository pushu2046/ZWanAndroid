package com.spark.zwanandroid.widgets;

import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.spark.zwanandroid.base.fragment.BaseFragment;

import java.util.List;

/**
 * desc:Fragment数据适配器-----
 */
public class PagerAdapter extends FragmentStatePagerAdapter {

    private List<BaseFragment> fragments;

    public PagerAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        //每次都刷新都调用instantiateItem 和destroyItem方法
        return POSITION_NONE;
    }
}
