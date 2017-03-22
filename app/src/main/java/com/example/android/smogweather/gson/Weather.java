package com.example.android.smogweather.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rhoeasy on 2017/3/22.
 */

public class Weather {

    public String status;

    public Basic mBasic;

    public AQI mAQI;

    public Now mNow;

    public Suggestion mSuggestion;

    @SerializedName("daily_forecast")
    public List<Forecast> mForecastList;
}
