package com.gregorajdergmail.myweather.model;


import com.gregorajdergmail.myweather.model.api.ApiInterfaceOpenWeather;
import com.gregorajdergmail.myweather.model.api.SampleAPI;
import com.gregorajdergmail.myweather.model.dto.ForecastDTO;
import com.gregorajdergmail.myweather.util.Log;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Model {
    String units= "metric";
    String APPID= "d8c76e185bec1afbd913f61ee58be313";
    int cnt = 16;
    private ApiInterfaceOpenWeather myApi = new SampleAPI();

    public Observable<ForecastDTO> getForecast (int cityId){
        Log.d();
        return myApi.getForecast(cityId, cnt, units,APPID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
