package com.example.myapplication.ui

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.Adapters.Adapter
import com.example.myapplication.R
import com.example.myapplication.Repository.MainRepository
import com.example.myapplication.RetrofitService
import com.example.myapplication.models.MainViewModel
import com.example.myapplication.models.ViewModell
import com.littlemango.stacklayoutmanager.StackLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
     lateinit var viewModel: ViewModell
    val adapter = Adapter(this)
    private val retrofitService = RetrofitService.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //This will create the object of Viewmodel
        viewModel = ViewModelProvider(this,
                MainViewModel(MainRepository(retrofitService)))
                .get(ViewModell::class.java)


        //adapter set to recyclerview
        re.adapter= adapter

        // this fun will observe the data changes
        Dataobserve()


        //this fun will set th layout as stacklayout
        stacklayoutcreator()

        //invovke the function for Get request
        viewModel.getAllMovies()










        }

    private fun Dataobserve() {
        viewModel.movieList.observe(this, Observer {


            adapter.setMovieList(it)

        })
    }

    fun stacklayoutcreator(){

        val manager= StackLayoutManager(StackLayoutManager.ScrollOrientation.BOTTOM_TO_TOP)
        re.layoutManager= manager
        manager.setPagerFlingVelocity(5000)
        manager.setPagerMode(true)

        manager.setItemChangedListener(object : StackLayoutManager.ItemChangedListener {
            override fun onItemChanged(position: Int) {
                layout.setBackgroundColor(Color.parseColor(Colorchanger.Getcolor()))
            }
        })
    }



}


