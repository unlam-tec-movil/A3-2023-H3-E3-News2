package ar.edu.unlam.mobile2.data.mediastack.network

import retrofit2.http.Query

data class Pagination(
    @Query("count")
    val count: Int,
    @Query("limit")
    val limit: Int,
    @Query("offset")
    val offset: Int,
    @Query("total")
    val total: Int,
)
