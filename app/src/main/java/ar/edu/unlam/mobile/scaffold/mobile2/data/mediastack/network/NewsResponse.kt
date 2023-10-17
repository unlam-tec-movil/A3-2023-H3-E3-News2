package ar.edu.unlam.mobile.scaffold.mobile2.data.mediastack.network

import retrofit2.http.Query

data class NewsResponse(
    @Query("data")
    val data: List<Data>,
    @Query("pagination")
    val pagination: Pagination,
)
