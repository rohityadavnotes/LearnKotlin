package com.learn.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learn.kotlin.adapter.FoodRecyclerAdapter
import com.learn.kotlin.model.Food

class FoodActivity : AppCompatActivity() {

    companion object {
        private val TAG : String = FoodActivity::class.java.simpleName
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodRecyclerAdapter: FoodRecyclerAdapter
    private var foodList = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        title = "Recycler View"

        initializeView()
        initializeObject()
        initializeToolBar()
        initializeCallbackListener()
        addTextChangedListener()
        setOnClickListener()
    }

    private fun initializeView() {
        recyclerView   = findViewById(R.id.recyclerView)
    }

    private fun initializeObject() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@FoodActivity)
            foodRecyclerAdapter = FoodRecyclerAdapter(this@FoodActivity, foodList)
            adapter = foodRecyclerAdapter
        }

        prepareItems()

        foodRecyclerAdapter.setData(createData())
    }

    private fun initializeToolBar() {
    }

    private fun initializeCallbackListener() {
    }

    private fun addTextChangedListener() {
    }

    private fun setOnClickListener() {
    }

    private fun items(): List<Food> {
        return listOf(Food("https://cdn.stocksnap.io/img-thumbs/280h/cookies-dessert_ATABRZWSAD.jpg", "Cookies", "Cookies Dessert"),
                Food("https://cdn.stocksnap.io/img-thumbs/280h/cookies-dessert_ATABRZWSAD.jpg", "Cookies", "Cookies Dessert"),
                Food("https://cdn.stocksnap.io/img-thumbs/280h/cookies-dessert_ATABRZWSAD.jpg", "Cookies", "Cookies Dessert"),
                Food("https://cdn.stocksnap.io/img-thumbs/280h/cookies-dessert_ATABRZWSAD.jpg", "Cookies", "Cookies Dessert"),
                Food("https://cdn.stocksnap.io/img-thumbs/280h/cookies-dessert_ATABRZWSAD.jpg", "Cookies", "Cookies Dessert"),
                Food("https://cdn.stocksnap.io/img-thumbs/280h/cookies-dessert_ATABRZWSAD.jpg", "Cookies", "Cookies Dessert"),
                Food("https://cdn.stocksnap.io/img-thumbs/280h/cookies-dessert_ATABRZWSAD.jpg", "Cookies", "Cookies Dessert"),
                Food("https://cdn.stocksnap.io/img-thumbs/280h/cookies-dessert_ATABRZWSAD.jpg", "Cookies 12", "Cookies Dessert 1")
        )
    }

    private fun prepareItems() {
        var food = Food("https://cdn.stocksnap.io/img-thumbs/280h/cookies-dessert_ATABRZWSAD.jpg", "Cookies", "Cookies Dessert")
        foodList.add(food)

        food = Food("https://cdn.stocksnap.io/img-thumbs/280h/cookies-dessert_ATABRZWSAD.jpg", "Cookies", "Cookies Dessert")
        foodList.add(food)

        food = Food("https://cdn.stocksnap.io/img-thumbs/280h/cookies-dessert_ATABRZWSAD.jpg", "Cookies", "Cookies Dessert")
        foodList.add(food)

        foodRecyclerAdapter.notifyDataSetChanged()
    }

    private fun createData() : List<Food> {
        val list = ArrayList<Food>()

        list.add(Food("https://cdn.stocksnap.io/img-thumbs/280h/cookies-dessert_ATABRZWSAD.jpg", "Cookies", "Cookies Dessert"))
        list.add(Food("https://cdn.stocksnap.io/img-thumbs/280h/cookies-dessert_ATABRZWSAD.jpg", "Cookies", "Cookies Dessert"))

        return list
    }
}