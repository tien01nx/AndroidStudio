package com.example.fragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;


import com.example.fragments.bottomNavigationBar.ThirdFragment;
import com.example.fragments.gridView.CourseModel;
import com.example.fragments.gridView.MyAdapter;
import com.example.fragments.navigation.FirstFragment;
import com.example.fragments.navigation.FlutterFragment;
import com.example.fragments.navigation.SecondFragment;
import com.example.fragments.tablayout.MyPageAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

//bottomNavidationView
//public class MainActivity extends AppCompatActivity implements  BottomNavigationView.OnNavigationItemSelectedListener{
    public class MainActivity extends AppCompatActivity {
    // navigation
//    private DrawerLayout mDrawer;
//    private Toolbar toolbar;
//    private NavigationView nvDrawer;
//    private ActionBarDrawerToggle drawerToggle;

    // bottomNavigationView
//    BottomNavigationView bottomNavigationView;
//    FirstFragment firstFragment = new FirstFragment();
//    SecondFragment secondFragment = new SecondFragment();
//    ThirdFragment thirdFragment = new ThirdFragment();

// gridView
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //View pager
//        setContentView(R.layout.activity_main);
//        ViewPager viewPager2 = findViewById(R.id.viewPager);
//        MyPageAdapter myPageAdapter = new MyPageAdapter(this);
//        viewPager2.setAdapter(new MyPageAdapter(this));


        // tablayout
//        setContentView(R.layout.tablayout);
//        TabLayout tabLayout = findViewById(R.id.tabLayout);
//        TabItem tabChats = findViewById(R.id.tabChats);
//        TabItem tabStatus = findViewById(R.id.tabStatus);
//        TabItem tabCalls = findViewById(R.id.tabCalls);
//        ViewPager viewPager = findViewById(R.id.viewPage);
//
//        MyPageAdapter pageAdapter = new MyPageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
//            viewPager.setAdapter(pageAdapter);
//
//        // nó được sử dụng để nối Tablayout với ViewPage
//        tabLayout.setupWithViewPager(viewPager);

        // navigation
//        setContentView(R.layout.navigation_main);
//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        // Drawer view
//        mDrawer = findViewById(R.id.drawer_layout);
//
//        // Drawer Navigation
//        nvDrawer = findViewById(R.id.nvView);
//        setupDrawerContent(nvDrawer);

        // bottomNavigationView

//        setContentView(R.layout.activity_bottom_navigation_bar_main);
//        bottomNavigationView = findViewById(R.id.bottomNavigationView);
//        bottomNavigationView.setOnNavigationItemSelectedListener(this);
//    bottomNavigationView.setSelectedItemId(R.id.home);


        // gridView
        setContentView(R.layout.activity_grid_view_main);
        gridView = findViewById(R.id.gridView);

        // Data to be displayed into gridview
        ArrayList<CourseModel> courseModelArrayList = new ArrayList<CourseModel>();
        courseModelArrayList.add(new CourseModel("The Complete Android 12 Course", R.drawable.course1));
        courseModelArrayList.add(new CourseModel("The Complete Java Developer Course", R.drawable.course2));
        courseModelArrayList.add(new CourseModel("The Complete Kotlin Course", R.drawable.course3));
        courseModelArrayList.add(new CourseModel("The Complete Data Structure and Algorithms Course", R.drawable.course4));


        // Attach the Adapter
        MyAdapter myAdapter = new MyAdapter(this,courseModelArrayList );
        gridView.setAdapter(myAdapter);

    }

    // bottomNavigation

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()){
//            case R.id.proflie:
//                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,firstFragment).commit();
//                return  true;
//            case R.id.home:
//                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,secondFragment).commit();
//                return  true;
//            case R.id.settiing:
//                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,thirdFragment).commit();
//        }
//        return false;
//    }
    // navigation
//    private void setupDrawerContent(NavigationView nvDrawer) {
//        nvDrawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                selectDrawerItem(item);
//                return true;
//            }
//
//            private void selectDrawerItem(MenuItem item) {
//                Fragment fragment = null;
//                Class fragmentClass;
//                switch (item.getItemId()) {
//                    case R.id.nav_first_fragment:
//                        fragmentClass = FirstFragment.class;
//                        break;
//                    case R.id.nav_second_fragment:
//                        fragmentClass = SecondFragment.class;
//                        break;
//                    case R.id.nav_third_fragment:
//                        fragmentClass = FlutterFragment.class;
//                    default:
//                        fragmentClass = FirstFragment.class;
//                }
//                try {
//                    fragment = (Fragment) fragmentClass.newInstance();
//
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                } catch (InstantiationException e) {
//                    e.printStackTrace();
//                }
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                fragmentManager.beginTransaction().replace(R.id.flCOntent,fragment).commit();
//                item.setCheckable(true);
//                setTitle(item.getTitle());
//                mDrawer.closeDrawers();
//            }
//
//        });
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                mDrawer.openDrawer(GravityCompat.START);
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}