package com.example.mvvm.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.data.entity.ShoppingItem
import com.example.mvvm.ui.ShoppingViewModel

class ShoppingItemAdapter(
    var items : List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) :RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item,parent,false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = items[position]
       holder.tvName.text = curShoppingItem.name
        holder.tvAmount.text = "${curShoppingItem.amount}"
        holder.btnDelete.setOnClickListener {
            viewModel.delete(curShoppingItem)
        }
        holder.btnPlus.setOnClickListener {
            curShoppingItem.amount++
            viewModel.insert(curShoppingItem)
        }
        holder.btnMinus.setOnClickListener {
            if(curShoppingItem.amount > 0){
                curShoppingItem.amount--
                viewModel.insert(curShoppingItem)
            }

        }

    }


    class ShoppingViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvAmount: TextView = itemView.findViewById(R.id.tvAmount)
        val btnMinus : ImageView  = itemView.findViewById(R.id.Minus)
        val btnPlus : ImageView = itemView.findViewById(R.id.Plus)
        val btnDelete : ImageView = itemView.findViewById(R.id.delete)

    }

}