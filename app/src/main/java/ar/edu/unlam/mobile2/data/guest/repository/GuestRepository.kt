package ar.edu.unlam.mobile2.data.guest.repository

import ar.edu.unlam.mobile2.data.guest.local.GuestDao
import ar.edu.unlam.mobile2.domain.guest.models.Guest
import ar.edu.unlam.mobile2.domain.guest.services.toEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class GuestRepository (private val dao: GuestDao) {
    suspend fun addGuestInDatabase(guest: Guest) {
        dao.insertGuest(guest.toEntity())
    }

    suspend fun verifyDatabase(): Boolean {
        return dao.getGuests().isNotEmpty()
    }

}