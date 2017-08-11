package com.example.tramalho.templates;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tramalho on 11/08/17.
 */

public class Repository implements Callback<Model> {

    public static final String BASE_URL = "http://www.mocky.io/";
    private Listener listener;


    interface Listener {
        void success(Model model);
        void failure();
    }

    public Repository(Listener listener) {
        this.listener = listener;
    }

    public void request(String hashTemplate) {
        Retrofit retrofit = getRetrofit();
        TemplateApi templateApi = retrofit.create(TemplateApi.class);
        Call<Model> call = templateApi.getData(hashTemplate);
        call.enqueue(this);
    }

    private Retrofit getRetrofit() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    @Override
    public void onResponse(Call<Model> call, Response<Model> response) {
        Model model = response.body();
        listener.success(model);
    }

    @Override
    public void onFailure(Call<Model> call, Throwable t) {
        listener.failure();
    }
}
