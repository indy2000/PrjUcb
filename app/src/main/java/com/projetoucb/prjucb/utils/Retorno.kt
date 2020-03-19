package com.projetoucb.prjucb.utils

open class Retorno<T>
{
    var id: Int? = null
    var obj: T? = null
    var mensagemErro: String? = null
    var exception: Throwable? = null
}