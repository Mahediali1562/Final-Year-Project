package io.shadowwings.smartfarm.Model;

import java.io.Serializable;

public class ProductModel implements Serializable {

    public String NAME, DESCRIPTION, URL, brandName;
    public String KEY, DEAL_PRICE, PRICE;

    public ProductModel() {}

    public ProductModel(String NAME, String DESCRIPTION, String URL, String brandName, String KEY, String DEAL_PRICE, String PRICE) {
        this.NAME = NAME;
        this.DESCRIPTION = DESCRIPTION;
        this.URL = URL;
        this.brandName = brandName;
        this.KEY = KEY;
        this.DEAL_PRICE = DEAL_PRICE;
        this.PRICE = PRICE;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getKEY() {
        return KEY;
    }

    public void setKEY(String KEY) {
        this.KEY = KEY;
    }

    public String getDEAL_PRICE() {
        return DEAL_PRICE;
    }

    public void setDEAL_PRICE(String DEAL_PRICE) {
        this.DEAL_PRICE = DEAL_PRICE;
    }

    public String getPRICE() {
        return PRICE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }
}
