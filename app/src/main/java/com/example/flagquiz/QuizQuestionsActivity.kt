package com.example.flagquiz

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat


class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int? = null

    private var progressBar: ProgressBar? = null
    private var progress: TextView? = null
    private var question: TextView? = null
    private var image: ImageView? = null

    private var optionOne: TextView? = null
    private var optionTwo: TextView? = null
    private var optionThree: TextView? = null
    private var optionFour: TextView? = null

    private var submit: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressBar = findViewById(R.id.progressBar)
        progress = findViewById(R.id.progress)
        question = findViewById(R.id.question)
        image = findViewById(R.id.image)
        optionOne = findViewById(R.id.optionOne)
        optionTwo = findViewById(R.id.optionTwo)
        optionThree = findViewById(R.id.optionThree)
        optionFour = findViewById(R.id.optionFour)
        submit = findViewById(R.id.submit)

        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)
        submit?.setOnClickListener(this)

        mQuestionList = Constants.getQuestions()
        setQuestions()
    }

    private fun setQuestions() {

        val questionObject: Question = mQuestionList!![mCurrentPosition - 1]

        image?.setImageResource(questionObject.image)
        progressBar?.progress = mCurrentPosition
        progress?.text = "$mCurrentPosition/${progressBar?.max}"
        question?.text = questionObject.question

        optionOne?.text = questionObject.optionOne
        optionTwo?.text = questionObject.optionTwo
        optionThree?.text = questionObject.optionThree
        optionFour?.text = questionObject.optionFour

        if (mCurrentPosition == mQuestionList!!.size)
        {
            submit?.text = "FINISH"
        }
        else
        {
            submit?.text = "SUBMIT"
        }
    }

    private fun defaultOptionsView()
    {
        val options = ArrayList<TextView>()

        optionOne?.let {
            options.add(0,it)
        }
        optionTwo?.let {
            options.add(1,it)
        }
        optionThree?.let {
            options.add(2,it)
        }
        optionFour?.let {
            options.add(3,it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(textView: TextView,selectedOptionNum: Int)
    {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface,Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)

    }

    private fun answerView(answer: Int?, drawableView: Int)
    {
        when(answer)
        {
            1 -> {
                optionOne?.background = ContextCompat.getDrawable(this,drawableView)
                optionOne?.setTextColor(Color.parseColor("#FFFFFF"))
            }
            2 -> {
                optionTwo?.background = ContextCompat.getDrawable(this,drawableView)
                optionTwo?.setTextColor(Color.parseColor("#FFFFFF"))
            }
            3 -> {
                optionThree?.background = ContextCompat.getDrawable(this,drawableView)
                optionThree?.setTextColor(Color.parseColor("#FFFFFF"))
            }
            4 -> {
                optionFour?.background = ContextCompat.getDrawable(this,drawableView)
                optionFour?.setTextColor(Color.parseColor("#FFFFFF"))
            }
        }
    }

    override fun onClick(view: View?) {
        when(view?.id)
        {
            R.id.optionOne -> {
                optionOne?.let {
                    selectedOptionView(it,1)
                }
            }            R.id.optionTwo -> {
                optionTwo?.let {
                    selectedOptionView(it,2)
                }
            }            R.id.optionThree -> {
                optionThree?.let {
                    selectedOptionView(it,3)
                }
            }            R.id.optionFour -> {
                optionFour?.let {
                    selectedOptionView(it,4)
                }
            }            R.id.submit -> {
                        submit?.let {
                    if (mSelectedOptionPosition == 0)
                    {
                        mCurrentPosition++

                        when
                        {
                            mCurrentPosition <= mQuestionList!!.size ->
                            {
                                setQuestions()
                            }
                        }
                    }
                    else
                    {
                        val question = mQuestionList?.get(mCurrentPosition -1)

                        if (question!!.correctOption != mSelectedOptionPosition)
                        {
                            answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                        }
                        answerView(question.correctOption,R.drawable.correct_option_border_bg)
                    }
                }
            }
        }
    }
}