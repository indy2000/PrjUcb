package com.projetoucb.prjucb.utils

import android.content.Context

object Prefs
{
    private val ID = "PrjUcb_Prefs"
    fun setTema(c: Context, value: String)
    {
        val e = c.getSharedPreferences(ID, 0).edit()
        e.putString("tema", value)
        e.apply()
    }
    fun getTema(c: Context): String?
    {
        return c.getSharedPreferences(ID, 0).getString("tema","")
    }
}