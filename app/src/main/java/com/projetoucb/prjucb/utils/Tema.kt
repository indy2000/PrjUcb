package com.projetoucb.prjucb.utils

import android.content.Context
import com.projetoucb.prjucb.R

object Tema {
      fun setTema(value: String?): Int
      {
          return when(value)
          {
              "noturno" ->  R.style.AppThemeDark
              "claro" -> R.style.AppTheme
              else -> R.style.AppTheme
          }
      }
    fun getNomeTema(c: Context): String
    {
        return when(Prefs.getTema(c))
        {
            "noturno" -> c.getString(R.string.noturno)
            "claro" -> c.getString(R.string.claro)
            else -> c.getString(R.string.claro)
        }
    }
    fun setSwitchChecked(c: Context): Boolean
    {
        return when(Prefs.getTema(c))
        {
            "noturno" -> true
            "claro" -> false
            else -> false
        }
    }
}