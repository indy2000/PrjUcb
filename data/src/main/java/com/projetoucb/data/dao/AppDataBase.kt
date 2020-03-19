package com.projetoucb.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.projetoucb.data.entity.Usuario

@Database(
    entities = [
        Usuario::class
    ], version = 1, exportSchema = false
)
abstract class AppDataBase: RoomDatabase()
{
    abstract fun UsuarioDao(): UsuarioDao
}