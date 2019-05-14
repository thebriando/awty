package edu.washington.briando.awty

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.text.*

class MainActivity : AppCompatActivity() {
    private lateinit var message: EditText
    private lateinit var phone: EditText
    private lateinit var nag: EditText
    private lateinit var startBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        message = findViewById(R.id.message)
        phone = findViewById(R.id.phone)
        nag = findViewById(R.id.nag)
        startBtn = findViewById(R.id.startBtn)

        startBtn.isEnabled = false

        startBtn.setOnClickListener {
            startBtn.text = "Stop"
        }
    }

    override fun onStart() {
        super.onStart()
        message.addTextChangedListener(object : TextWatcher {
            var text = ""
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                text = message.text.toString()
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (phone.text.isNotEmpty() && nag.text.isNotEmpty() && message.text.isNotEmpty()) {
                    startBtn.isEnabled = true
                }
            }
        })
        phone.addTextChangedListener(object : TextWatcher {
            var text = ""
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                text = phone.text.toString()
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (phone.text.isNotEmpty() && nag.text.isNotEmpty() && message.text.isNotEmpty()) {
                    startBtn.isEnabled = true
                }
            }
        })
        nag.addTextChangedListener(object : TextWatcher {
            var text = ""
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                text = nag.text.toString()
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (phone.text.isNotEmpty() && nag.text.isNotEmpty() && message.text.isNotEmpty()) {
                    startBtn.isEnabled = true
                }
            }
        })
    }
}
