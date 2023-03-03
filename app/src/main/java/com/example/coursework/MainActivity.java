package com.example.coursework;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views by id
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        // Create fragments and add to list
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new CalculatorFragment());
        fragmentList.add(new OctalFragment());
        fragmentList.add(new DrawFragment());

        // Create titles for tabs
        List<String> titleList = new ArrayList<>();
        titleList.add("Calculator");
        titleList.add("Octal");
        titleList.add("Draw");

        // Create adapter for ViewPager
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titleList.get(position);
            }
        };

        // Set adapter for ViewPager and setup with TabLayout
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}

