package ar.edu.unlam.mobile2.data.mediastack.repository

import ar.edu.unlam.mobile2.domain.mediastack.models.New
import ar.edu.unlam.mobile2.data.mediastack.repository.NewRepository

class GetNews(
    private val repository: NewRepository,
) {
    suspend fun getNews(): List<New> {
        return repository.getNews()
    }

    suspend fun updateNew(new: New) {
        repository.updateNewInDatabase(new)
    }

    suspend fun createLocalNew(
        autor: String? = "null",
        category: String? = "null",
        country: String? = "null",
        description: String? = "null",
        image: String? = "null",
        language: String? = "null",
        publishedAt: String? = "null",
        source: String? = "null",
        title: String? = "null",
        url: String? = "null",
        saved: Boolean = false,
    ) {
        repository.createLocalNew(
            autor,
            category,
            country,
            description,
            image,
            language,
            publishedAt,
            source,
            title,
            url,
            saved
        )
    }
}