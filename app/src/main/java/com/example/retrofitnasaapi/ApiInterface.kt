package com.example.retrofitnasaapi

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    //https://api.nasa.gov/planetary/apod?api_key=nRyktRw6BYqlpFbMi9Pg6DGy8TMzI0qgIRtrR40d
    @GET("planetary/apod?")
    fun allList(@Query("api_key")api_key: String):retrofit2.Call<NasaData>
}