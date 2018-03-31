package com.simpragma.comvivamobileplatform.service;

import com.simpragma.comvivamobileplatform.model.ScreensResponse;
import com.simpragma.comvivamobileplatform.model.StylesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Holds endpoints of API services
 */
public interface ApiService {

    @GET("_design/styles/_view/getAll?include_docs=true")
    Call<StylesResponse> getStyles(@Header("Authorization") String authHeader);

    @GET("_design/screens/_view/getAll?include_docs=true")
    Call<ScreensResponse> getScreens(@Header("Authorization") String authHeader);
}