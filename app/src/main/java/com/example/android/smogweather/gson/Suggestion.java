package com.example.android.smogweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rhoeasy on 2017/3/22.
 */

public class Suggestion {

    @SerializedName("comf")
    public Comfort mComfort;

    @SerializedName("cw")
    public CarWash mCarWash;

    public Sport mSport;


    private class Comfort {

        @SerializedName("txt")
        public String info;

    }

    private class CarWash {

        @SerializedName("txt")
        public String info;

    }

    private class Sport {

        @SerializedName("txt")
        public String info;
        
    }
}
