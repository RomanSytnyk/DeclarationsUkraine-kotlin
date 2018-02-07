package com.riko.declarations_ukraine.ui.search.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.riko.declarations_ukraine.R
import com.riko.declarations_ukraine.data.api.model.DeclarationItem
import com.riko.declarations_ukraine.data.api.model.DeclarationList


/**
 * Created by Roman on 11.07.2017
 */
class SearchAdapter(private val decList: DeclarationList, private val decClick: IDeclarationClick) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_declaration, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fillWith(decList.items!![position])
    }

    override fun getItemCount(): Int {
        return decList.items?.count() ?: 0
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun fillWith(item: DeclarationItem) {
            val name: TextView = itemView.findViewById(R.id.name)
            val work: TextView = itemView.findViewById(R.id.place_of_work)
            val position: TextView = itemView.findViewById(R.id.work_position)


            val emptyWorkPosition = itemView.context.getString(R.string.empty_work_position)
            name.text = item.lastName + " " + item.firstName
            work.text = item.placeOfWork
            position.text = if (item.position == emptyWorkPosition) "" else item.position

            itemView.setOnClickListener { decClick.onDeclarationClicked(item.linkPdf) }
        }
    }
}