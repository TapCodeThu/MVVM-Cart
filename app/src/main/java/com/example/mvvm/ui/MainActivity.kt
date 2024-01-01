package com.example.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.data.database.ShoppingDatabase
import com.example.mvvm.data.entity.ShoppingItem
import com.example.mvvm.data.repository.ShoppingRepository
import com.example.mvvm.other.ShoppingItemAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView   = findViewById<RecyclerView>(R.id.recyclerview)
        val fab = findViewById<FloatingActionButton>(R.id.floatingAdd)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProvider(this,factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingItemAdapter(listOf(),viewModel)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })
        fab.setOnClickListener {
            AddShoppingItemDialog(this,
                object  : AddDialogListener{
                    override fun onAddButtonClick(item: ShoppingItem) {
                        viewModel.insert(item)
                    }

                }).show()
        }

    }
}