package ar.edu.unlam.mobile2.ui.components.guest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile2.data.guest.repository.GuestRepository
import ar.edu.unlam.mobile2.domain.guest.models.Guest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GuestViewModel @Inject constructor(
    private val repository: GuestRepository
): ViewModel() {
    private val _existeGuest = MutableLiveData<Boolean>()
    val existeGuest: LiveData<Boolean> = _existeGuest

    private fun crearUsuario(name: String): Guest{
        return Guest(1, name)
    }

    fun actualizarBase(name: String){
        val guest = crearUsuario(name)
        viewModelScope.launch {
            repository.addGuestInDatabase(guest)
        }
    }

    init {
        viewModelScope.launch {
            _existeGuest.value = repository.verifyDatabase()
        }
    }

}