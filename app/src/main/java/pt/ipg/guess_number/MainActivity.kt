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
            editTextNumber.error = "Invalid Number"
            return
        }

        if (guess !in 1..10 ){
            editTextNumber.error = " The number must be between 1 and 10 "
            return

        }

        val textViewFeedback = findViewById<TextView>(R.id.textViewFeedback)

        if (guess == numberToGuess){

            textViewFeedback.text = "Congratulation you guessed the number"

        }
        else if (numberToGuess > guess){

            textViewFeedback.text = " I am thinking on a higher number"

        }
        else{

            textViewFeedback.text = " I am thinking on a lower number"

        }
    }

    private fun newGame() {
        numberToGuess = random.nextInt( 10) + 1
    }
}