package com.jdkgroup.bottomlayoutsearch.Adapter.model;

/**
 * Created by LENOVO on 2/28/2017.
 */

public class ModelProduct {
    private int id;
    private String productName;

    public ModelProduct(int id, String productName) {
        this.id = id;
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}


