package com.a2msproject.berbagi_layout.Donatur;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a2msproject.berbagi_layout.R;
import com.a2msproject.berbagi_layout.ViewPagerAdapter;


/**
 * Created by Super User on 5/15/2017.
 */

public class Fragment_Tab_Donasi_Dana extends Fragment {

    ViewPager viewPager;
    TabLayout tabLayout;
    View dataView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataView = inflater.inflate(R.layout.fragmant_tab_donasi_dana,
                container, false);

        viewPager = (ViewPager) dataView.findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) dataView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);
        tabLayout.setSelectedTabIndicatorHeight(10);

        return dataView;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new Fragment_Donasi_Dana(), "Disetujui");
        adapter.addFragment(new Fragment_Donasi_Dana_Menunggu(), "Menunggu Konfirmasi");
        viewPager.setAdapter(adapter);
    }
}
