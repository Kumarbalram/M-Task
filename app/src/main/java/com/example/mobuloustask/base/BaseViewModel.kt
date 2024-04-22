package com.example.mobuloustask.base

import androidx.lifecycle.ViewModel
import com.example.mobuloustask.utils.RetrofitUtil
import com.example.mobuloustask.apiservises.ApiServices

open class BaseViewModel : ViewModel() {

    val apiInterface: ApiServices by lazy {
        RetrofitUtil.apiService()
    }
}