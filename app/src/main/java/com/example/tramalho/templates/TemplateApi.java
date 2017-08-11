package com.example.tramalho.templates;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by tramalho on 11/08/17.
 */

interface TemplateApi {
    @GET("V2/{hash}")
    Call<Model> getData(@Path("hash") String username);

    @GET("")
    Call<String> getData();

}
