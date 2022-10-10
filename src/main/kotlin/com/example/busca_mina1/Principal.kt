package com.example.busca_mina1

import javafx.application.Application
import javafx.stage.Stage

class Principal : Application() {
    override fun start(p0: Stage?) {

    }
}

fun main() {
    var n:Int
    var nm:Int
    var x:Int
    var y:Int


    println()
    println("Introduzca un número del 1 al 26")
    n = readLine()!!.toInt()
    if(n>26 || n<1){
        println("ERROR")
    } else {
        println("Introduzca el número de minas")
        nm = readLine()!!.toInt()
        if(nm <1 || nm > (n*n)){
            println("ERROR")
        }else{
            var tauler = Tauler(n, nm)
            while(!tauler.descobert()){
                tauler.toString()
                println("fila?")
                x= readLine()!!.toInt()
                println("columna?")
                y= readLine()!!.toInt()
                tauler.descobreixCasella(x,y)
                if(tauler.hiHaMina(x,y)){

                    tauler.descobreixTauler()
                    break;
                }
            }
            println("Partida termida")
        }
    }
}