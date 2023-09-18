package com.prado.crudroom.ui.subscriberlist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prado.crudroom.data.db.entity.SubscriberEntity
import com.prado.crudroom.databinding.SubscriberItemBinding

class SubscriberListAdapter(
    val subscribers: List<SubscriberEntity>
):RecyclerView.Adapter<SubscriberListAdapter.SubscriberListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriberListViewHolder {
        val binding = SubscriberItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubscriberListViewHolder(binding)
    }

    override fun getItemCount(): Int = subscribers.size

    override fun onBindViewHolder(holder: SubscriberListViewHolder, position: Int) {
        holder.bindView(subscribers[position])
    }


    inner class SubscriberListViewHolder(private var binding: SubscriberItemBinding): RecyclerView.ViewHolder(binding.root) {

        private val textviewSubscriberName: TextView = binding.subscriberName
        private val textviewSubscriberEmail: TextView = binding.subscriberEmail


        fun bindView(subscribers: SubscriberEntity){
            textviewSubscriberName.text = subscribers.name
            textviewSubscriberEmail.text = subscribers.email
        }
    }
}