package ar.edu.unlam.mobile2.domain.guest.services

import ar.edu.unlam.mobile2.data.guest.local.entity.GuestEntity
import ar.edu.unlam.mobile2.domain.guest.models.Guest

fun GuestEntity.toDomain(): Guest {
    return Guest(id = this.id, username = this.username)
}

fun Guest.toEntity(): GuestEntity {
    return GuestEntity(id = this.id, username = this.username)
}
