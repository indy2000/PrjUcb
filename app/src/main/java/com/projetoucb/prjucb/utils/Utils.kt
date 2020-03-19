package com.projetoucb.prjucb.utils

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat

object Utils {
    fun dialogoNeutro(context: Context, message: String, buttonText: String, titulo: String? = null): AlertDialog
    {
        var dialogo = AlertDialog.Builder(context).create()
        dialogo.setMessage(message)
        titulo?.let { dialogo.setTitle(it) }
        dialogo.setButton(androidx.appcompat.app.AlertDialog.BUTTON_NEUTRAL,buttonText, DialogInterface.OnClickListener { dialog, which ->
            dialogo.dismiss()
        })

        dialogo.show()

        dialogo.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(ContextCompat.getColor(context,android.R.color.white))
        return dialogo
    }
}