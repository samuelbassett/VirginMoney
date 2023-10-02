package com.tc.virginmoney.ui.rooms

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tc.virginmoney.R
import com.tc.virginmoney.databinding.ItemRoomsBinding
import com.tc.virginmoney.ui.rooms.data.Rooms
import com.tc.virginmoney.ui.rooms.data.RoomsItemModel
import java.util.ArrayList

class RoomsAdapter(private val data: ArrayList<RoomsItemModel>) :
    RecyclerView.Adapter<RoomsAdapter.CustomViewHolder>() {

    inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemRoomsBinding.bind(view)

        fun setupUI(roomData: RoomsItemModel, position: Int) {
            binding.roomNumberTextView.text = "Room #${roomData.id}"
            if(roomData.isOccupied == true) {
                binding.roomStatusTextView.text = "OCCUPIED"
                val color = Color.parseColor("#55FF0000")
                binding.roomStatusTextView.setTextColor(color)
            } else {
                binding.roomStatusTextView.text = "OPEN"
                val color = Color.parseColor("#5500FF00")
                binding.roomStatusTextView.setTextColor(color)
            }
            binding.occupancyTextView.text = "Max Occupancy: ${roomData.maxOccupancy.toString()}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CustomViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_rooms, parent, false)
    )

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val senderData = data[position]
        holder.setupUI(senderData, position)
    }

    override fun getItemCount() = data.size

}