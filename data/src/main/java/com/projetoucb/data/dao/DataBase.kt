package com.projetoucb.data.dao

import android.content.Context
import androidx.room.Room
import com.projetoucb.data.R

class DataBase {
    companion object {
        private var base: AppDataBase? = null
    }

    fun getDataBase(context: Context): AppDataBase {
        if (base == null)
            base = Room.databaseBuilder(
                context,
                AppDataBase::class.java,
                context.getString(R.string.app_name))
                .fallbackToDestructiveMigration().build()

        return base as AppDataBase
    }
    fun resetDB(context: Context)
    {
        getDataBase(context)
        base?.UsuarioDao()?.deleteAll()
    }
}