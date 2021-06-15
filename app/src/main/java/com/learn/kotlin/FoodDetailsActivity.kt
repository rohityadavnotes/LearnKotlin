package com.learn.kotlin

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class FoodDetailsActivity : AppCompatActivity() {

    companion object {
        private val TAG: String = FoodDetailsActivity::class.java.simpleName

        public const val IMAGE = "image"
        public const val NAME = "name"
        public const val DESCRIPTION = "description"

        fun getDetailIntent(
                context: Context,
                image: String,
                name: String,
                description: String
        ): Intent {
            val intent = Intent(context, FoodDetailsActivity::class.java)
            intent.putExtra(FoodDetailsActivity.IMAGE, image)
            intent.putExtra(FoodDetailsActivity.NAME, name)
            intent.putExtra(FoodDetailsActivity.DESCRIPTION, description)
            return intent
        }
    }

    lateinit var foodImageView: ImageView
    lateinit var nameTextView: TextView
    lateinit var descriptionTextView: TextView

    var foodImage: String? = null
    var foodName: String? = null
    var foodDescription: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)

        title = "Recycler View"

        initializeView()
        initializeObject()
        initializeToolBar()
        initializeCallbackListener()
        addTextChangedListener()
        setOnClickListener()
        display()
    }

    private fun initializeView() {
        foodImageView = findViewById(R.id.foodImageView)
        nameTextView = findViewById(R.id.nameTextView)
        descriptionTextView = findViewById(R.id.descriptionTextView)
    }

    private fun initializeObject() {
    }

    private fun initializeToolBar() {
    }

    private fun initializeCallbackListener() {
    }

    private fun addTextChangedListener() {
    }

    private fun setOnClickListener() {
    }

    private fun display() {
        foodImage = this.intent.getStringExtra(FoodDetailsActivity.IMAGE)
        foodName = this.intent.getStringExtra(FoodDetailsActivity.NAME)
        foodDescription = this.intent.getStringExtra(FoodDetailsActivity.DESCRIPTION)

        if (foodImage !== null) {
            Glide.with(this)
                    .load(foodImage)
                    .error(R.drawable.ic_launcher_background)
                    .listener(object : RequestListener<Drawable> {
                        override fun onLoadFailed(
                                e: GlideException?,
                                model: Any?,
                                target: Target<Drawable>?,
                                isFirstResource: Boolean
                        ): Boolean {
                            return false /* important to return false so the error placeholder can be placed */
                        }

                        override fun onResourceReady(
                                resource: Drawable?,
                                model: Any?,
                                target: Target<Drawable>?,
                                dataSource: DataSource?,
                                isFirstResource: Boolean
                        ): Boolean {
                            return false;
                        }
                    })
                    .into(foodImageView)
        }

        if (foodName !== null) {
            nameTextView.text = foodName
        }

        if (foodDescription !== null) {
            descriptionTextView.text = foodDescription
        }
    }
}