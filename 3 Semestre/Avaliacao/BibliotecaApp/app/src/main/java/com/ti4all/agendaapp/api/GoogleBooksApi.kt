package com.ti4all.agendaapp.api

import com.ti4all.agendaapp.data.api.BooksResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface GoogleBooksApi {
    @GET("volumes")
    fun searchBooksByTitle(
        @Query("q") title: String,
        @Query("maxResults") maxResults: Int = 10
    ): Call<BooksResponse>
}
