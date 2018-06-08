package fr.epita.theghibliapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.character_list.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(R.layout.character_list)
        list_of_char.emptyView = character_list_emptylist
        val data : MutableList<Characters> = arrayListOf()
        data.add(Characters("Han", "Solo", "Star Wars", true))
        data.add(Characters("Darth", "Vader", "Star Wars", false))
// Link the adapter and the listview
        list_of_char.adapter = CharactersList(this, data)
    }
}
