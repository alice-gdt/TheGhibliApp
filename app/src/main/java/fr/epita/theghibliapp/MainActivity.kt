package fr.epita.theghibliapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        if (v!= null) {
            when (v.id) {
                R.id.buttonChar -> {
                    val intent = Intent(this, CharactersList::class.java)
                    startActivity(intent)


                }
                R.id.buttonFilm -> {
                    val intent = Intent(this, CharactersList::class.java)
                    startActivity(intent)

                }
                R.id .buttonQuiz -> {
                    val intent = Intent(this, CharactersList::class.java)
                    startActivity(intent)

                }
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonFilm.setOnClickListener(this@MainActivity)
        buttonChar.setOnClickListener(this@MainActivity)
        buttonQuiz.setOnClickListener(this@MainActivity)
    }
}
