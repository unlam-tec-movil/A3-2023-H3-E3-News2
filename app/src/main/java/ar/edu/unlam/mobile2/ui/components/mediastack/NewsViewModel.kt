package ar.edu.unlam.mobile2.ui.components.mediastack

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile2.data.mediastack.repository.GetNews
import ar.edu.unlam.mobile2.domain.mediastack.models.New
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNews: GetNews,
) : ViewModel() {
    private val _listaNoticias = MutableLiveData<List<New>>()
    val listaNoticias: LiveData<List<New>> = _listaNoticias

    private var state by mutableStateOf(NewState())

    fun guardarNoticiaLocal(
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
        viewModelScope.launch {
            getNews.createLocalNew(
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
                saved,
            )
        }
    }

    fun actualizarItem(item: New) {
        val currentList = _listaNoticias.value.orEmpty().toMutableList()

        val index = currentList.indexOfFirst { it.id == item.id }

        currentList[index] = item
        _listaNoticias.value = currentList
        actualizarItemEnBase(item)
    }

    fun actualizarItemEnBase(item: New) {
        viewModelScope.launch {
            getNews.updateNew(item)
        }
    }

    var notica: New =
        New(1, "null", "null", "null", "null", "null", "null", "null", "null", "null", "null")

    fun resivirNoticia(): New {
        return this.notica
    }

    fun enviarNotica(item: New) {
        this.notica = item
    }

    private val _isVisible = mutableStateOf(false)
    val isVisible: State<Boolean> = _isVisible

    fun hideItem() {
        _isVisible.value = false
    }

    fun showItem() {
        _isVisible.value = true
    }

    init {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
            )
            _listaNoticias.value = getNews.getNews()
            state = state.copy(
                isLoading = false,
            )
        }
    }
}
