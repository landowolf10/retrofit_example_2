package com.example.retrofitexample2.service

import com.example.retrofitexample2.model.Note
import retrofit2.Call
import retrofit2.http.GET

interface ApiServiceAlbum
{
    @GET("note")
    fun getAllAlbums(): Call<List<Note>>
}