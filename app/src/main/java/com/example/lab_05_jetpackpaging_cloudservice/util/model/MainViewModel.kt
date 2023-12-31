package com.example.lab_05_jetpackpaging_cloudservice.util.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amplifyframework.datastore.generated.model.SensorData
import com.example.lab_05_jetpackpaging_cloudservice.util.paging.DefaultPaginator
import kotlinx.coroutines.launch

/* (4) */
class MainViewModel : ViewModel() {
    private val repository = Repository()

    var state by mutableStateOf(ScreenState())

    private val paginator = DefaultPaginator(
        initialKey = state.page,
        onLoadUpdated = {
            state = state.copy(isLoading = it)
        },
        onRequest = { nextPage ->
            repository.getItems(nextPage, 20)
        },
        getNextKey = {
            state.page + 1
        },
        onError = {
            state = state.copy(error = it?.localizedMessage)
        },
        onSuccess = { items, newKey ->
            state = state.copy(
                items = state.items + items,
                page = newKey,
                endReached = items.isEmpty()
            )
        }
    )

    init {
        loadNextItems()
    }

    fun loadNextItems() {
        viewModelScope.launch {
            paginator.loadNextItems()
        }
    }

    fun create(sensorLog: SensorLog) {
        repository.create(sensorLog)
    }

}


data class ScreenState(
    val isLoading: Boolean = false,
    val items: List<SensorData> = emptyList(),
    val error: String? = null,
    val endReached: Boolean = false,
    val page: Int = 0
)