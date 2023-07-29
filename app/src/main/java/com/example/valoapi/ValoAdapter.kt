package com.example.valoapi

import ValoAgents.Data
import ValoAgents.ValoAgents
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ValoAdapter(val agents:ValoAgents) :
    RecyclerView.Adapter<ValoAdapter.ValoViewHolder>() {

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ValoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        return ValoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return agents.data.size
    }

    override fun onBindViewHolder(holder: ValoViewHolder, position: Int) {
        holder.agents.text = agents.data[position].displayName
        Glide.with(context).load(agents.data[position].displayIcon).into(holder.img)
    }
    class ValoViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var img = view.findViewById<ImageView>(R.id.agentImage)
        var agents = view.findViewById<TextView>(R.id.agentName)
    }
}