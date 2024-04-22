package com.example.mobuloustask.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.mobuloustask.base.BaseViewModel
import com.example.mobuloustask.model.AlbumsListResponse
import com.example.mobuloustask.model.PhotosListResponse
import com.example.mobuloustask.model.PostListResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PhotosListViewModel() : BaseViewModel() {
    val photosListResponse = MutableLiveData<PhotosListResponse>()
    var errorPost = MutableLiveData<Throwable>()
    var progressPost = MutableLiveData<Boolean>()

    fun hitPhotosList(

    ) {
        var dis = apiInterface.getPhotos(

        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                progressPost.value = true
            }.doOnTerminate {
                progressPost.value = false
            }
            .subscribe({
                onSuccess(it)
            },
                {
                    onError(it)
                })
    }

    private fun onSuccess(it: PhotosListResponse) {
        photosListResponse.value = it
    }

    private fun onError(it: Throwable) {
        errorPost.value = it
    }

}