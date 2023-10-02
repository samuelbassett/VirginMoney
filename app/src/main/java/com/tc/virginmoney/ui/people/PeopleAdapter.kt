package com.tc.virginmoney.ui.people

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.tc.virginmoney.R
import com.tc.virginmoney.databinding.ItemPeopleBinding
import com.tc.virginmoney.ui.profile.ProfileActivity
import com.tc.virginmoney.ui.people.data.PeopleItemModel
import java.util.ArrayList

class PeopleAdapter(private val data: ArrayList<PeopleItemModel>) :
    RecyclerView.Adapter<PeopleAdapter.CustomViewHolder>() {

    inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemPeopleBinding.bind(view)

        fun setupUI(peopleData: PeopleItemModel, position: Int) {
            binding.nameTextView.text = "${peopleData.firstName} ${peopleData.lastName}"
            binding.emailTextView.text = peopleData.email.toString()
            binding.descriptionTextView.text = peopleData.jobtitle.toString()
            val backgroundColor: Int = getFavoriteColor(peopleData.favouriteColor.toString())
            binding.constraintLayout.setBackgroundColor(backgroundColor)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CustomViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_people, parent, false)
    )

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val senderData = data[position]
        holder.setupUI(senderData, position)

        // Send to Profile Activity
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, ProfileActivity::class.java)
            intent.putExtra("profileName", "${senderData.firstName} ${senderData.lastName}")
            intent.putExtra("profileImage", senderData.avatar)
            intent.putExtra("profileJob", senderData.jobtitle)
            intent.putExtra("profileEmail", senderData.email)
            intent.putExtra("dateJoined", senderData.createdAt)
            intent.putExtra("favoriteColor", senderData.favouriteColor)
            it.context.startActivity(intent)
        }

        Glide.with(holder.itemView.context)
            .load(senderData.avatar)
            .error(R.drawable.ic_error)
            .placeholder(R.drawable.ic_error)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(holder.binding.imageView)
    }

    override fun getItemCount() = data.size

    fun updateList(peopleData: ArrayList<PeopleItemModel>) {
        data.addAll(peopleData)
        notifyDataSetChanged()
    }

    fun getFavoriteColor(stringColor: String) : Int {
        val intColor = when(stringColor) {
            "pink" -> Color.parseColor("#45FFC0CB")
            "sky blue" -> Color.parseColor("#4596FCFF")
            "cyan" -> Color.parseColor("#4500FFFF")
            "indigo" -> Color.parseColor("#454B0082")
            "orchid" -> Color.parseColor("#45DA70D6")
            "lavender" -> Color.parseColor("#45967BB6")
            "blue" -> Color.parseColor("#450000FF")
            "olive" -> Color.parseColor("#45808000")
            "red" -> Color.parseColor("#45FF0000")
            "plum" -> Color.parseColor("#45673147")
            "violet" -> Color.parseColor("#457F00FF")
            "fuchsia" -> Color.parseColor("#45FF00FF")
            "azure" -> Color.parseColor("#45007FFF")
            "teal" -> Color.parseColor("#45008080")
            "silver" -> Color.parseColor("#45C0C0C0")
            "black" -> Color.parseColor("#45000000")
            "magenta" -> Color.parseColor("#45FF1DCE")
            "tan" -> Color.parseColor("#45D2B48C")
            "salmon" -> Color.parseColor("#45FA8072")
            "grey" -> Color.parseColor("#45808080")
            "green" -> Color.parseColor("#45008000")
            "mint green" -> Color.parseColor("#4598FB98")
            "orange" -> Color.parseColor("#45FFA500")
            "white" -> Color.parseColor("#45FFFFFF")
            "lime" -> Color.parseColor("#4532CD32")
            "gold" -> Color.parseColor("#45FFD700")
            "ivory" -> Color.parseColor("#45FFFFF0")
            "turquoise" -> Color.parseColor("#4540E0D0")
            "purple" -> Color.parseColor("#45800080")
            "yellow" -> Color.parseColor("#45FFFF00")
            "maroon" -> Color.parseColor("#45800000")
            // Add more color cases as needed
            else -> Color.WHITE
        }
        return intColor
    }

}
