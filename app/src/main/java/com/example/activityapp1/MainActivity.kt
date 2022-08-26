package com.example.activityapp1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val SECOND_ACTIVITY = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val intent = Intent("com.example.test_activity")
            intent.putExtra("data1", 100)
            intent.putExtra("data2", "문자열")
            startActivityForResult(intent, SECOND_ACTIVITY)
        }
        button2.setOnClickListener {
            val uri = Uri.parse("https://google.com")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == SECOND_ACTIVITY){
            when(resultCode){
                RESULT_OK -> {
                    val data1 = data?.getIntExtra("data1", 0)
                    val data2 = data?.getStringExtra("data2")
                    textView.text = "APP 2 \n"
                    textView.append("${data1}\n")
                    textView.append("${data2}")
                }
                RESULT_OK+1 -> {
                    val data1 = data?.getIntExtra("data1", 0)
                    val data2 = data?.getStringExtra("data2")
                    textView.text = "APP 3 \n"
                    textView.append("${data1}\n")
                    textView.append("${data2}")
                }
            }
        }
    }
}