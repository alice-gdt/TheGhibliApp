package fr.epita.theghibliapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class QuizActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
    }

    override fun onBackPressed() {
        val intent = Intent(this ,MainActivity::class.java)
        startActivity(intent)
    }
}
