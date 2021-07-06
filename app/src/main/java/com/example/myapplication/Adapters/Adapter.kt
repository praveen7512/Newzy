package com.example.myapplication.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.ui.Webview
import com.example.myapplication.models.articles

class Adapter(val context: Context) : RecyclerView.Adapter<Adapter.viewholder>() {

    var movies = mutableListOf<articles>()


    fun setMovieList(movies: List<articles>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {

       val view = LayoutInflater.from(context).inflate(R.layout.singlerow,parent,false)

        return viewholder(view)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val movie = movies[position]
        holder.txt1.text= movie.title
        holder.txt2.text= movie.description
        Glide.with(context).load(movie.urlToImage).into(holder.imageView)
        holder.itemView.setOnClickListener{

            val intent = Intent(context , Webview::class.java)
            intent.putExtra("URL",movie.url)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {

      return movies.size
    }
    class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val txt1 = itemView.findViewById<TextView>(R.id.textView)
        val txt2 = itemView.findViewById<TextView>(R.id.textView2)


    }
}