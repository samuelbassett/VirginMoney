package com.tc.virginmoney.ui.people

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tc.virginmoney.databinding.FragmentPeopleBinding
import com.tc.virginmoney.ui.people.data.PeopleItemModel
import java.util.ArrayList

class PeopleFragment : Fragment() {

    private var _binding: FragmentPeopleBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var peopleAdapter: PeopleAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val peopleViewModel =
            ViewModelProvider(this).get(PeopleViewModel::class.java)

        _binding = FragmentPeopleBinding.inflate(inflater, container, false)
        val root: View = binding.root

         peopleViewModel.peopleData.observe(viewLifecycleOwner){
            it?.let {
//                showData(it)
                binding.recyclerPeopleView.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = peopleAdapter
                }
            }
        }

        peopleAdapter = PeopleAdapter(arrayListOf())

//        binding.recyclerPeopleView.apply {
//            layoutManager = LinearLayoutManager(context)
//            adapter = peopleAdapter
//        }

        peopleViewModel.getPeople()
        
        return root
    }

    private fun showData(data: ArrayList<PeopleItemModel>) {
        peopleAdapter.updateList(data)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}