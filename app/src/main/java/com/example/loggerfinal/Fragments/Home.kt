package com.example.loggerfinal.Fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.Graph.CanadaChart
import com.example.loggerfinal.R
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.MutableLiveData
import com.example.loggerfinal.models.SheetData
import com.example.loggerfinal.services.ApiClient
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class Home : Fragment() {

    private lateinit var apiClient: ApiClient
    private lateinit var sheetData: MutableLiveData<Result<SheetData>>


    override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        apiClient = ApiClient()
        sheetData = MutableLiveData()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refreshData()
    }

//    private fun refreshData() {
//        CoroutineScope(Dispatchers.Main).launch {
//            sheetData.value = apiClient.getSheetData("1XzTdJ-R4tTL5l1J5zSOALUDQ4rI06o8wWSwjb-CVqjY")
//            val sheetData = sheetData.value
//            when(sheetData) {
//                is Result.Success -> {
//                    val data = sheetData.data
//                    // Update the TextView with the data
//                    current_temperature.text = data.column1
//                }
//                is Result.Error -> {
//                    // Handle the error case
//                    current_temperature.text = sheetData.exception.message
//                }
//            }
//
//            // Schedule the next refresh
//            handler.postDelayed({ refreshData() }, 2 * 60 * 1000)
//        }
//    }
    private fun refreshData() {
    apiClient.getSheetData("1XzTdJ-R4tTL5l1J5zSOALUDQ4rI06o8wWSwjb-CVqjY")
    }

}

