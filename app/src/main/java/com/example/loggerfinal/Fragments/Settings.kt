package com.example.loggerfinal.Fragments

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.lifecycle.MutableLiveData
import com.example.loggerfinal.R
import com.example.loggerfinal.models.SheetData
import com.example.loggerfinal.services.ApiClient
import com.gtappdevelopers.kotlingfgproject.MainActivity
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/*private const val MAX_VALUE_KEY = "max_value"
private const val DEFAULT_MAX_VALUE = 0 */
class Settings : Fragment() {
    private lateinit var apiClient: ApiClient
    private lateinit var sheetData: MutableLiveData<Result<SheetData>>
   /* private lateinit var textView: TextView
    private lateinit var maxValueEditText: EditText
    private lateinit var saveButton: Button */

   // val NOTIFICATION_ID = 1
    //val CHANNEL_ID = "channel_id"

   /* fun retrieveMaxValue(): Int {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return -1
        return sharedPref.getInt(MAX_VALUE_KEY, DEFAULT_MAX_VALUE)
    }*/



       override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
           val view = inflater.inflate(R.layout.fragment_settings, container, false)
           apiClient = ApiClient()
           sheetData = MutableLiveData()
           return view
       }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refreshData()
    }

    private fun refreshData() {
        CoroutineScope(Dispatchers.Main).launch {
//            sheetData.value = apiClient.getSheetData("1XzTdJ-R4tTL5l1J5zSOALUDQ4rI06o8wWSwjb-CVqjY")
            // You can set up a TextView here to display the data
        }
    }
}

        /*vval view = inflater.inflate(R.layout.fragment_tab1, container, false)
           apiClient = ApiClient()
           sheetData = MutableLiveData()
           return view
       }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refreshData()
    }

    private fun refreshData() {
        CoroutineScope(Dispatchers.Main).launch {
            sheetData.value = apiClient.getSheetData("your-sheet-id")
            // You can set up a TextView here to display the data
        }
    }
}
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        saveButton.setOnClickListener {
            val maxValue = maxValueEditText.text.toString().toInt()
            saveValueToSettings(maxValue)
        }
    }

    override fun onResume() {
        super.onResume()
        val maxValue = retrieveValueFromSettings()
        val currentValue = textView.text.toString().toInt()
        if (currentValue >= maxValue) {
            showNotification()
        }
    }

    private fun retrieveValueFromSettings(): Int {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return -1
        return sharedPref.getInt(MAX_VALUE_KEY, DEFAULT_MAX_VALUE)
    }

    private fun saveValueToSettings(maxValue: Int) {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putInt(MAX_VALUE_KEY, maxValue)
            commit()
        }
    }

    private fun showNotification() {
        val notificationManager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notificationId = 1

        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

        val builder = NotificationCompat.Builder(requireContext(), CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("Value exceeded maximum value")
            .setContentText("The value of the TextView has exceeded the maximum value set in the settings.")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        notificationManager.notify(notificationId, builder.build())
    }*/


