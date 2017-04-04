package com.example.android.smogweather.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.annotation.IntDef;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.android.smogweather.R;
import com.example.android.smogweather.WeatherActivity;
import com.example.android.smogweather.gson.Weather;
import com.example.android.smogweather.util.HttpUtil;
import com.example.android.smogweather.util.Utility;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class AQIService extends Service {
    public AQIService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String weatherString = prefs.getString("weather", null);
        if (weatherString != null) {
            // 有缓存时直接解析天气数据
            Weather weather = Utility.handleWeatherResponse(weatherString);
            String weatherAQI = weather.aqi.city.pm25;
            Log.d("aqi", weatherAQI);
            if (Integer.parseInt(weatherAQI) > 50) {
                Intent intent1 = new Intent(this, WeatherActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent1, 0);
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle("当前pm2.5值超过了50,为" + weatherAQI)
                        .setContentText("请减少出门,如果要出门请戴口罩,帽子.")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher_round)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher_round))
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .build();
                manager.notify(1, notification);
            }
        }
            return super.onStartCommand(intent, flags, startId);
    }
}
