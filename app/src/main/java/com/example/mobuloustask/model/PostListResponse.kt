package com.example.mobuloustask.model

class PostListResponse : ArrayList<PostListResponse.PostListResponseItem>(){
    data class PostListResponseItem(
        val body: String,
        val id: Int,
        val title: String,
        val userId: Int
    )
}