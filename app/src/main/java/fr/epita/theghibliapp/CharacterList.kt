package fr.epita.theghibliapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_character_list.*

class CharacterList : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_list)
        back_to_menu.setOnClickListener(this@CharacterList)
    }

    override fun onClick(v: View?) {
        if (v!= null) {
            when (v.id) {
                R.id.back_to_menu -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
