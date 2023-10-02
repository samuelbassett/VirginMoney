package com.tc.virginmoney.ui.rooms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tc.virginmoney.databinding.FragmentRoomsBinding
import com.tc.virginmoney.ui.people.PeopleAdapter

class RoomsFragment : Fragment() {

    private var _binding: FragmentRoomsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var roomsAdapter: RoomsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val roomsViewModel =
            ViewModelProvider(this).get(RoomsViewModel::class.java)

        _binding = FragmentRoomsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        roomsViewModel.roomData.observe(viewLifecycleOwner){
            it?.let {
                binding.recyclerRoomsView.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = RoomsAdapter(it)
                }
            }
        }

        roomsAdapter = RoomsAdapter(arrayListOf())

        roomsViewModel.getRooms()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}