package com.projetoucb.data.dao

import androidx.room.*
import com.projetoucb.data.entity.Usuario
import io.reactivex.Maybe

@Dao
abstract class UsuarioDao
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg usuario: Usuario)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAll(usuarios: List<Usuario>)

    @Update
    abstract fun update(vararg usuario: Usuario)

    @Delete
    abstract fun delete(vararg usuario: Usuario)

    @Query("DELETE FROM USUARIO WHERE id = :id")
    abstract fun delete(id: Int)

    @Query("SELECT * FROM USUARIO")
    abstract fun selectAll(): Maybe<List<Usuario>>

    @Query("DELETE FROM USUARIO")
    abstract fun deleteAll()
}