package com.example.emergencyapp.data

import android.content.Context
import com.example.emergencyapp.R
import com.example.emergencyapp.model.Elements

class ElementsSource {


    fun obtain (context:Context) : ArrayList<Elements>{
        val elements= arrayListOf<Elements>()
        elements.add(Elements(context.getString(R.string.Ambulance), R.drawable.ambulance,"123"))
        elements.add(Elements(context.getString(R.string.Police), R.drawable.police,"122"))
        elements.add(Elements(context.getString(R.string.Fire_Station), R.drawable.fire,"180"))
        elements.add(Elements(context.getString(R.string.electric), R.drawable.electric,"121"))
        elements.add(Elements(context.getString(R.string.gas), R.drawable.gas,"129"))
        elements.add(Elements(context.getString(R.string.water), R.drawable.water,"125"))
        elements.add(Elements(context.getString(R.string.Baby), R.drawable.baby,"16000"))
        elements.add(Elements(context.getString(R.string.traffic), R.drawable.crashing,"128"))
        elements.add(Elements(context.getString(R.string.hacker), R.drawable.hacker,"108"))
        return elements
    }
}