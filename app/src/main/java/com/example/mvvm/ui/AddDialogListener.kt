package com.example.mvvm.ui

import com.example.mvvm.data.entity.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClick(item : ShoppingItem)
}