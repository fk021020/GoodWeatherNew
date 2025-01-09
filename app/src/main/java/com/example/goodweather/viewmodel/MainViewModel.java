package com.example.goodweather.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.example.goodweather.db.bean.DailyResponse;
import com.example.goodweather.db.bean.LifestyleResponse;
import com.example.goodweather.db.bean.NowResponse;
import com.example.goodweather.db.bean.Province;
import com.example.goodweather.db.bean.SearchCityResponse;
import com.example.goodweather.repository.CityRepository;
import com.example.goodweather.repository.SearchCityRepository;
import com.example.goodweather.repository.WeatherRepository;
import com.example.library.base.BaseViewModel;

import java.util.List;

/**
 * 主页面ViewModel
 * {@link com.example.goodweather.ui.MainActivity}
 */
public class MainViewModel extends BaseViewModel {

    public MutableLiveData<SearchCityResponse> searchCityResponseMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<NowResponse> nowResponseMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<DailyResponse> dailyResponseMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<LifestyleResponse> lifestyleResponseMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<List<Province>> cityMutableLiveData = new MutableLiveData<>();

    /**
     * 搜索城市
     *
     * @param cityName 城市名称
     */
    public void searchCity(String cityName) {
        SearchCityRepository.getInstance().searchCity(searchCityResponseMutableLiveData, failed, cityName);
    }

    /**
     * 实况天气
     *
     * @param cityId 城市ID
     */
    public void nowWeather(String cityId) {
        WeatherRepository.getInstance().nowWeather(nowResponseMutableLiveData, failed, cityId);
    }

    /**
     * 天气预报
     *
     * @param cityId 城市ID
     */
    public void dailyWeather(String cityId) {
        WeatherRepository.getInstance().dailyWeather(dailyResponseMutableLiveData, failed, cityId);
    }

    /**
     * 生活指数
     *
     * @param cityId 城市ID
     */
    public void lifestyle(String cityId) {
        WeatherRepository.getInstance().lifestyle(lifestyleResponseMutableLiveData, failed, cityId);
    }

    /**
     * 获取行政区数据
     */
    public void getAllCity() {
        CityRepository.getInstance().getCityData(cityMutableLiveData);
    }
}
