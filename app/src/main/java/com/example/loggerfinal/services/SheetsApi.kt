package com.example.loggerfinal.services

import com.example.loggerfinal.models.SheetData
import com.google.android.gms.common.api.Response
import retrofit2.http.GET
import retrofit2.http.Path



interface SheetsApi {
    @GET("feeds/list/1XzTdJ-R4tTL5l1J5zSOALUDQ4rI06o8wWSwjb-CVqjY/od6/public/values?alt=json")
    suspend fun getSheetData(@Path("1XzTdJ-R4tTL5l1J5zSOALUDQ4rI06o8wWSwjb-CVqjY") sheetId: String): Response<com.google.android.gms.common.api.Result>
    @GET("/")
    fun getWhatever() : Response<com.google.android.gms.common.api.Result>
}
