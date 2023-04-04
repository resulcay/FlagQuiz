package com.example.flagquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val name: TextView = findViewById(R.id.name)
        val score: TextView = findViewById(R.id.score)
        val finishButton: Button = findViewById(R.id.btnFinish)

        name.text = intent.getStringExtra(Constants.USER_NAME)

        val totalQuestions: Int = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers: Int = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        score.text = "Your Score is $correctAnswers out of $totalQuestions"

        finishButton.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}