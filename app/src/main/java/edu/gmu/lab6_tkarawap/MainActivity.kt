package edu.gmu.lab6_tkarawap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {

    private var excellentTip: Int = 20
    private var averageTip: Int = 18
    private var badTip: Int = 14


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var billEditText = findViewById<EditText>(R.id.bill)
        var radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        var updateButton = findViewById<Button>(R.id.updatePercentage)


        var tip1 = intent.getIntExtra("tip1", 20)
        var tip2 = intent.getIntExtra("tip2", 18)
        var tip3 = intent.getIntExtra("tip3", 14)
        excellentTip = tip1
        averageTip = tip2
        badTip = tip3

        updateButton.setOnClickListener {
            val Intent = Intent(this, Update_Percentage::class.java)
                startActivity(Intent)
            }



        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            var bill = 0.00
            if (checkedId == R.id.excellent_button) {
                Toast.makeText(this, "Excellent button clicked", Toast.LENGTH_SHORT).show()
                if (billEditText.text.toString() == "") {
                    bill = 0.00;
                    //Toast.makeText(this, "Value of EditText " + bill, Toast.LENGTH_SHORT).show()
                    computeTip(bill, 0)
                } else {
                    bill = billEditText.text.toString().toDouble()
                    //Toast.makeText(this, "Value of EditText " + bill, Toast.LENGTH_SHORT).show()
                    computeTip(bill, excellentTip)
                }

            }
            if (checkedId == R.id.average_button) {
                Toast.makeText(this, "Average button clicked", Toast.LENGTH_SHORT).show()
                if (billEditText.text.toString() == "") {
                    bill = 0.00;
                    //Toast.makeText(this, "Value of EditText " + bill, Toast.LENGTH_SHORT).show()
                    computeTip(bill, 0)
                } else {
                    bill = billEditText.text.toString().toDouble()
                    //Toast.makeText(this, "Value of EditText " + bill, Toast.LENGTH_SHORT).show()
                    computeTip(bill, averageTip)
                }
            }
            if (checkedId == R.id.lacking_button) {
                Toast.makeText(this, "Lacking button clicked", Toast.LENGTH_SHORT).show()
                if (billEditText.text.toString() == "") {
                    //Toast.makeText(this, "Value of EditText " + bill, Toast.LENGTH_SHORT).show()
                    computeTip(bill, 0)
                } else {
                    bill = billEditText.text.toString().toDouble()
                    //Toast.makeText(this, "Value of EditText " + bill, Toast.LENGTH_SHORT).show()
                    computeTip(bill, badTip)
                }
            }
        }
    }

        private fun roundToTwoDigit(paramDouble: Double) : String {
            return String.format("%.2f%n", paramDouble)
        }

        private fun  computeTip(bill: Double, percent: Int) {
            var pct = (bill*percent)/100
            var total = bill + pct
            var compute= findViewById<TextView>(R.id.computed_tip)
            var billTotal = findViewById<TextView>(R.id.bill_total)
            var roundTip: String = roundToTwoDigit(pct)
            compute.text = (roundTip)
            var roundTotal: String = roundToTwoDigit(total)
            billTotal.text = (roundTotal)


        }

    }

