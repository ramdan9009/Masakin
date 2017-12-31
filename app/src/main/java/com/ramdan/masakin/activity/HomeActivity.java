package com.ramdan.masakin.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.ramdan.masakin.R;
import com.ramdan.masakin.adapter.HomeTabAdapter;
import com.ramdan.masakin.fragment.FavoriteMenuFragment;
import com.ramdan.masakin.fragment.HomeFragment;
import com.ramdan.masakin.fragment.SugestedMenuFragment;
import com.ramdan.masakin.fragment.TopMenusFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {
//    @BindView(R.id.main_act_toolbar)
//    Toolbar toolbar;
//
//    @BindView(R.id.main_act_tabLayout)
//    TabLayout tabLayout;
//
//    @BindView(R.id.main_act_viewPager)
//    ViewPager viewPager;
//
//    View drawerHeader;


    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    @BindView(R.id.navView)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        loadCurrentFragment(R.id.drawer_home_menu);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                loadCurrentFragment(item.getItemId());
                return false;
            }
        });


    }

    void loadCurrentFragment(int itemId) {
        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        fragmentTransaction1.replace(R.id.frame, getCurrentFragment(itemId));
        fragmentTransaction1.commitAllowingStateLoss();
        navigationView.setCheckedItem(itemId);
        drawerLayout.closeDrawers();
    }

    Fragment getCurrentFragment(int id) {
        Fragment currentFragment = null;

        switch (id) {
            case R.id.drawer_home_menu:
                currentFragment = new HomeFragment();
                break;
            case R.id.drawer_favorite_menu:
                currentFragment = new FavoriteMenuFragment();
                break;
        }

        return currentFragment;
    }

    void setupViewPager(ViewPager viewPager) {
        HomeTabAdapter homeTabAdapter = new HomeTabAdapter(getSupportFragmentManager());
        homeTabAdapter.addFragment(new SugestedMenuFragment(), "Sugested");
        homeTabAdapter.addFragment(new TopMenusFragment(), "Top");
        viewPager.setAdapter(homeTabAdapter);
    }

    void setupTabIcon() {
//        int[] tabIcons = {R.drawable.ic_action_top,R.drawable.ic_action_favorite};
//        Log.e("tab count : ",tabLayout.getTabCount()+"");
//        if(tabIcons.length == tabLayout.getTabCount()){
//            for (int i = 0; i < tabIcons.length; i++){
//                tabLayout.getTabAt(i).setIcon(tabIcons[i]);
//            }
//
//        }
    }
}
