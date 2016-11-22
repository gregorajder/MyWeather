package com.gregorajdergmail.myweather.model.api;

import com.gregorajdergmail.myweather.model.dto.ForecastDTO;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiInterfaceOpenWeather {

    @GET ("/data/2.5/forecast/daily")
    Observable <ForecastDTO> getForecast (@Query("id") int cityId ,@Query("cnt") int cnt, @Query("units") String units, @Query("APPID") String appId );
}
