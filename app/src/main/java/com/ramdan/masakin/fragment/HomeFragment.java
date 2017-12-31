package com.ramdan.masakin.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ramdan.masakin.R;
import com.ramdan.masakin.adapter.HomeTabAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {

    @BindView(R.id.home_fragment_toolbar)
    Toolbar toolbar;

    @BindView(R.id.home_fragment_tabLayout)
    TabLayout tabLayout;

    @BindView(R.id.home_fragment_viewPager)
    ViewPager viewPager;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        setUpViewPager();
        tabLayout.setupWithViewPager(viewPager);
        toolbar.setTitle(R.string.app_name);
        return view;
    }

    void setUpViewPager() {
        if (viewPager.getAdapter() == null) {
            Log.e("view pager sts : ", "null");
            HomeTabAdapter homeTabAdapter = new HomeTabAdapter(getChildFragmentManager());
            homeTabAdapter.addFragment(new SugestedMenuFragment(), "Recomended");
            homeTabAdapter.addFragment(new TopMenusFragment(), "Top");
            viewPager.setAdapter(homeTabAdapter);
        } else {
            Log.e("view pager sts : ", "not null");
        }
    }

}
