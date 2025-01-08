package com.example.goodweather;

import com.baidu.location.LocationClient;
import com.example.library.base.BaseApplication;
import com.example.library.network.NetworkApi;

public class WeatherApp extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        //使用定位需要同意隐私合规政策
        LocationClient.setAgreePrivacy(true);
        //初始化网络框架
        NetworkApi.init(new NetworkRequiredInfo(this));
    }
}
