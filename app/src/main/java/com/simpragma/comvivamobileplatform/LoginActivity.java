package com.simpragma.comvivamobileplatform;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.simpragma.comvivamobileplatform.model.Screen;
import com.simpragma.comvivamobileplatform.model.ScreensResponse;
import com.simpragma.comvivamobileplatform.model.Style;
import com.simpragma.comvivamobileplatform.model.StylesResponse;
import com.simpragma.comvivamobileplatform.service.ApiClient;
import com.simpragma.comvivamobileplatform.service.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

	private static final String TAG = "LoginActivity";
	private Style style;
	private Screen screen;

	private static final String AUTH = "Basic Y29tdml2YTo0NTZDb212aXZhIQ==";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getStyleAndScreens();
	}

	private void getStyleAndScreens() {
		ApiService apiService = ApiClient.getClient(LoginActivity.this).create(ApiService.class);
		Call<StylesResponse> operatorCall = apiService.getStyles(AUTH);
		operatorCall.enqueue(new Callback<StylesResponse>() {

			@Override
			public void onResponse(Call<StylesResponse> call, Response<StylesResponse> response) {
				style = response.body().getRows().get(0).getStyle();
				Log.d(TAG, "Response: " + style.toString());
				getScreens();
			}

			@Override
			public void onFailure(Call<StylesResponse> call, Throwable t) {
				Log.e(TAG, "Error: " + t);
				Toast.makeText(LoginActivity.this, "Unable to fetch style data", Toast.LENGTH_LONG).show();
			}
		});
	}

	private void getScreens() {
		ApiService apiService = ApiClient.getClient(LoginActivity.this).create(ApiService.class);
		Call<ScreensResponse> operatorCall = apiService.getScreens(AUTH);
		operatorCall.enqueue(new Callback<ScreensResponse>() {

			@Override
			public void onResponse(Call<ScreensResponse> call, Response<ScreensResponse> response) {
				screen = response.body().getRows().get(0).getScreen();
				Log.d(TAG, "Response: " + screen.toString());
			}

			@Override
			public void onFailure(Call<ScreensResponse> call, Throwable t) {
				Log.e(TAG, "Error: " + t);
				Toast.makeText(LoginActivity.this, "Unable to fetch screen data", Toast.LENGTH_LONG).show();
			}
		});
	}
}