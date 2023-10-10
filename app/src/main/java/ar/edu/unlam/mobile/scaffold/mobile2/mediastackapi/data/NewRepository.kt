package ar.edu.unlam.mobile.scaffold.mobile2.mediastackapi.data

import ar.edu.unlam.mobile2.mediastackapi.New
import ar.edu.unlam.mobile.scaffold.mobile2.mediastackapi.data.api.MediastackApi
import ar.edu.unlam.mobile.scaffold.mobile2.mediastackapi.data.local.NewDao
import ar.edu.unlam.mobile.scaffold.mobile2.mediastackapi.data.mapper.toDomain
import ar.edu.unlam.mobile.scaffold.mobile2.mediastackapi.data.mapper.toEntity
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