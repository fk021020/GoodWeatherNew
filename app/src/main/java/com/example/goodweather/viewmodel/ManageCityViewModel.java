package com.example.goodweather.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.example.goodweather.db.bean.MyCity;
import com.example.goodweather.repository.CityRepository;
import com.example.library.base.BaseViewModel;

import java.util.List;

/**
 * 管理城市ViewModel
 * {@link com.example.goodweather.ui.ManageCityActivity}
 */
public class ManageCityViewModel extends BaseViewModel {

    public MutableLiveData<List<MyCity>> listMutableLiveData = new MutableLiveData<>();

    /**
     * 获取所有城市数据
     */
    public void getAllCityData() {
        CityRepository.getInstance().getMyCityData(listMutableLiveData);
    }
}
