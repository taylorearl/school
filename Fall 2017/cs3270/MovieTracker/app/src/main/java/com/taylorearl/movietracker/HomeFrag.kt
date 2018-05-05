package com.taylorearl.movietracker


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * A simple [Fragment] subclass.
 */
class HomeFrag : Fragment() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: RecyclerAdapter
    private val lastVisibleItemPosition: Int
        get() = linearLayoutManager.findLastVisibleItemPosition()
    private var movieList: ArrayList<Movies> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_home, container, false)
    }

    override fun onResume() {
        super.onResume()
        val ma = activity as MainActivity
        ma.supportActionBar!!.setSubtitle("Popular")
        val api = TheMovieDBAPI()
        api.setPopularSearchParams()
        //loadingPanel.setVisibility(View.VISIBLE)
        Log.d("testing", "Before API")
        val movieList = api.popularSearch().execute("")
        //loadingPanel.setVisibility(View.GONE)
        Log.d("testing", "During API")
        while(!api.hasResults){
            val a = 0;
            Log.d("testing", "Waiting API")
        }
        Log.d("testing", "After API")
        linearLayoutManager = LinearLayoutManager(context)
        mainRecView.layoutManager = linearLayoutManager
        adapter = RecyclerAdapter(api.movieList as ArrayList<Movies>, this)
        mainRecView.adapter = adapter
        setRecyclerViewScrollListener()
    }

    private fun setRecyclerViewScrollListener() {
        mainRecView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val totalItemCount = recyclerView!!.layoutManager.itemCount
                /*
                if (!imageRequester.isLoadingData && totalItemCount == lastVisibleItemPosition + 1) {
                    requestPhoto()
                }
                */
            }
        })
    }
}// Required empty public constructor
