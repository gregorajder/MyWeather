package com.gregorajdergmail.myweather.model.api;

import com.gregorajdergmail.myweather.model.dto.ForecastDTO;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;
import rx.Observable;


public class SampleAPI implements  ApiInterfaceOpenWeather{

    public static ApiInterfaceOpenWeather getApiInterface() {

        Interceptor logging = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();



        Retrofit retrofit  = new Retrofit.Builder().
                baseUrl("http://api.openweathermap.org/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(ApiInterfaceOpenWeather.class);
    }

    @Override
    public Observable<ForecastDTO> getForecast(@Query("id") int cityId,@Query("cnt") int cnt, @Query("metric") String metric, @Query("APPID") String appId) {
        return getApiInterface().getForecast(cityId, cnt,  metric , appId);
    }
}
