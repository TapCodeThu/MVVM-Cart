package com.example.mvvm.ui

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.mvvm.R
import com.example.mvvm.data.entity.ShoppingItem

class AddShoppingItemDialog(context: Context,var addDialogListener: AddDialogListener) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add)
        val btnAdd = findViewById<Button>(R.id.btnDialogAdd)
        val btnHuy = findViewById<Button>(R.id.btnDialogCancel)
        val edtName = findViewById<EditText>(R.id.edtName)
        val edtAmount = findViewById<EditText>(R.id.edtAmount)

        btnAdd?.setOnClickListener {
            val name = edtName?.text.toString().trim()
            val amount = edtAmount?.text.toString().trim()
            if(name.isEmpty() || amount.isEmpty()){
               Toast.makeText(context, "Khong de trong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val item = ShoppingItem(name,amount.toInt())
            addDialogListener.onAddButtonClick(item)
            dismiss()
        }
        btnHuy?.setOnClickListener {
            cancel()
        }

    }
}