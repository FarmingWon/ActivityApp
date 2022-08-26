package com.example.activityapp3

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
        textView.text = "${data1}\n"
        textView.append("${data2}")
        button.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data1", 300)
            intent.putExtra("data2", "문자열3")
            setResult(RESULT_OK+1, intent)
            finish()
        }
    }
}