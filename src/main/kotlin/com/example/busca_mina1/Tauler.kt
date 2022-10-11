package com.example.busca_mina1
import kotlin.random.Random

class Tauler(n1 : Int, nm:Int) {
    var n = n1
    var nm = nm

    var casillas = Array(n) { Array(n) { Casilla(false, false, false, 0) } }

    init {
        posaMines(nm);
        comptaMines()
    }

    fun posaMines(nm: Int) {
        var cont = 0

        while (cont < nm) {
            var x = Random.nextInt(0, n)
            var y = Random.nextInt(0, n)
            if (casillas[x][y].getEsMina() === false) {
                casillas[x][y].setEsMina(true)
                cont++
            }
        }
    }

    fun comptaMines() {

        for (i in 0 until casillas.size) {
            for (j in 0 until casillas[i].size) {
                var top: Int
                var right: Int
                var left: Int
                var bottom: Int
                var contador: Int = 0
                //top
                if (i - 1 >= 0) {
                    top = i - 1
                } else {
                    top = 0
                }
                //bottom
                if (i + 1 <= (n - 1)) {
                    bottom = i + 1
                } else {
                    bottom = n - 1
                }
                //rigth
                if (j + 1 <= (n - 1)) {
                    right = j + 1
                } else {
                    right = n - 1
                }
                //left
                if (j - 1 >= 0) {
                    left = j - 1
                } else {
                    left = 0
                }
                for (l in top..bottom) {
                    for (m in left..right) {

                        if (casillas[l][m].getEsMina()) {
                            contador++
                        }
                    }
                }
                casillas[i][j].setMines(contador)
            }
        }
    }

    fun hiHaMina(x: Int, y: Int): Boolean {
        var afirma: Boolean
        if (casillas[x][y].getEsMina() == true) {
            afirma = true
        } else {
            afirma = false
        }
        return afirma
    }

    fun descobert():Boolean{
        var ganar = true
        for(i in 0..n-1) {
            for (j in 0..n-1) {
                if(casillas[i][j].getDescubierta()== false) {
                    if(casillas[i][j].getEsMina()==false)
                        ganar = false
                }
            }
        }
        return ganar
    }

    fun descobreixCasella(x: Int, y: Int) {
        casillas[x][y].setDescubierta(true)
    }

    fun descobreixTauler() {
        for (i in 0..casillas.size) {
            for (j in 0..casillas[i].size) {
                casillas[i][j].setDescubierta(true)
            }
        }

    }

    fun descoberta(x: Int, y: Int): Boolean {
        return casillas[x][y].getDescubierta()
    }

    fun marcaMina(x: Int, y: Int) {
        if (casillas[x][y].getMinaMarcada() == false) {
            casillas[x][y].setMarcaMina(true)
        } else {
            casillas[x][y].setMarcaMina(false)
        }
    }

    fun minaMarcada(x: Int, y: Int): Boolean {
        return casillas[x][y].getMinaMarcada()
    }


    override fun toString(): String {

        var ret = "";
        //Primera fila de letras
        for (i in 0 until n) {
            ret += " " + (i + 97).toChar();
        }
        ret += "\n";
        for (i in 0 until n) {
            ret += (i + 97).toChar() + "";
            for (j in 0 until n) {
                ret += casillas[i][j].toString();
            }
            ret += "\n";
        }
        println(ret)
        return ""
    }
}


