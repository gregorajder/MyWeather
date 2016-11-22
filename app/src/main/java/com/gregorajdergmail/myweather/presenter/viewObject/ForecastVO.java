package com.gregorajdergmail.myweather.presenter.viewObject;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.gregorajdergmail.myweather.App;
import com.gregorajdergmail.myweather.presenter.ForecastPresenter;
import com.gregorajdergmail.myweather.util.Log;
import com.gregorajdergmail.myweather.view.adapter.WeatherItemRecyclerViewAdapter;

import java.util.List;

import javax.inject.Inject;

public class ForecastVO extends BaseObservable {
    private List<ForecastItemVO> list;
    @Inject
    protected ForecastPresenter forecastPresenter;
    private int CityId;
    private String CityName;
    private String Country;
    private Boolean first = true;

    public ForecastVO(){
        Log.d();
    }

    public void onAttach(){
        if (first) {
            Log.d();
            App.getComponent().inject(this);
            forecastPresenter.attachViewObject(this);
            forecastPresenter.getFilmsList(700569);
            first = false;
        }
    }

    @BindingAdapter("ListData")
    public static void setListData(RecyclerView recyclerView, List<ForecastItemVO> filmListItemVOList) {
        Log.d();
        if (filmListItemVOList != null) {
            Log.d();
            WeatherItemRecyclerViewAdapter weatherItemRecyclerViewAdapter = new WeatherItemRecyclerViewAdapter(filmListItemVOList, null);
            recyclerView.setAdapter(weatherItemRecyclerViewAdapter);
        }
    }

    @Bindable
    public List<ForecastItemVO> getList() {
        return list;
    }

    public void setList(List<ForecastItemVO> list) {
        this.list = list;
    }

    public int getCityId() {
        return CityId;
    }

    public void setCityId(int cityId) {
        CityId = cityId;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

}
