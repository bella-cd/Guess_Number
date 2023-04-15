package pt.ipg.guess_number

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
    }

    private fun newGame() {
        numberToGuess = random.nextInt( 10) + 1
    }
}