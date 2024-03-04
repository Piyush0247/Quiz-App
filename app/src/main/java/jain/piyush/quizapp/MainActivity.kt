package jain.piyush.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_click : Button = findViewById(R.id.btn_click)
        val etname : EditText = findViewById(R.id.etname)
        btn_click.setOnClickListener{
         if (etname.text.isEmpty()){
             Toast.makeText(this ,
                 "Please enter your name",Toast.LENGTH_LONG).show()
         }else
         {
             val intent = Intent(this , QiuzQuestion::class.java)
             intent.putExtra(Constant.USER_NAME, etname.text.toString())
             startActivity(intent)
             finish()
         }
        }
    }
}