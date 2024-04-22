package com.example.mobuloustask.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.mobuloustask.base.BaseViewModel
import com.example.mobuloustask.model.AlbumsListResponse
import com.example.mobuloustask.model.PostListResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AlbumsListViewModel() : BaseViewModel() {
    val albumsListResponse = MutableLiveData<AlbumsListResponse>()
    var errorPost = MutableLiveData<Throwable>()
    var progressPost = MutableLiveData<Boolean>()

    fun hitAlbumsList(

    ) {
        var dis = apiInterface.getAlbums(

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

    private fun onSuccess(it: AlbumsListResponse) {
        albumsListResponse.value = it
    }

    private fun onError(it: Throwable) {
        errorPost.value = it
    }

}