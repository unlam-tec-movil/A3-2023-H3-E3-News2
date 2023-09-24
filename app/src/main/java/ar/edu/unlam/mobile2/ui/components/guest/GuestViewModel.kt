package ar.edu.unlam.mobile2.ui.components.guest

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
    private fun crearUsuario(name: String): Guest{
        return Guest(1, name)
    }

    fun actualizarBase(name: String){
        val guest = crearUsuario(name)
        viewModelScope.launch {
            repository.addGuestInDatabase(guest)
        }
    }

    fun verificarBaseNoEstaVacia(): Boolean {
        viewModelScope.launch {
            
        }

    }
}