package com.example.flagquiz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton : Button = findViewById(R.id.btnStart)
        val editText : EditText = findViewById(R.id.editText)

        startButton.setOnClickListener {

        val actualText =  editText.text.trim()

            if (actualText.isEmpty())
            {
                Toast.makeText(this,"Name can not be Empty",Toast.LENGTH_LONG).show()
            }
            else
            {
                val intent = Intent(this,QuizQuestionsActivity::class.java)

                intent.putExtra(Constants.USER_NAME, actualText.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}