package com.example.goodweather.repository;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.goodweather.Constant;
import com.example.goodweather.api.ApiService;
import com.example.goodweather.bean.NowResponse;
import com.example.library.network.ApiType;
import com.example.library.network.NetworkApi;
import com.example.library.network.observer.BaseObserver;

/**
 * 天气存储库，数据处理
 * (实况天气)
 */
@SuppressLint("CheckResult")
public class WeatherRepository {

    private static final String TAG = WeatherRepository.class.getSimpleName();

    /**
     * 实况天气
     *
     * @param responseLiveData 成功数据
     * @param failed           错误信息
     * @param cityId           城市ID
     */
    public void nowWeather(MutableLiveData<NowResponse> responseLiveData,
                           MutableLiveData<String> failed, String cityId) {
        String type = "实时天气-->";
        NetworkApi.createService(ApiService.class, ApiType.WEATHER).nowWeather(cityId)
                .compose(NetworkApi.applySchedulers(new BaseObserver<>() {
                    @Override
                    public void onSuccess(NowResponse nowResponse) {
                        if (nowResponse == null) {
                            failed.postValue("实况天气数据为null，请检查城市ID是否正确。");
                            return;
                        }
                        //请求接口成功返回数据，失败返回状态码
                        if (Constant.SUCCESS.equals(nowResponse.getCode())) {
                            responseLiveData.postValue(nowResponse);
                        } else {
                            failed.postValue(type + nowResponse.getCode());
                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        Log.e(TAG, "onFailure: " + e.getMessage());
                        failed.postValue(type + e.getMessage());
                    }
                }));
    }
}
