package com.example.st10454053.weatherman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.text.util.LocalePreferences.FirstDayOfWeek.Days
import java.time.DayOfWeek

class detailed_view : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        val temperatureDetailstextView = findViewById<TextView>(R.id.TemperatureDetailstextView)
        val backButton = findViewById<Button>(R.id.backButton)
        val temperatureDataList = intent.getSerializableExtra("temperatureDataList") as ArrayList<detailed_view>

        val details = StringBuilder()
        var total_temp = 0
        for (data in temperatureDataList) {
            details.append("${arrayOf(DayOfWeek)}:Minimum-${data.}")

        }

    }
}