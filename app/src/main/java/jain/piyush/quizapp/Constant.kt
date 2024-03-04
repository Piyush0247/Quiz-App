package jain.piyush.quizapp

object Constant {
    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTION: String = "total_question"
    const val CORRECT_ANSWER: String = "correct_answer"
    fun getQuestion():ArrayList<Question>{
        val Question = ArrayList<Question>()
        val qus1 = Question(
            1,"Who is this Actor ? ",
            R.drawable.first,
            "Shakti Kapoor","Prabas",
            "Naga Arjuna","Rama Charan",
            1


        )
        Question.add(qus1)
        val qus2 = Question(
            2,"Who is this Actor ? ",
            R.drawable.ic_second_question,
            "Arjun Kapoor","Salman Khan",
            "Shahid Kapoor","Akshay Kumar",
            3
        )
        Question.add(qus2)
        val qus3 = Question(
            3,"Who is this Actor ? ",
            R.drawable.ic_fourth_question,
            "Ranbir Kapoor","Vijay Thalapaty",
            "Salman Khan","Shaharuk Khan",
            1
        )
        Question.add(qus3)
        val qus4 = Question(
            4,"Who is this Actor ? ",
            R.drawable.ic_third_question,
            "Sahil Gujar","Sunny Deol","Tiger Shroff",
            "Hrithik Roshan",4
        )
        Question.add(qus4)
        val qus5 = Question(
            5,"Who is this Actor ? ",
            R.drawable.ic_fifth_question,"Yash ","Ranveer Kapoor",
            "Shahid Kapoor","Naga Arjun",1
        )
        Question.add(qus5)
        val qus6 = Question(
            6,"Who is this Actor ? ",
            R.drawable.sixth,
            "Ujjval","Lakshya",
            "Piyush","Dhruv",
            3
        )
        Question.add(qus6)
        val qus7 = Question(
            7,"who is this Actor ? ", R.drawable.ic_seventh_question,"Arjun Kapoor",
            "Yash","Ranbir Kapoor","Prabhas",4
        )
        Question.add(qus7)
        val qus8 = Question(
            8,"Who is this Actor ? ",R.drawable.ic_eight_question,"Vijay Thalapaty",
            "Rama Charan","Prabhas","Salman Khan",1
        )
        Question.add(qus8)
        val qus9 = Question(
            9,"Who is this Actor ? ",R.drawable.ic_ninth_question,"Arjun Kapoor",
            "Dhanush","Sharukh Khan","Ranveer Kapoor",2
        )
        Question.add(qus9)
        val qus10 = Question(
            10,"Who is this Actor ? ",R.drawable.ic_tenth_question,"Ranbir Kapoor",
            "Arjun Kapoor","Aamir Khan","Sharukh Khan",3
        )
        Question.add(qus10)
        return Question
    }
}