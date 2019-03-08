package dsc.workshop.androidloveskotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import dsc.workshop.androidloveskotlin.R
import dsc.workshop.androidloveskotlin.model.History

class HistoryAdapter(val context: Context, var historyList: ArrayList<History>) :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return historyList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.history_item, false)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val aPoinTV = itemView.findViewById<TextView>(R.id.aPoinTV)
        val bPoinTV = itemView.findViewById<TextView>(R.id.bPoinTV)
    }

}