package com.abc.notification3.api;

import static com.abc.notification3.modal.Constants.CONTENT_TYPE;
import static com.abc.notification3.modal.Constants.SERVER_KEY;

import com.abc.notification3.modal.PushNotification;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @Headers({"Authorization: key=" + SERVER_KEY, "Content-Type:" + CONTENT_TYPE})
    @POST("fcm/send")
    Call<PushNotification> sendNotification(@Body PushNotification notification);
}
