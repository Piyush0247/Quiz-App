package jain.piyush.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ResultAcitivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_acitivity)
        val nameresult = findViewById<TextView>(R.id.namePart)
        val finish : Button = findViewById(R.id.btnfinsh)
        val score : TextView = findViewById(R.id.score)


        nameresult .text = intent.getStringExtra(Constant.USER_NAME)

        val totalQuestion = intent.getIntExtra(Constant.TOTAL_QUESTION,0)
        val Correct_Answer = intent.getIntExtra(Constant.CORRECT_ANSWER,0)

        score .text = "Your Score is $Correct_Answer out of $totalQuestion"
        finish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}