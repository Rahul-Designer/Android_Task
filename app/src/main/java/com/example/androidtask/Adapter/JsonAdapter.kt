package com.example.androidtask.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtask.Model.ResultItem
import com.example.androidtask.Model.ResultList
import com.example.androidtask.R

class JsonAdapter(private val context: Context) : RecyclerView.Adapter<JsonAdapter.ViewHolder>() {
    var arrJson = ArrayList<ResultItem>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(info: ResultItem) {

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return arrJson.size
    }

    fun updateUserList(jsonList: List<ResultItem>) {
        arrJson.clear()
        arrJson.addAll(jsonList)
        notifyDataSetChanged()
    }
}