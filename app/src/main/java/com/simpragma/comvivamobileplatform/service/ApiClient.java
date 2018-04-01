package com.simpragma.comvivamobileplatform.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit API client that manages {@link Retrofit}
 */
public class ApiClient {

    private static Retrofit retrofit = null;

    private ApiClient() {
        // Prevent instantiation of myself and my sub-classes
    }

    /**
     * Creates and returns a {@link Retrofit} instance with the base URL, if not already available
     *
     * @return {@link Retrofit} object
     */
    public static Retrofit getClient() {
        if (null == retrofit) {
            retrofit = new Retrofit.Builder().baseUrl("http://breezeivr.com:5984/comviva/")
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}