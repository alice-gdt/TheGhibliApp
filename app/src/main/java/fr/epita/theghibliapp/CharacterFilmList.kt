package fr.epita.theghibliapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

data class Film (
        val name : String,
        val produceur : String
)

class CharacterFilmList(
        private val context: Context,
        private val data: MutableList<Film>) : BaseAdapter() {
    override fun getCount(): Int {
        return data.size
    }
    override fun getItem(position: Int): Film {
        return data[position]
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup?): View {
        val currentItem: Film = getItem(position)
        val layoutInflater = LayoutInflater.from(context)
        val rowView = layoutInflater.inflate(
                R.layout.activity_character_list,
                parent,
                false
        );
        val nameTextView = rowView.findViewById<TextView>(R.id.characters)
        nameTextView.text = currentItem.name
        return rowView;
    }
}