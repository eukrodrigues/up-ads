package com.ti4all.agendaapp

import com.ti4all.agendaapp.api.GoogleBooksApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://www.googleapis.com/books/v1/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())  // Usando o Gson para converter a resposta em objetos
            .client(OkHttpClient())  // Cliente HTTP (opcional)
            .build()
    }

    val api: GoogleBooksApi by lazy {
        retrofit.create(GoogleBooksApi::class.java)
    }
}
