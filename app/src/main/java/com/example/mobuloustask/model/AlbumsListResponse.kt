package com.example.mobuloustask.model

class AlbumsListResponse : ArrayList<AlbumsListResponse.AlbumsListResponseItem>(){
    data class AlbumsListResponseItem(
        val id: Int,
        val title: String,
        val userId: Int
    )
}