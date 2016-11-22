package com.gregorajdergmail.myweather.presenter.viewObject;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.gregorajdergmail.myweather.util.LoggingListener;


public class ForecastItemVO extends BaseObservable {
    private String date;
    private String morningTemp;
    private String dayTemp;
    private String eveTemp;
    private String nightTemp;
    private String image;
    private String description;
    private double windSpeed;
    private int windDeg;
    private Integer clowds;

    @BindingAdapter("forecast_icon")
    public static void setForecastIcon(ImageView imageView, String icon) {
        Glide.with(imageView.getContext()).load("http://openweathermap.org/img/w/" + icon + ".png")
                .listener(new LoggingListener())
                .into(imageView);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMorningTemp() {
        return morningTemp;
    }

    public void setMorningTemp(String morningTemp) {
        this.morningTemp = morningTemp;
    }

    public String getDayTemp() {
        return dayTemp;
    }

    public void setDayTemp(String dayTemp) {
        this.dayTemp = dayTemp;
    }

    public String getEveTemp() {
        return eveTemp;
    }

    public void setEveTemp(String eveTemp) {
        this.eveTemp = eveTemp;
    }

    public String getNightTemp() {
        return nightTemp;
    }

    public void setNightTemp(String nightTemp) {
        this.nightTemp = nightTemp;
    }

    @Bindable
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(int windDeg) {
        this.windDeg = windDeg;
    }

    public Integer getClowds() {
        return clowds;
    }

    public void setClowds(Integer clowds) {
        this.clowds = clowds;
    }


}
