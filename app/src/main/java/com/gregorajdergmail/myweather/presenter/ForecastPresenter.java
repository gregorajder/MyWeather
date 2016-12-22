package com.gregorajdergmail.myweather.presenter;

import com.gregorajdergmail.myweather.model.Model;
import com.gregorajdergmail.myweather.presenter.mapper.ForecastListMapper;
import com.gregorajdergmail.myweather.presenter.viewObject.ForecastVO;
import com.gregorajdergmail.myweather.util.Log;

import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.Subscriptions;


public class ForecastPresenter {

    private Model model = new Model();
    private Subscription subscription = Subscriptions.empty();
    private ForecastListMapper forecastListMapper;
    private ForecastVO forecastVO;

    public void attachViewObject(ForecastVO forecastVO){
        this.forecastVO = forecastVO;
        forecastListMapper = new ForecastListMapper(this.forecastVO);
    }

    public void getFilmsList(int id) {

        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }

        subscription = model.getForecast(id)
                .map(forecastListMapper)
                .subscribe(new Action1<ForecastVO>() {

                    @Override
                    public void call(ForecastVO forecastVO) {
                        forecastVO.notifyChange();
                        subscription.unsubscribe();
                        Log.d();
                    }
                });

    }
}