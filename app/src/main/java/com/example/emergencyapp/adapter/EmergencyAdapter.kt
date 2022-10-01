package com.example.emergencyapp.adapter

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.emergencyapp.R
import com.example.emergencyapp.model.Elements

class EmergencyAdapter(val activity: Activity, val elements: ArrayList<Elements>) :
    RecyclerView.Adapter<EmergencyAdapter.ElementsVH>() {
    class ElementsVH
        (v: View) : RecyclerView.ViewHolder(v) {
        val parent: CardView = v.findViewById(R.id.parent)
        val tv: TextView = v.findViewById(R.id.text)
        val tvNumText: TextView = v.findViewById(R.id.num_text)
        val image: ImageView = v.findViewById(R.id.image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementsVH {
        val h = activity.layoutInflater.inflate(R.layout.emergency_item, parent, false)
        return ElementsVH(h)
    }

    override fun onBindViewHolder(
        holder: ElementsVH, position: Int
    ) {
        holder.tv.text = elements[position].name
        holder.tvNumText.text = elements[position].number
        holder.image.setImageResource(elements[position].pic)
        holder.parent.setOnClickListener {

            val i = Intent(Intent.ACTION_DIAL, "tel:${elements[position].number}".toUri())
            activity.startActivity(i)
        }
    }

    override fun getItemCount()= elements.size


}