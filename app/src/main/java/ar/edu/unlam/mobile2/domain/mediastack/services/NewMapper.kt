package ar.edu.unlam.mobile2.domain.mediastack.services

import ar.edu.unlam.mobile2.domain.mediastack.models.New
import ar.edu.unlam.mobile2.data.mediastack.network.Data
import ar.edu.unlam.mobile2.data.mediastack.local.entity.NewEntity


fun Data.toDomain(): New {
    return New(
        id = null,
        author = this.author,
        category = this.category,
        country = this.country,
        description = this.description,
        image = this.image,
        language = this.language,
        publishedAt = this.publishedAt,
        source = this.source,
        title = this.title,
        url = this.url,
    )
}


fun New.toEntity(): NewEntity {
    return NewEntity(
        id = this.id,
        author = this.author,
        category = this.category,
        country = this.country,
        description = this.description,
        image = this.image,
        language = this.language,
        publishedAt = this.publishedAt,
        source = this.source,
        title = this.title,
        url = this.url,
        saved = this.saved
    )
}

fun NewEntity.toDomain(): New {
    return New(
        id = this.id,
        author = this.author,
        category = this.category,
        country = this.country,
        description = this.description,
        image = this.image,
        language = this.language,
        publishedAt = this.publishedAt,
        source = this.source,
        title = this.title,
        url = this.url,
        saved = this.saved
    )
}