package jain.piyush.quizapp

import android.content.Intent
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
import android.widget.Toast
import androidx.core.content.ContextCompat


class QiuzQuestion : AppCompatActivity() , View.OnClickListener{
    private var mcurrentpostion: Int = 1
    private var mQuestion : ArrayList<Question>? = null
    private var SelectedOption : Int = 0
    private var mUsername : String? = null
    private var progressBar : ProgressBar? = null
    private var textView : TextView? = null
    private var tvquestion : TextView? = null
    private var image : ImageView? = null
    private var optionone : TextView? = null
    private var optiontwo : TextView? = null
    private var optionthird : TextView? = null
    private var optionfour : TextView? = null
    private var btnsubmit : Button? = null
    private var mcorrect_anser : Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qiuz_question)

        mUsername = intent.getStringExtra(Constant.USER_NAME)
        progressBar = findViewById(R.id.progresstx)
        textView = findViewById(R.id.tximage)
        tvquestion = findViewById(R.id.tv_question)
        image = findViewById(R.id.imageshow)
        optionone = findViewById(R.id.tvoptionone)
        optiontwo = findViewById(R.id.tvoptiontwo)
        btnsubmit = findViewById(R.id.btnsubmit)
        optionthird = findViewById(R.id.tvoptionthird)
        optionfour = findViewById(R.id.tvoptionfour)
        mQuestion = Constant.getQuestion()
        optionone?.setOnClickListener(this)
        optiontwo?.setOnClickListener(this)
        optionthird?.setOnClickListener(this)
        optionfour?.setOnClickListener(this)
        btnsubmit?.setOnClickListener(this)


        setQuestion()
    }

    private fun setQuestion() {
        defaultOption()

        val question: Question = mQuestion!![mcurrentpostion - 1]
        image?.setImageResource(question.image)
        progressBar?.progress = mcurrentpostion
        textView?.text = "${mcurrentpostion}/ ${progressBar?.max}"
        tvquestion?.text = question.Question
        optionone?.text = question.OptionOne
        optiontwo?.text = question.OptionTwo
        optionthird?.text = question.OptionThree
        optionfour?.text = question.OptionFour
        if (mcurrentpostion == mQuestion!!.size){
            btnsubmit?.text = "FINISH"
        }else{
            btnsubmit?.text = "SUBMIT"
        }
    }
    private fun defaultOption() {
        val options = ArrayList<TextView>()
        optionone?.let {
            options.add(0, it)
        }
        optiontwo?.let {
            options.add(1, it)
        }
        optionthird?.let {
            options.add(2, it)
        }
        optionfour?.let {
            options.add(3, it)
        }

        for (option in options ){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }


    }
    private fun selectedoption(textview :TextView , selecetedoptionNum : Int){
        defaultOption()
        SelectedOption = selecetedoptionNum
        textview.setTextColor(Color.parseColor("#363A43"))
        textview.setTypeface(textview.typeface , Typeface.BOLD)
        textview.background = ContextCompat.getDrawable(this,R.drawable.selectedoptin)
    }

    override fun onClick(view: View?) {
        when(view?.id){
          R.id.tvoptionone -> {
              optionone?.let {
                  selectedoption(it,1)
              }
          }
            R.id.tvoptiontwo -> {
                val let = optiontwo?.let {
                    selectedoption(it, 2)
                }
            }
            R.id.tvoptionthird -> {
                optionthird?.let {
                    selectedoption(it,3)
                }
            }
            R.id.tvoptionfour -> {
                optionfour?.let {
                    selectedoption(it,4)
                }
            }
            R.id.btnsubmit ->{
                if (SelectedOption == 0){
                    mcurrentpostion++


                    when{
                        mcurrentpostion <= mQuestion!!.size ->{
                        setQuestion()
                    }
                        else ->{
                           val intent = Intent(this,ResultAcitivity::class.java)
                            intent.putExtra(Constant.USER_NAME,mUsername)
                            intent.putExtra(Constant.CORRECT_ANSWER,mcorrect_anser)
                            intent.putExtra(Constant.TOTAL_QUESTION,mQuestion?.size)
                            startActivity(intent)
                            finish()
                        }

                    }
                }
                else{
                    var question = mQuestion?.get(mcurrentpostion -1)
                    if (question!!.correctAnswer != SelectedOption){
                            answerView(SelectedOption,R.drawable.wrong_option_border_bg)
                    }else{
                        mcorrect_anser++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border_bg)
                    if (mcurrentpostion == mQuestion!!.size){
                        btnsubmit?.text = "FINISH"
                    }else{
                        btnsubmit?.text = "GO TO NEXT QUESTION"
                    }
                    SelectedOption = 0
                }
            }
        }
    }
    private fun answerView(answer : Int , drawableView : Int){

        when(answer){
            1->{
                optionone?.background = ContextCompat.getDrawable(this,
                    drawableView )
            }
            2->{
                optiontwo?.background = ContextCompat.getDrawable(this,
                    drawableView )
            }
            3->{
                optionthird?.background = ContextCompat.getDrawable(this,
                    drawableView )
            }
            4->{
                optionfour?.background = ContextCompat.getDrawable(this,
                    drawableView )
            }
        }
    }
}