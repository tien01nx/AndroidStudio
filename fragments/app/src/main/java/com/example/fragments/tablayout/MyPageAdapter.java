package com.example.fragments.tablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyPageAdapter extends FragmentPagerAdapter {
    private  int numOfTable;

    public MyPageAdapter(@NonNull FragmentManager fm, int numOfTable) {
        super(fm);
        this.numOfTable = numOfTable;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ChatFragment();
            case 1:
                return  new StatusFragment();
            case 2:
                return new CallFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTable;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title =null;
        if (position==0){
            title ="Chats";
        }
       else if (position==1){
            title="Status";
        }
       else if(position==2){
           title="Call";
        }
       return title;
    }
}
