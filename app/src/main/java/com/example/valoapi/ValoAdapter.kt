package com.example.valoapi

import ValoAgents.Data
import ValoAgents.ValoAgents
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ValoAdapter(val agents: ValoAgents) :
    RecyclerView.Adapter<ValoAdapter.ViewHolder>() {
    lateinit var context:Context
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var agents: TextView = view.findViewById(R.id.agentName)
        var img: ImageView = view.findViewById(R.id.agentImage)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        context = parent.context
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.agents.text = agents.data[position].displayName
        Glide.with(context).load(agents.data[position].displayIconSmall).into(holder.img)
        holder.img.setOnClickListener{
            Toast.makeText(context,agents.data[position].displayName,Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return agents.data.size
    }
}
