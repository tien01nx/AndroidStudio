package com.example.fragments.Grafments;

import com.example.fragments.R;

public enum ModelCourse {
    RED(R.string.red,R.layout.view_red),
    BLUE(R.string.blue,R.layout.view_blue),
    GREEN(R.string.green,R.layout.view_green);

    private int mTitleID;
    private int mLayoutID;

    public int getmTitleID() {
        return mTitleID;
    }

    public void setmTitleID(int mTitleID) {
        this.mTitleID = mTitleID;
    }

    public int getmLayoutID() {
        return mLayoutID;
    }

    public void setmLayoutID(int mLayoutID) {
        this.mLayoutID = mLayoutID;
    }

    ModelCourse(int mTitleID, int mLayoutID) {
        this.mTitleID = mTitleID;
        this.mLayoutID = mLayoutID;
    }
}
