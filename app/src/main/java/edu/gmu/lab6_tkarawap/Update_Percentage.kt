package edu.gmu.lab6_tkarawap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Update_Percentage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_percentage)

        var secondActButton = findViewById<Button>(R.id.addUpdatePercentage)
        var excEdit = findViewById<EditText>(R.id.excellentUpdate)
        var avgEdit = findViewById<EditText>(R.id.averageUpdate)
        var lackEdit = findViewById<EditText>(R.id.lackingUpdate)

        secondActButton.setOnClickListener {
            var tip1 = 20
            var tip2 = 18
            var tip3 = 14
            if(excEdit.text.toString() == "") {
                tip1 = 20
            }
            else if(excEdit.text.toString() != "") {
                tip1 = excEdit.text.toString().toInt()
            }
            if(avgEdit.text.toString() == "") {
                tip2 = 18
            }
            else if(avgEdit.text.toString() !== "") {
                tip2 = avgEdit.text.toString().toInt()
            }
            if(lackEdit.text.toString() == "") {
                tip3 = 14
            }
            else if(lackEdit.text.toString() != "") {
                tip3 = lackEdit.text.toString().toInt()
            }

            Intent(this, MainActivity::class.java).also {
                    it.putExtra("tip1", tip1)
                    it.putExtra("tip2", tip2)
                    it.putExtra("tip3", tip3)
                    startActivity(it)
                    finish()
            }
        }

    }
}