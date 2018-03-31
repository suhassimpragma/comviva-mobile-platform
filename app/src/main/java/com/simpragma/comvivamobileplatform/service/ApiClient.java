package com.simpragma.comvivamobileplatform.service;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit API client that manages {@link Retrofit}
 */
public class ApiClient {

    private static Retrofit retrofit = null;

    /**
     * Creates and returns a {@link Retrofit} instance with the base URL, if not already available
     *
     * @param context {@link Context} object
     * @return {@link Retrofit} object
     */
    public static Retrofit getClient(Context context) {
        if (null == retrofit) {
            retrofit = new Retrofit.Builder().baseUrl("http://breezeivr.com:5984/comviva/")
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}