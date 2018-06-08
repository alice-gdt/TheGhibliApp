package fr.epita.theghibliapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

data class Movie(val title : String,
                 val director : String,
                 val year : String,
                 val description : String)

class ViewHolder(val titleTextView: TextView, val directorTextView: TextView)

class MovieListAdapter(private val context: Context, private val data: MutableList<Movie>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val currentItem: Movie = getItem(position)
        val layoutInflater = LayoutInflater.from(context)
        val rowView: View
        val viewHolder : ViewHolder

        if (convertView == null) {
            rowView = layoutInflater.inflate(R.layout.movie_list, parent, false);
            viewHolder = ViewHolder(rowView.findViewById(R.id.title), rowView.findViewById(R.id.director))
        }
        else
        {
            rowView = convertView
            viewHolder = rowView.tag as ViewHolder
        }
        viewHolder.titleTextView.text = currentItem.title
        viewHolder.directorTextView.text = System.getProperty("line.separator") + "    by " + currentItem.director
        return rowView
    }

    override fun getItem(position: Int): Movie {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.size;
    }
}