package io.shadowwings.smartfarm.Model;

import java.io.Serializable;

public class CartItemModel implements Serializable {
    public String KEY, NAME, DESCRIPTION, URL, brandName;
    public Long DEAL_PRICE, PRICE,productID;

    public String getNAME() {
        return NAME;
    }

    public String getKEY() {
        return KEY;
    }

    public void setKEY(String KEY) {
        this.KEY = KEY;
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

    public Long getDEAL_PRICE() {
        return DEAL_PRICE;
    }

    public void setDEAL_PRICE(Long DEAL_PRICE) {
        this.DEAL_PRICE = DEAL_PRICE;
    }

    public Long getPRICE() {
        return PRICE;
    }

    public void setPRICE(Long PRICE) {
        this.PRICE = PRICE;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }
}
