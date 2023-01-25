package com.example.loggerfinal.services

import com.example.loggerfinal.models.SheetData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://onet.pl")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val sheetsApi = retrofit.create(SheetsApi::class.java)

     fun getSheetData(sheetId: String) {
        //return try {
            val response = sheetsApi.getWhatever()
        println(response)
        //    if (response.) {
//                Result.Success(response.body()!!)
//            } else {
//                Result.Error(Exception("Error getting sheet data: ${response.code()} ${response.message()}"))
//            }
//        } catch (e: Exception) {
//            Result.Error(e)
       // }
    }
}