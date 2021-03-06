package fr.epita.theghibliapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CharacterFilmList(
        private val context: Context,
        private val data: MutableList<Movie>) : BaseAdapter() {
    override fun getCount(): Int {
        return data.size
    }
    override fun getItem(position: Int): Movie {
        return data[position]
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup?): View {
        val currentItem: Movie = getItem(position)
        val layoutInflater = LayoutInflater.from(context)
        val rowView = layoutInflater.inflate(
                R.layout.activity_character_list,
                parent,
                false
        );
        val nameTextView = rowView.findViewById<TextView>(R.id.characters)
        nameTextView.text = currentItem.title
        return rowView;
    }
}