package com.jdkgroup.bottomlayoutsimple.model;

public class ModelMenu {

    private int mDrawableRes;

    private String mTitle;

    public ModelMenu(int drawable, String title) {
        mDrawableRes = drawable;
        mTitle = title;
    }

    public int getDrawableResource() {
        return mDrawableRes;
    }

    public String getTitle() {
        return mTitle;
    }

}
