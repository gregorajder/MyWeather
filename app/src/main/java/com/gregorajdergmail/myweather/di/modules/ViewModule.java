package com.gregorajdergmail.myweather.di.modules;

import com.gregorajdergmail.myweather.presenter.ForecastPresenter;
import com.gregorajdergmail.myweather.presenter.viewObject.ForecastVO;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModule {
    @Provides
    ForecastPresenter provideForecastPresenter() {
        return new ForecastPresenter();
    }

    @Provides
    @Singleton
    ForecastVO provideForecastVO() {
        return new ForecastVO();
    }


}
