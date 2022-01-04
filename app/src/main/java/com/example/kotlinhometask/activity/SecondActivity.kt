package com.example.kotlinhometask.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.kotlinhometask.R
import com.example.kotlinhometask.model.Student
import com.example.kotlinhometask.model.Teacher

class SecondActivity : AppCompatActivity() {
    val TAG = SecondActivity::class.java.toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initviews()
    }
    fun initviews(){
        var studentTextView = findViewById<TextView>(R.id.tv_student)
        var backButton = findViewById<Button>(R.id.btn_back)

        var student : Student? = intent.getParcelableExtra("student")

        Log.d(TAG, student.toString())
        studentTextView.setText(student.toString())

        backButton.setOnClickListener {
            val teacher = Teacher(1, "Xurshid aka")
            backToFinish(teacher)
        }
    }
    fun backToFinish(teacher : Teacher){
        var returnIntent = Intent()
        returnIntent.putExtra("teacher", teacher)
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
    }
}