package com.example.movieapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapplication.BR
import com.example.movieapplication.R
import com.example.movieapplication.data.Result

class MovieAdapter(val data:List<Result>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){



     class MovieViewHolder(private val viewDataBinding:ViewDataBinding): RecyclerView.ViewHolder(viewDataBinding.root){

         fun bind(item:Result){
             viewDataBinding.setVariable(BR.model,item)
             viewDataBinding.executePendingBindings()
             with(viewDataBinding.root){

             }
         }
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.layout_movie_item,parent,false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val model = data[position]
        holder.bind(model)
    }


    override fun getItemCount(): Int {
        return data.size
    }
}