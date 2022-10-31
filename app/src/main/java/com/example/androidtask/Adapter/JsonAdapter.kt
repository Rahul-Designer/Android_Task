package com.example.androidtask.Adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtask.Model.ResultItem
import com.example.androidtask.R
import com.example.androidtask.fragment.BodyResponseFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class JsonAdapter(private val context: Context) : RecyclerView.Adapter<JsonAdapter.ViewHolder>() {
    var arrJson = ArrayList<ResultItem>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                val activity = it.context as AppCompatActivity
                activity.fragment_container.visibility = View.VISIBLE
                activity.json_recyclerview.visibility = View.GONE
                val bodyResponseFragment = BodyResponseFragment()
                val bundle = Bundle()
                bundle.putString("position",adapterPosition.toString())
                bodyResponseFragment.arguments = bundle
                activity.supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, bodyResponseFragment).addToBackStack(null)
                    .commit()

            }
        }

        fun bind(info: ResultItem) {
            itemView.title.text = info.title


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pos = arrJson[position]
        holder.bind(pos)

    }

    override fun getItemCount(): Int {
        return arrJson.size
    }

    fun updateDataList(jsonList: List<ResultItem>) {
        arrJson.clear()
        arrJson.addAll(jsonList)
        notifyDataSetChanged()
    }
}