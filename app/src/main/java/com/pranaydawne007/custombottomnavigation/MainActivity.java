package com.pranaydawne007.custombottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.pranaydawne007.custombottomnavigation.adapter.AdapterViewPager;
import com.pranaydawne007.custombottomnavigation.fragment.FavouritesFragment;
import com.pranaydawne007.custombottomnavigation.fragment.HomeFragment;
import com.pranaydawne007.custombottomnavigation.fragment.UserFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager2 pagerMain;
    BottomNavigationView bottomNavigationView;
    List<Fragment> fragmentArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFragments();
    }

    private void setFragments() {
        pagerMain = findViewById(R.id.pager_main);
        bottomNavigationView = findViewById(R.id.bottom_nav);

        fragmentArrayList.add(new HomeFragment());
        fragmentArrayList.add(new FavouritesFragment());
        fragmentArrayList.add(new UserFragment());

        AdapterViewPager adapterViewPager = new AdapterViewPager(this, fragmentArrayList);

        pagerMain.setAdapter(adapterViewPager);

        pagerMain.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                if(position == 0){
                    bottomNavigationView.setSelectedItemId(R.id.home);
                } else if (position == 1) {
                    bottomNavigationView.setSelectedItemId(R.id.favourite);
                } else if (position == 2) {
                    bottomNavigationView.setSelectedItemId(R.id.user);
                }
                super.onPageSelected(position);
            }
        });

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.home){
                pagerMain.setCurrentItem(0);
            } else if (item.getItemId() == R.id.favourite) {
                pagerMain.setCurrentItem(1);
            } else if (item.getItemId() == R.id.user) {
                pagerMain.setCurrentItem(2);
            }
            return true;
        });
    }
}