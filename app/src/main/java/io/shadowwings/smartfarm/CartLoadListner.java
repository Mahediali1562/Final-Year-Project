package io.shadowwings.smartfarm;

import android.graphics.ColorSpace;

import java.util.List;

public interface CartLoadListner {
    Void onCartLoadSuccess(List<ColorSpace.Model> cartModelList);
    Void onCartLoadFail(String massage);
}
