package com.example.android.smogweather;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.smogweather.db.City;
import com.example.android.smogweather.db.County;
import com.example.android.smogweather.db.Province;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rhoeasy on 2017/3/15.
 */

public class ChooseAreaFragment extends Fragment {

    public static final int LEVEL_PROVINCE = 0;

    public static final int LEVEL_CITY = 1;

    public static final int LEVEL_county = 2;

    private ProgressDialog mProgressDialog;

    private TextView mTextView;

    private Button backButton;

    private ListView mListView;

    private ArrayAdapter<String> mAdapter;

    private List<String> dataList = new ArrayList<>();

    /**
     * 三个列表
     */
    private List<Province> mProvinceList;
    private List<City> mCityList;
    private List<County> mCountyList;

    /**
     * 三个被选中的item
     */
    private Province selectedProvince;
    private City selectedCity;
    private County selectedCounty;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
