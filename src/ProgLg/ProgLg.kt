package ProgLg

import java.io.FileWriter
import ProcLg.*
import OopLg.*
import FuncLg.*

open class ProgLg() {
    var creationYear: Int? = null
    protected var mentions: Int? = null

    constructor(str: String): this() {
        creationYear = try {
            str.split(' ')[1].toInt()
        }
        catch (e: IndexOutOfBoundsException) {
            println("Warn: ProgLg.creationYear\n" +
                    "Small quantity of initial parameters.\n\n")
            null
        }
        catch (e: NumberFormatException) {
            println("Warn: ProgLg.creationYear\n" +
                    "Wrong initial parameter \"creationYear\" (Can't convert String to Int).\n\n")
            null
        }

        mentions = try {
            str.split(' ')[2].toInt()
        }
        catch (e: IndexOutOfBoundsException) {
            println("Warn: ProcLg.mentions\n" +
                    "Small quantity of initial parameters.\n\n")
            null
        }
        catch (e: NumberFormatException) {
            println("Warn: ProcLg.mentions\n" +
                    "Wrong initial parameter \"mentions\" (Can't convert String to Int).\n\n")
            null
        }
        In(str)
    }

    companion object Companion { // Определение типа языка программирования
        fun In(str: String): ProgLg? {
            var pg = ProgLg()

            try {
                pg = when (str.split(' ')[0]) {
                    "0" -> ProcLg(str)
                    "1" -> OopLg(str)
                    "2" -> FuncLg(str)
                    else -> {
                        println("Warn: ProgLg.In\n" +
                                "Wrong initial parameter \"langType\".\n\n")
                        return null
                    }
                }
            }
            catch (e: IndexOutOfBoundsException) {
                println("Warn: ProgLg.langType\n" +
                        "Small quantity of initial parameters.\n\n")
                return null
            }
            return pg
        }
    }

    open fun NumberOfYears(): Int? {
        return if (creationYear != null) {
            (2019 - creationYear!!)
        } else {
            null
        }
    }

    open fun InData(str: String) {} // Сигнатуры функций

    open fun OutData(fileOut: FileWriter) {}
}