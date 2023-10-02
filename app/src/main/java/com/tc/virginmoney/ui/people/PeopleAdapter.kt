package com.tc.virginmoney.ui.people

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tc.virginmoney.R
import com.tc.virginmoney.databinding.ItemPeopleBinding
import com.tc.virginmoney.ui.people.data.PeopleItemModel
import java.util.ArrayList

class PeopleAdapter(private val data: ArrayList<PeopleItemModel>) :
    RecyclerView.Adapter<PeopleAdapter.CustomViewHolder>() {

    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemPeopleBinding.bind(view)

        fun setupUI(peopleData: PeopleItemModel, position: Int) {
            binding.nameTextView.text = "${peopleData.firstName} ${peopleData.lastName}"
            binding.emailTextView.text = peopleData.email.toString()
            binding.descriptionTextView.text = peopleData.jobtitle.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CustomViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_people, parent, false)
    )

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.setupUI(data[position], position)
    }

    override fun getItemCount() = data.size

    fun updateList(peopleData: ArrayList<PeopleItemModel>) {
        data.addAll(peopleData)
        notifyDataSetChanged()
    }

}
