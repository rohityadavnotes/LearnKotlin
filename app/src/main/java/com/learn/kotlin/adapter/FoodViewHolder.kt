package com.learn.kotlin.adapter

import android.app.Activity
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.learn.kotlin.FoodDetailsActivity
import com.learn.kotlin.R
import com.learn.kotlin.model.Food

class FoodViewHolder constructor(view: View) : RecyclerView.ViewHolder(view) {

    private val relativeLayout: RelativeLayout = view.findViewById(R.id.relativeLayout)
    private val foodImageView: ImageView = view.findViewById(R.id.foodImageView)
    private val progressBar: ProgressBar = view.findViewById(R.id.progressBar)
    private val nameTextView: TextView = view.findViewById(R.id.nameTextView)
    private val descriptionTextView: TextView = view.findViewById(R.id.descriptionTextView)

    /*private val relativeLayout : RelativeLayout
    private val pictureImageView: ImageView
    private val progressBar: ProgressBar
    private val nameTextView: TextView
    private val descriptionTextView: TextView

    init {
        relativeLayout = view.findViewById(R.id.relativeLayout)
        foodImageView = view.findViewById(R.id.foodImageView)
        progressBar = view.findViewById(R.id.progressBar)
        nameTextView = view.findViewById(R.id.nameTextView)
        descriptionTextView = view.findViewById(R.id.descriptionTextView)
    }*/

    fun bind(activity: Activity, food: Food) {
        Glide.with(activity)
                .load(food.foodImageUrl)
                .error(R.drawable.ic_launcher_background)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: Target<Drawable>?,
                            isFirstResource: Boolean
                    ): Boolean {
                        progressBar.setVisibility(View.GONE);
                        return false /* important to return false so the error placeholder can be placed */
                    }

                    override fun onResourceReady(
                            resource: Drawable?,
                            model: Any?,
                            target: Target<Drawable>?,
                            dataSource: DataSource?,
                            isFirstResource: Boolean
                    ): Boolean {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(foodImageView)

        nameTextView.text = food.foodName
        descriptionTextView.text = food.foodDescription

        itemView.setOnClickListener {
            openActivityUsingSingletonPattern(activity, food.foodImageUrl, food.foodName, food.foodDescription)
        }
    }

    private fun openActivityUsingSingletonPattern(
            activity: Activity,
            image: String,
            name: String,
            description: String
    ) {
        val intent = FoodDetailsActivity.getDetailIntent(activity, image, name, description)
        activity.startActivity(intent)
    }
}