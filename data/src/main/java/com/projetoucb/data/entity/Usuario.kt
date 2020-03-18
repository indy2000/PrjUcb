package com.projetoucb.data.entity

import androidx.annotation.NonNull
import androidx.room.*

@Entity
class Usuario
{
    @PrimaryKey
    @NonNull
    var id: Int? = null

    @ColumnInfo
    var nome: String? = null

    @ColumnInfo
    var email: String? = null

    @ColumnInfo
    var usuario: String? = null

    @ColumnInfo
    var senha: String? = null

    @ColumnInfo
    var tipo_usuario: Int? = null

}