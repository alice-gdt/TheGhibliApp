package fr.epita.theghibliapp


import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import com.google.gson.GsonBuilder

import kotlinx.android.synthetic.main.movie_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class Movie(val title : String,
                 val director : String,
                 val year : String,
                 val description : String)

class ViewHolder(val titleTextView: TextView, val directorTextView: TextView)

/*class MovieListAdapter(private val context: Context, private val data: MutableList<Movie>) : BaseAdapter() {

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
*/
interface GhilbliService {
    @GET("films")
    fun list(): Call<List<Repo>>
}

data class Repo (val id : Int,
                 val title : String,
                 val description : String,
                 val director: String,
                 val producer : String,
                 val release_date : String,
                 val rt_score : String,
                 val people : String,
                 val spiecies : String,
                 val location : String,
                 val url : String)

class MovieList() : AppCompatActivity() {

    val list: MutableList<Movie> = arrayListOf()
    val data = arrayListOf<Repo>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_list)

        val jsonConverter = GsonConverterFactory.create(GsonBuilder().create())

        var retrofit = Retrofit.Builder()
                .baseUrl("https://ghibliapi.herokuapp.com/")
                .addConverterFactory(jsonConverter)
                .build()

        val service: GhilbliService = retrofit.create(GhilbliService::class.java)

        val callback = object : Callback<List<Repo>> {
            override fun onResponse(call: Call<List<Repo>>?, response: Response<List<Repo>>?)
            {
                if (response != null) {
                    if (response.code() == 200) {
                        // We got our data !
                        val responseData = response.body()
                        if (responseData != null) {
                            data.addAll(responseData)
                            Log.d("TAG", "WebService success : " + data.size)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<Repo>>?, t: Throwable?) {
                // Code here what happens if calling the WebService fails
                Log.d("TAG", "WebService call failed")
            }
        }

        service.list().enqueue(callback)

        Log.d("TAG", "Test " + data.size)

        list.add(Movie("The Godfather", "Francis Ford Copola", "1972", "Acu 2018 best movie"))
        list.add(Movie("The Godfather part II", "Francis Ford Copola", "1974", "Acu 2020 best movie"))
        list.add(Movie("The Godfather part III", "Francis Ford Copola", "1990", "Acu 2022 best movie"))

        /*activity_main_list_movie.emptyView = activity_main_txt_emptylist
        activity_main_list_movie.adapter = MovieListAdapter(this, list)
        activity_main_list_movie.setOnItemClickListener { adapterView, clickedView, position, id -> Toast.makeText(this, "Clicked " + position, Toast.LENGTH_SHORT).show() }*/
    }
}