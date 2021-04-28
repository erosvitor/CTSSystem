package com.ctseducare.ctssystem;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ctseducare.ctssystem.R;
import com.ctseducare.ctssystem.ui.device.DeviceFragment;
import com.ctseducare.ctssystem.ui.network.NetworkFragment;
import com.ctseducare.ctssystem.ui.system.SystemFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.screen_main_tab_device, R.string.screen_main_tab_system, R.string.screen_main_tab_network};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return DeviceFragment.newInstance();
        else if (position == 1)
            return SystemFragment.newInstance();
        else
            return NetworkFragment.newInstance();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return TAB_TITLES.length;
    }
}