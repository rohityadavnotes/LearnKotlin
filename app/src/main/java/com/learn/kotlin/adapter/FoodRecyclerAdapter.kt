package com.learn.kotlin.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.learn.kotlin.R
import com.learn.kotlin.model.Food

class FoodRecyclerAdapter(private var activity: Activity, private var list: List<Food>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items = ArrayList<Food>()

    init {
        this.items = list as ArrayList<Food>
    }

    fun setData(foods: List<Food>) {
        items.clear()
        items.addAll(foods)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_row, parent, false)
        return FoodViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FoodViewHolder -> {
                holder.bind(activity, items.get(position))
            }
        }
    }
}
