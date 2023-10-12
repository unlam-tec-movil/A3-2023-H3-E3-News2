package ar.edu.unlam.mobile.scaffold.mobile2.mediastackapi.data.api.response

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
