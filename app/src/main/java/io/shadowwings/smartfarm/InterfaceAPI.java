package io.shadowwings.smartfarm;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface InterfaceAPI {
    @POST("user.accounts.checkSignup")
    Call<String> checkSignup(@Header("Authorization") String authToken);

}
