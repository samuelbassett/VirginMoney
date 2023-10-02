package com.tc.virginmoney.data

import com.tc.virginmoney.ui.people.data.PeopleItemModel
import com.tc.virginmoney.ui.rooms.data.RoomsItemModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiEndpoint {
    @GET(ApiDetails.PEOPLE_ENDPOINT)
    suspend fun getPeople(): Response<ArrayList<PeopleItemModel>>

    @GET(ApiDetails.ROOMS_ENDPOINT)
    suspend fun getRooms(): Response<ArrayList<RoomsItemModel>>
}