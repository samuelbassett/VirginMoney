package com.tc.virginmoney.ui.people

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tc.virginmoney.data.ApiDetails
import com.tc.virginmoney.ui.people.data.People
import com.tc.virginmoney.ui.people.data.PeopleItemModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PeopleViewModel : ViewModel() {

    private val _peopleData = MutableLiveData<ArrayList<PeopleItemModel>>()
    val peopleData: LiveData<ArrayList<PeopleItemModel>> = _peopleData


    fun getPeople() {
        GlobalScope.launch {
            val result = ApiDetails.service.getPeople()
            if (result.isSuccessful) {
                _peopleData.postValue(result.body())
            } else {
                _peopleData.postValue(People())
            }
        }
    }
}