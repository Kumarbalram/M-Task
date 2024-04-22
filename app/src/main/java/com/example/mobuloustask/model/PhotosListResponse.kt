package com.example.mobuloustask.model

class PhotosListResponse : ArrayList<PhotosListResponse.PhotosListResponseItem>(){
    data class PhotosListResponseItem(
        val albumId: Int,
        val id: Int,
        val thumbnailUrl: String,
        val title: String,
        val url: String
    )
}