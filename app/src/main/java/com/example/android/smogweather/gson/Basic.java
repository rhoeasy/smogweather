package com.example.android.smogweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rhoeasy on 2017/3/22.
 */

public class Basic {

    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update mUpdate;

    public class Update{

        @SerializedName("loc")
        public String updateTime;

    }

}
