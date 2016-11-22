package com.gregorajdergmail.myweather.presenter.mapper;

import com.gregorajdergmail.myweather.model.dto.ForecastDTO;
import com.gregorajdergmail.myweather.model.dto.List;
import com.gregorajdergmail.myweather.presenter.viewObject.ForecastItemVO;
import com.gregorajdergmail.myweather.presenter.viewObject.ForecastVO;
import com.gregorajdergmail.myweather.util.MyUtils;

import java.util.ArrayList;

import rx.functions.Func1;

public class ForecastListMapper implements Func1<ForecastDTO, ForecastVO> {
    private ForecastVO forecastVO;

    public ForecastListMapper(ForecastVO forecastVO) {
        this.forecastVO = forecastVO;
    }

    @Override
    public ForecastVO call(ForecastDTO forecastDTO) {
        forecastVO.setCityId(forecastDTO.getCity().getId());
        forecastVO.setCityName(forecastDTO.getCity().getName());
        forecastVO.setCountry(forecastDTO.getCity().getCountry());
        ArrayList<ForecastItemVO> list = new ArrayList<ForecastItemVO>();

        ArrayList<com.gregorajdergmail.myweather.model.dto.List> forecastItemList = (ArrayList<List>) forecastDTO.getList();
        for (com.gregorajdergmail.myweather.model.dto.List forecastItem : forecastItemList) {
            ForecastItemVO forecastItemVO = new ForecastItemVO();
            forecastItemVO.setDate(MyUtils.convertDate(forecastItem.getDt()));
            forecastItemVO.setMorningTemp(forecastItem.getTemp().getMorn() + "°C");
            forecastItemVO.setDayTemp(forecastItem.getTemp().getDay() + "°C");
            forecastItemVO.setEveTemp(forecastItem.getTemp().getEve() + "°C");
            forecastItemVO.setNightTemp(forecastItem.getTemp().getNight() + "°C");
            forecastItemVO.setImage(forecastItem.getWeather().get(0).getIcon());
            forecastItemVO.setDescription(forecastItem.getWeather().get(0).getDescription());
            forecastItemVO.setWindSpeed(forecastItem.getSpeed());
            forecastItemVO.setWindDeg(forecastItem.getDeg());
            forecastItemVO.setClowds(forecastItem.getClouds());
            list.add(forecastItemVO);
        }

        forecastVO.setList(list);

        return forecastVO;
    }
}
