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
                    val intent = Intent(this, CharacterList::class.java)
                    startActivity(intent)
                    //setContentView(R.layout.character_list)
                }
                R.id.buttonFilm -> {
                    setContentView(R.layout.movie_list)
                }
                R.id .buttonQuiz -> {
                    val intent = Intent(this ,QuizActivity::class.java)
                    startActivity(intent)
                }
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       /*setContentView(R.layout.character_list)
        list_of_char.emptyView = character_list_emptylist
        val data : MutableList<Characters> = arrayListOf()
        data.add(Characters("Han", "Solo", "Star Wars", true))
        data.add(Characters("Darth", "Vader", "Star Wars", false))
// Link the adapter and the listview
        list_of_char.adapter = CharactersList(this, data)*/
        setContentView(R.layout.activity_main)
        buttonFilm.setOnClickListener(this@MainActivity)
        buttonChar.setOnClickListener(this@MainActivity)
        buttonQuiz.setOnClickListener(this@MainActivity)

    }
}
