package ar.edu.unlam.mobile.scaffold.mobile2.mediastackapi.data.mapper

import ar.edu.unlam.mobile.scaffold.mobile2.mediastackapi.data.api.response.Data
import ar.edu.unlam.mobile.scaffold.mobile2.mediastackapi.data.local.entity.NewEntity
import ar.edu.unlam.mobile2.mediastackapi.New

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
        saved = this.saved,
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
        saved = this.saved,
    )
}
