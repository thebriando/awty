package edu.washington.briando.awty

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.text.*

class MainActivity : AppCompatActivity() {
    private lateinit var message: EditText
    private lateinit var phone: EditText
    private lateinit var nag: EditText
    private lateinit var btn: Button
    private lateinit var toast: Toast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        message = findViewById(R.id.message)
        phone = findViewById(R.id.phone)
        nag = findViewById(R.id.nag)
        btn = findViewById(R.id.btn)

        btn.text = "Start"
        btn.isEnabled = false

        btn.setOnClickListener {
            if (btn.text.toString() == "Start") {
                btn.text = "Stop"
                val toastPhone = phone.text.toString()
                val toastMsg = message.text.toString()
                val interval = nag.text.toString()
                if (toastPhone.length < 10) {
                    toast = Toast.makeText(this, "Phone number must be 10 digits", Toast.LENGTH_SHORT)
                    btn.text = "Start"
                } else if (interval.toInt() <= 0) {
                    toast = Toast.makeText(this, "Interval must be greater than 0", Toast.LENGTH_SHORT)
                    btn.text = "Start"
                } else {
                    toast = Toast.makeText(this, "Texting $toastPhone : $toastMsg", Toast.LENGTH_SHORT)
                }
                toast.show()
            } else {
                btn.text = "Start"
                toast.cancel()
            }
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
                checkBtn()
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
                checkBtn()
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
                checkBtn()
            }
        })
    }

    fun checkBtn() {
        if (phone.text.isNotEmpty() && nag.text.isNotEmpty() && message.text.isNotEmpty()) {
            btn.isEnabled = true
        }
    }
}
