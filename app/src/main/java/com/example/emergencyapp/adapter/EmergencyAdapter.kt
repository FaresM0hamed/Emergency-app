package com.example.emergencyapp.adapter

import android.Manifest
import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.emergencyapp.R
import com.example.emergencyapp.model.Elements
import com.example.emergencyapp.ui.MainActivity
import com.permissionx.guolindev.PermissionX

class EmergencyAdapter(private val activity: Activity, private val elements: ArrayList<Elements>) :
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
            val dialog=Dialog(activity)

            //missing
            dialog.setContentView(R.layout.dialog)//error because missing of this
            dialog.setCancelable(false)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            /**
             *     v -> viewHolder
             *     val contiune:Button=v.findViewById(R.id.continuee)
             *     val cancel:Button=v.findViewById(R.id.cancel)
             *
             *     dialog -> dialog
             *     val contiune:Button=dialog.findViewById(R.id.continuee)
             *     val cancel:Button=dialog.findViewById(R.id.cancel)
             */
            val contiune:Button=dialog.findViewById(R.id.continuee)
            val cancel:Button=dialog.findViewById(R.id.cancel)
            contiune.setOnClickListener {


                try {
                    val i = Intent(Intent.ACTION_CALL, "tel:${elements[position].number}".toUri())
                    activity.startActivity(i)

                }catch (e:Exception){
                    PermissionX.init(activity as MainActivity)
                        .permissions( Manifest.permission.CALL_PHONE)
                        .onExplainRequestReason { scope, deniedList ->
                            scope.showRequestReasonDialog(deniedList, activity.getString(R.string.core), "OK", "Cancel")
                        }
                        .onForwardToSettings { scope, deniedList ->
                            scope.showForwardToSettingsDialog(deniedList, activity.getString(R.string.youNeed), "OK", "Cancel")
                        }
                        .request { allGranted, _, _ ->
                            if (allGranted) {
                                Toast.makeText(activity, activity.getString(R.string.permissionGranted), Toast.LENGTH_LONG).show()
                            } else {
                                Toast.makeText(activity, activity.getString(R.string.permissionDenied), Toast.LENGTH_LONG).show()
                            }
                        }

                }


            }
            cancel.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()


        }
    }

    override fun getItemCount()= elements.size


}