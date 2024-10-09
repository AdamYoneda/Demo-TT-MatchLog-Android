package com.example.myapplication_2.presentation.view.activity

import android.app.DatePickerDialog
import java.util.Calendar
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication_2.R
import com.example.myapplication_2.data.model.MatchType

class TournamentInputActivity : AppCompatActivity() {

    private lateinit var tournamentNameEditText: EditText
    private lateinit var datePickerButton: Button
    private lateinit var matchTypeSpinner: Spinner
    private lateinit var selectedDate: String
    private lateinit var selectedMatchType: MatchType

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tournament_input)

        tournamentNameEditText = findViewById(R.id.tournamentNameEditText)
        datePickerButton = findViewById(R.id.datePickerButton)
        matchTypeSpinner = findViewById(R.id.matchTypeSpinner)

        // Set up DatePickerDialog
        datePickerButton.setOnClickListener {
            showDatePickerDialog()
        }

        // Set up Spinner for MatchType
        val matchTypes = arrayOf(MatchType.SINGLES.getValue(), MatchType.DOUBLES.getValue(), MatchType.TEAM.getValue())
        matchTypeSpinner.adapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_item, matchTypes
        )

        // Handle form submission
        findViewById<Button>(R.id.nextButton).setOnClickListener {
            val tournamentName = tournamentNameEditText.text.toString()
            selectedMatchType = matchTypeSpinner.selectedItem as MatchType

            // Navigate to match input screen, passing tournament data
//            val intent = Intent(this, MatchInputActivity::class.java).apply {
//                putExtra("tournamentName", tournamentName)
//                putExtra("date", selectedDate)
//                putExtra("matchType", selectedMatchType)
//            }
//            startActivity(intent)
        }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            selectedDate = "$selectedYear-${selectedMonth + 1}-$selectedDay"
            datePickerButton.text = selectedDate
        }, year, month, day)

        datePickerDialog.show()
    }
}
