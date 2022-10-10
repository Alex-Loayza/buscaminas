package com.example.busca_mina1

class Casilla (es_mina : Boolean, minaDesc: Boolean,
               minamarc: Boolean, nminas : Int){

    var esMina:Boolean= es_mina
    var descubierta:Boolean = minaDesc
    var minaMarcada:Boolean = minamarc
    var numMinas:Int= nminas


    @JvmName("getEsMina1")
    fun getEsMina(): Boolean{
        return esMina;
    }
    @JvmName("setEsMina1")
    fun setEsMina(es_mina: Boolean){
        esMina = es_mina;
    }
    @JvmName("getDescobierta1")
    fun getDescubierta(): Boolean{
        return descubierta

    }
    @JvmName("setDescobierta1")
    fun setDescubierta( mina_desc : Boolean){
        descubierta = mina_desc
    }
    @JvmName("getMinaMarcada1")
    fun getMinaMarcada(): Boolean{
        return minaMarcada
    }
    @JvmName("setMinaMarcada1")
    fun setMarcaMina(min_marc :Boolean){
        minaMarcada = min_marc
    }
    fun setMines(valor : Int){
        numMinas = valor
    }
    fun getMines():Int{
        return numMinas
    }
    override fun toString(): String{
        var retorna : String=""
        if(!getDescubierta()){
            return  "."
        }
        else if(getEsMina()){
            return  "#"
        }
        else if(getMinaMarcada()){
            return  "*"
        }
        else if(getMines()>=0 && getMines()<=8){
            return "$numMinas"
        }
        return ""
    }
}
