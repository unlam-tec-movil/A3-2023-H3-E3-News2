package ar.edu.unlam.mobile.scaffold.mobile2.data.mediastack.repository

import ar.edu.unlam.mobile.scaffold.mobile2.data.mediastack.network.NewsResponse
import retrofit2.http.GET

interface MediastackApi {
    @GET(
        "v1/news?access_key=628ab40fd8731b79ed6d5ee488337e58" +
            "&limit=10",
    )
    suspend fun getNews(): NewsResponse
}
