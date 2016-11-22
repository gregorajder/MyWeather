package com.gregorajdergmail.myweather.di;

import com.gregorajdergmail.myweather.di.modules.ViewModule;
import com.gregorajdergmail.myweather.presenter.viewObject.ForecastVO;
import com.gregorajdergmail.myweather.view.ForecastListFragment;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {ViewModule.class})
public interface AppComponent {
    void inject(ForecastListFragment forecastListFragment);

    void inject(ForecastVO forecastVO);
}

