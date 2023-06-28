package com.example.lab_05_jetpackpaging_cloudservice.util.paging

/* (1) Describes the type of items we want to paginate */
interface Paginator<Key, Item> {
    suspend fun loadNextItems()
    fun reset()
}