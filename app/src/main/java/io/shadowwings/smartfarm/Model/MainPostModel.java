package io.shadowwings.smartfarm.Model;

public class MainPostModel {

    String POST_URL, POST_TITLE, POST_TYPE, POST_TIME, POST_ID;

    public MainPostModel(){}

    public MainPostModel(String POST_URL, String POST_TITLE, String POST_TYPE, String POST_TIME, String POST_ID) {
        this.POST_URL = POST_URL;
        this.POST_TITLE = POST_TITLE;
        this.POST_TYPE = POST_TYPE;
        this.POST_TIME = POST_TIME;
        this.POST_ID = POST_ID;
    }

    public String getPOST_URL() {
        return POST_URL;
    }

    public void setPOST_URL(String POST_URL) {
        this.POST_URL = POST_URL;
    }

    public String getPOST_TITLE() {
        return POST_TITLE;
    }

    public void setPOST_TITLE(String POST_TITLE) {
        this.POST_TITLE = POST_TITLE;
    }

    public String getPOST_TYPE() {
        return POST_TYPE;
    }

    public void setPOST_TYPE(String POST_TYPE) {
        this.POST_TYPE = POST_TYPE;
    }

    public String getPOST_TIME() {
        return POST_TIME;
    }

    public void setPOST_TIME(String POST_TIME) {
        this.POST_TIME = POST_TIME;
    }

    public String getPOST_ID() {
        return POST_ID;
    }

    public void setPOST_ID(String POST_ID) {
        this.POST_ID = POST_ID;
    }
}
