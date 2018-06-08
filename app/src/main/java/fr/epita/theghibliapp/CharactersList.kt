package fr.epita.theghibliapp

import android.content.ClipData
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.character_list.*

class CharactersList(
        private val context: Context,
        private val data: MutableList<Characters>) : BaseAdapter() {
    override fun getCount(): Int {
        return data.size
    }
    override fun getItem(position: Int): Characters {
        return data[position]
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup?): View {
        val currentItem: Characters = getItem(position)
        val layoutInflater = LayoutInflater.from(context)
        val rowView = layoutInflater.inflate(
                R.layout.character_list,
                parent,
                false
        );
        val nameTextView = rowView.findViewById<TextView>(R.id.characters)
        nameTextView.text = currentItem.firstName + " " + currentItem.lastName
        return rowView;
    }
}

class Characters_screen : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            //list_of_char.emptyView = character_list_emptylist
            val data: MutableList<Characters> = arrayListOf()
            data.add(Characters("Han", "Solo", "Star Wars", true))
            data.add(Characters("Darth", "Vader", "Star Wars", false))
// Link the adapter and the listview
            list_of_char.adapter = CharactersList(this, data)
        }
}