package com.example.retrofitnasaapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val API_KEY ="nRyktRw6BYqlpFbMi9Pg6DGy8TMzI0qgIRtrR40d"
    var nasaData : NasaData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var apiInterface = ApiClient.client?.create(ApiInterface::class.java)
        var apiCall = apiInterface?.allList(API_KEY)

        apiCall?.enqueue(object : retrofit2.Callback<NasaData>{
            override fun onFailure(call: Call<NasaData>?, t: Throwable?) {
                Log.e("hata",""+t?.printStackTrace())
            }

            override fun onResponse(call: Call<NasaData>?, response: Response<NasaData>?) {
                nasaData = response?.body()
                tvTitle.text = nasaData?.title.toString()
                tvDate.text = nasaData?.date.toString()
                Picasso.get().load(nasaData?.url).into(imgURL)
            }


        })
    }
}