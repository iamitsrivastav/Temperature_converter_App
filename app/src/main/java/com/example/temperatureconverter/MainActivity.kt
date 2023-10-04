package com.example.temperatureconverter

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var ansBtn: Button? = null
    var againBtn: Button? = null
    var showAns: TextView? = null
    var getVal: EditText? = null
    var c2f: RadioButton? = null
    var f2c: RadioButton? = null
    var x: Double? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ansBtn = findViewById<View>(R.id.ansBtn) as Button
        showAns = findViewById<View>(R.id.showAns) as TextView
        getVal = findViewById<View>(R.id.getVal) as EditText
        c2f = findViewById<View>(R.id.c2f) as RadioButton
        f2c = findViewById<View>(R.id.f2c) as RadioButton
        againBtn = findViewById<View>(R.id.againBtn) as Button
        ansBtn!!.setOnClickListener {
            if (getVal!!.text.toString().isEmpty()) {
                showAns!!.text = "Please give Temperature"
            } else {
                x = getVal!!.text.toString().toDouble()
                if (c2f!!.isChecked) {
                    x = x!! * 9 / 5 + 32

                    //x = Double.parseDouble(new DecimalFormat(pattern:"##.###").format(x));
                    showAns!!.text = x.toString() + " Degree F"
                } else if (f2c!!.isChecked) {
                    x = (x!! - 32) * 5 / 9
                    //x = Double.parseDouble(new DecimalFormat(pattern:"##.###").format(x));
                    showAns!!.text = x.toString() + " Degree C"
                } else {
                    showAns!!.text = "Please Select an option !"
                }
            }
        }
        againBtn!!.setOnClickListener {
            showAns!!.text = "0.0"
            getVal!!.setText("")
            c2f!!.isChecked = false
            f2c!!.isChecked = false
        }
    }
}