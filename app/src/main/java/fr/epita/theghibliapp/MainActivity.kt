package fr.epita.theghibliapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(p0: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonFilm.setOnClickListener(this@MainActivity)
        buttonChar.setOnClickListener(this@MainActivity)
        buttonQuiz.setOnClickListener(this@MainActivity)
    }
}
