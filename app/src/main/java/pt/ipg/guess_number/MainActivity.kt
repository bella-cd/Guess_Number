package pt.ipg.guess_number

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {

    private val random = Random()
    private var numberToGuess = 1
    private var attempts = 0
    private  var games = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        newGame()

        val buttonGuess = findViewById<Button>(R.id.buttonGuess)
        buttonGuess.setOnClickListener { guess() }
    }

    private fun guess() {

        val editTextNumber = findViewById<EditText>(R.id.editTextNumber)
        val guess =  editTextNumber.text.toString().toIntOrNull()

        if (guess == null){
            editTextNumber.error = getString(R.string.invalid_number)
            return
        }

        if (guess !in 1..10 ){
            editTextNumber.error = getString(R.string.number_interval_incorrect)
            return

        }
         attempts++
        updateAttempts()

        val textViewFeedback = findViewById<TextView>(R.id.textViewFeedback)

        if (guess == numberToGuess){

            textViewFeedback.text = getString(R.string.win_feedback)

            gameEnded()

        }
        else if (numberToGuess > guess){

            textViewFeedback.text = getString(R.string.higher_number_feedback)

        }
        else{

            textViewFeedback.text = getString(R.string.lower_number_feedback)

        }
    }

    private fun gameEnded() {

    }

    private fun updateAttempts() {
        val textViewAttempts = findViewById<TextView>(R.id.textViewAttempts)
        textViewAttempts.text = getString(R.string.attempts) + attempts
    }
    private fun updateGames() {
        val textViewGames = findViewById<TextView>(R.id.textViewGames)
        textViewGames.text = getString(R.string.games) + games
    }

    private fun newGame() {
        numberToGuess = random.nextInt( 10) + 1

        games++
        updateGames()

        attempts = 0
        updateAttempts()
    }


}