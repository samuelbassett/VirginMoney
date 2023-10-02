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

    fun getColorCode(colorString: String) : String {
        when (colorString) {
            "pink" -> Color.parseColor("#FFC0CB")
            "sky blue" -> Color.parseColor("#96FCFF")
            "cyan" -> Color.parseColor("#00FFFF")
            "indigo" -> Color.parseColor("#4B0082")
            "orchid" -> Color.parseColor("#DA70D6")
            "lavender" -> Color.parseColor("#967BB6")
            "blue" -> Color.parseColor("#0000FF")
            "olive" -> Color.parseColor("#808000")
            "red" -> Color.parseColor("#FF0000")
            "plum" -> Color.parseColor("#673147")
            "violet" -> Color.parseColor("#7F00FF")
            "fuchsia" -> Color.parseColor("#FF00FF")
            "azure" -> Color.parseColor("#007FFF")
            "teal" -> Color.parseColor("#008080")
            "silver" -> Color.parseColor("#C0C0C0")
            "black" -> Color.parseColor("#000000")
            "magenta" -> Color.parseColor("#FF1DCE")
            "tan" -> Color.parseColor("#D2B48C")
            "salmon" -> Color.parseColor("#FA8072")
            "grey" -> Color.parseColor("#808080")
            "green" -> Color.parseColor("#008000")
            "mint green" -> Color.parseColor("#98FB98")
            "orange" -> Color.parseColor("#FFA500")
            "white" -> Color.parseColor("#FFFFFF")
            "lime" -> Color.parseColor("#32CD32")
            "gold" -> Color.parseColor("#FFD700")
            "ivory" -> Color.parseColor("#FFFFF0")
            "turquoise" -> Color.parseColor("#40E0D0")
            "purple" -> Color.parseColor("#800080")
            "yellow" -> Color.parseColor("#FFFF00")
            "maroon" -> Color.parseColor("#800000")
            // Add more color cases as needed
            else -> Color.WHITE // Default color
        }
        return colorString
    }
}