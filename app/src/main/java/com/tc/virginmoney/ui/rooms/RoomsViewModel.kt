package com.tc.virginmoney.ui.rooms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tc.virginmoney.data.ApiDetails
import com.tc.virginmoney.ui.people.data.People
import com.tc.virginmoney.ui.people.data.PeopleItemModel
import com.tc.virginmoney.ui.rooms.data.Rooms
import com.tc.virginmoney.ui.rooms.data.RoomsItemModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RoomsViewModel : ViewModel() {

    private val _roomData = MutableLiveData<ArrayList<RoomsItemModel>>()
    val roomData: LiveData<ArrayList<RoomsItemModel>> = _roomData


    fun getRooms() {
        GlobalScope.launch {
            val result = ApiDetails.service.getRooms()
            if (result.isSuccessful) {
                _roomData.postValue(result.body())
            } else {
                _roomData.postValue(Rooms())
            }
        }
    }
}