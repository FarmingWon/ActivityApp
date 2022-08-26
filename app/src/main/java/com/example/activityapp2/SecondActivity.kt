package com.example.activityapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val data1 = intent.getIntExtra("data1", 0)
        val data2 = intent.getStringExtra("data2")
        textView2.text = "${data1}\n"
        textView2.append("${data2}")
        button.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data1", 200)
            intent.putExtra("data2","문자열2")
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}