package com.example.st10454053.weatherman

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.text.util.LocalePreferences.FirstDayOfWeek.Days
import java.time.DayOfWeek
import java.util.Date
import kotlin.time.Duration.Companion.days

private fun Int?.isEmpty(): Boolean {

    return TODO("Provide the return value")
}

private fun <E> java.util.ArrayList<E>.add(day: Int?) {
    TODO("Not yet implemented")
}

class MainActivity2 : AppCompatActivity() {

    private lateinit var Day: EditText
    private lateinit var Minimum_temperature: EditText
    private lateinit var Maximum_temperature: EditText
    private lateinit var weather_condition: EditText
    private lateinit var addButton: Button
    private lateinit var clearButton: Button
    private lateinit var daily_views: Button

    private val temperatureDataList = ArrayList<String>()
    private val DayList = ArrayList<String>()
    private val minimumList = ArrayList<Int>()
    private val maximumList = ArrayList<Int>()
    private val weatherconditionList = ArrayList<String>()
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val prompt = findViewById<TextView>(R.id.prompt)
        val day_input = findViewById<EditText>(R.id.day_input)
        val user_min_temp_input = findViewById<EditText>(R.id.user_min_temp_input)
        val user_max_temp_input = findViewById<EditText>(R.id.user_max_temp_input)
        val user_weather_condtions_input = findViewById<EditText>(R.id.user_weather_conditions_input)
        val addButton = findViewById<Button>(R.id.addButton)
        val clearButton = findViewById<Button>(R.id.clearButton)
        val daily_Views = findViewById<Button>(R.id.daily_ViewsButton)

        prompt.text = "Please enter the Day of the week, Minimum temperature and Maximum temperature, also add the weather condition"

        addButton.setOnClickListener {
            val Day = day_input.text.toString().toIntOrNull()
            val Minimum_temperature = user_min_temp_input.text.toString().toIntOrNull()
            val Maximum_temperature = user_max_temp_input.text.toString().toIntOrNull()
            val weather_condition = user_weather_condtions_input.text.toString()

            if (Day.isEmpty() &&Minimum_temperature.isEmpty() &&Maximum_temperature.isEmpty() &&weather_condition.isEmpty()) {

            }
            else {
                try {
                    val Minimum_temperature = Minimum_temperature!!.toInt()
                    val Maximum_temperature = Maximum_temperature!!.toInt()
                    val data = "Day: $Day, Minimum_temperature: $Minimum_temperature, Maximum_temperature: $Maximum_temperature, weather_condition: $weather_condition"
                    temperatureDataList.add(data)
                    DayList.add(Day)
                    minimumList.add(Minimum_temperature)
                    maximumList.add(Maximum_temperature)
                    weatherconditionList.add(weather_condition)
                    user_min_temp_input.text.clear()
                    user_max_temp_input.text.clear()
                    user_weather_condtions_input.text.clear()
                    day_input.text.clear()

                } catch (e: Exception) {

                }
                clearButton.setOnClickListener {
                    user_weather_condtions_input.text.clear()
                    user_max_temp_input.text.clear()
                    user_min_temp_input.text.clear()
                    day_input.text.clear()

                }

                daily_Views.setOnClickListener {
                    val detailedView = Intent(this, detailed_view::class.java).apply {
                        putStringArrayListExtra("temperatureDataList", temperatureDataList)
                        putStringArrayListExtra("DayList", DayList)
                        putStringArrayListExtra("weatherconditionList", weatherconditionList)
                        val putStringArrayListExtra = putStringArrayListExtra(
                            "Number1DataList",
                            minimumList.map { it.toString() } as java.util.ArrayList<String>)
                        val putStringArrayListExtra1 = putStringArrayListExtra(
                            "Number2DataList",
                            maximumList.map { it.toString() } as java.util.ArrayList<String>)


                    }
                    startActivity(detailedView)
                }






            }

        }

    }
}