package com.example.mvvm.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm.data.entity.ShoppingItem

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insert(item : ShoppingItem)
    @Delete
   suspend fun delete(item : ShoppingItem)

   @Query("SELECT * FROM shopping_items")
   fun getAllShoppingItem() : LiveData<List<ShoppingItem>>
}