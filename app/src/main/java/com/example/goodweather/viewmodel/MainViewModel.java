package com.example.goodweather.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.example.goodweather.bean.SearchCityResponse;
import com.example.goodweather.repository.SearchCityRepository;
import com.example.library.base.BaseViewModel;

/**
 * 主页面ViewModel
 * {@link com.example.goodweather.MainActivity}
 */
public class MainViewModel extends BaseViewModel {

    public MutableLiveData<SearchCityResponse> searchCityResponseMutableLiveData = new MutableLiveData<>();

    /**
     * 搜索成功
     * @param cityName 城市名称
     */
    public void searchCity(String cityName) {
        new SearchCityRepository().searchCity(searchCityResponseMutableLiveData, failed, cityName);
    }
}
