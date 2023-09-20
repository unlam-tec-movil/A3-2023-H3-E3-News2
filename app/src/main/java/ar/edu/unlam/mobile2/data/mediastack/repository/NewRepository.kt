package ar.edu.unlam.mobile2.data.mediastack.repository

import ar.edu.unlam.mobile2.domain.mediastack.models.New
import ar.edu.unlam.mobile2.data.mediastack.local.NewDao
import ar.edu.unlam.mobile2.domain.mediastack.services.toDomain
import ar.edu.unlam.mobile2.domain.mediastack.services.toEntity
import java.lang.Exception

class NewRepository(
    private val api: MediastackApi,
    private val dao: NewDao
) {

    suspend fun updateNewInDatabase(new: New){
        dao.insertNew(new.toEntity())
    }

    suspend fun getNews(): List<New> {
        var localNews = dao.getNews()

        val newsFromApi = getNewsFromApi()

        if(localNews != newsFromApi){
            newsFromApi.forEach {
                dao.insertNew(it.toEntity())
            }
            localNews = dao.getNews()
        }

        return localNews.map { it.toDomain() }
    }

    private suspend fun getNewsFromApi(): List<New> {
        return try {
            val response = api.getNews()
            response.data.map { it.toDomain() }
        } catch (e: Exception) {
            emptyList()
        }
    }
}