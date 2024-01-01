package com.example.mvvm.data.repository

import com.example.mvvm.data.database.ShoppingDatabase
import com.example.mvvm.data.entity.ShoppingItem

class ShoppingRepository(
    private val db : ShoppingDatabase
) {
    suspend fun insert(item : ShoppingItem) = db.getShoppingDao().insert(item)
    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItem()
}