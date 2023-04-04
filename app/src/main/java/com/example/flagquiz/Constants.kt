package com.example.flagquiz

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions():ArrayList<Question>
    {
        val questionList = ArrayList<Question>()

        val question1 = Question(
            id = 1,
            "What country does this flag belong to ?",
             R.drawable.ic_flag_of_argentina,
            "Argentina",
            "India",
            "Kuwait",
            "Australia",
            1,
        )
        val question2 = Question(
            id = 2,
            "What country does this flag belong to ?",
             R.drawable.ic_flag_of_australia,
            "Argentina",
            "Australia",
            "Brazil",
            "Denmark",
            2,
        )
        val question3 = Question(
            id = 3,
            "What country does this flag belong to ?",
             R.drawable.ic_flag_of_belgium,
            "Belgium",
            "Germany",
            "Fiji",
            "India",
            1,
        )
        val question4 = Question(
            id = 4,
            "What country does this flag belong to ?",
             R.drawable.ic_flag_of_brazil,
            "Kuwait",
            "New Zealand",
            "Brazil",
            "Australia",
            3,
        )
        val question5 = Question(
            id = 5,
            "What country does this flag belong to ?",
             R.drawable.ic_flag_of_denmark,
            "Brazil",
            "New Zealand",
            "Germany",
            "Denmark",
            4,
        )
        val question6 = Question(
            id = 6,
            "What country does this flag belong to ?",
             R.drawable.ic_flag_of_fiji,
            "Fiji",
            "Argentina",
            "Denmark",
            "Kuwait",
            1,
        )
        val question7 = Question(
            id = 7,
            "What country does this flag belong to ?",
             R.drawable.ic_flag_of_germany,
            "Brazil",
            "India",
            "Germany",
            "Belgium",
            3,
        )
        val question8 = Question(
            id = 8,
            "What country does this flag belong to ?",
             R.drawable.ic_flag_of_india,
            "Germany",
            "Argentina",
            "Fiji",
            "India",
            4,
        )
        val question9 = Question(
            id = 9,
            "What country does this flag belong to ?",
             R.drawable.ic_flag_of_kuwait,
            "Australia",
            "Kuwait",
            "Fiji",
            "India",
            2,
        )
        val question10 = Question(
            id = 10,
            "What country does this flag belong to ?",
             R.drawable.ic_flag_of_new_zealand,
            "Belgium",
            "Brazil",
            "Denmark",
            "New Zealand",
            4,
        )

        questionList.add(question1)
        questionList.add(question2)
        questionList.add(question3)
        questionList.add(question4)
        questionList.add(question5)
        questionList.add(question6)
        questionList.add(question7)
        questionList.add(question8)
        questionList.add(question9)
        questionList.add(question10)

        return  questionList
    }
}