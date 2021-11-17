package com.example.retrofitexample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitexample2.adapter.NoteAdapter
import com.example.retrofitexample2.model.Note
import com.example.retrofitexample2.service.ApiServiceAlbum
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var service: ApiServiceAlbum
    lateinit var rvAlbum: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()

        service = initRetrofit().create(ApiServiceAlbum::class.java)

        getData()
    }

    private fun getData()
    {
        service.getAllAlbums().enqueue(object: Callback<List<Note>> {
            override fun onResponse(call: Call<List<Note>>, response: Response<List<Note>>) {
                val note = response?.body()
                rvAlbum.adapter = note?.let { NoteAdapter(it) }
            }

            override fun onFailure(call: Call<List<Note>>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }
        })
    }

    private fun initRecycler()
    {
        rvAlbum = findViewById(R.id.recycler_view)
        rvAlbum.layoutManager = LinearLayoutManager(this)
    }

    private fun initRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}