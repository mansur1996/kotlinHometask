package com.example.kotlinhometask.activity

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.kotlinhometask.R
import com.example.kotlinhometask.model.Student
import com.example.kotlinhometask.model.Teacher

class MainActivity : AppCompatActivity() {

    val LAUNCH_SECOND = 1;
    val memberTextView : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }
    fun initViews() {
        val seeNameButton = findViewById<Button>(R.id.btn_second_activity)
        seeNameButton.setOnClickListener {
            val student = Student(1, "JaxaDev")

            openSecondActivity(student)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK){
            val teacher = data!!.getParcelableExtra<Teacher>("teacher")
            memberTextView!!.setText(teacher.toString())
        }
    }

    fun openSecondActivity(st : Student){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("student", st)
        //startActivity(intent)
        startActivityForResult(intent, LAUNCH_SECOND);
    }
}