package ar.edu.unlam.mobile2.data.mediastack.repository

import ar.edu.unlam.mobile2.domain.mediastack.models.New
import ar.edu.unlam.mobile2.data.mediastack.repository.NewRepository

class GetNews(
    private val repository: NewRepository,
) {
    suspend fun getNews(): List<New>{
        return repository.getNews()
    }

    suspend fun updateNew(new: New){
        repository.updateNewInDatabase(new)
    }

}