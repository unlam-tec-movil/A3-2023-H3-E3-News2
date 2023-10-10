package ar.edu.unlam.mobile2.mediastackapi

import ar.edu.unlam.mobile.scaffold.mobile2.mediastackapi.data.NewRepository

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