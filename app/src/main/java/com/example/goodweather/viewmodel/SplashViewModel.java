package com.example.goodweather.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.example.goodweather.db.bean.Province;
import com.example.goodweather.repository.CityRepository;
import com.example.library.base.BaseViewModel;

import java.util.List;

/**
 * 启动页ViewModel
 * {@link com.example.goodweather.ui.SplashActivity}
 */
public class SplashViewModel extends BaseViewModel {

    public MutableLiveData<List<Province>> listMutableLiveData = new MutableLiveData<>();

    /**
     * 添加城市数据
     */
    public void addCityData(List<Province> provinceList) {
        CityRepository.getInstance().addCityData(provinceList);
    }

    /**
     * 获取所有城市数据
     */
    public void getAllCityData() {
        CityRepository.getInstance().getCityData(listMutableLiveData);
    }
}

