package fr.epita.theghibliapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_character_detail.*

class CharacterDetail : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)
        back_to_char_list.setOnClickListener(this@CharacterDetail)
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
