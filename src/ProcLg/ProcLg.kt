package ProcLg

import ProgLg.ProgLg
import java.io.FileWriter

class ProcLg(): ProgLg() {
    var isAbstractDataType: Boolean? = null

    constructor(str: String): this() {
        InData(str)
    }

    override fun InData(str: String) { // Ввод объекта процедурный язык
        creationYear = try { // Проверка на корректность
            str.split(' ')[1].toInt()
        }
        catch (e: IndexOutOfBoundsException) {
            println("Warn: ProcLg.creationYear\n" +
                    "Small quantity of initial parameters.\n\n")
            null
        }
        catch (e: NumberFormatException) {
            println("Warn: ProcLg.creationYear\n" +
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

        isAbstractDataType = try {
            when (str.split(' ')[3]) {
                "0" -> false
                "1" -> true
                else -> {
                    println("Warn: ProcLg.isAbstractDataType\n" +
                            "Wrong initial parameter \"isAbstractDataType\".\n\n")
                    null
                }
            }
        }
        catch (e: IndexOutOfBoundsException) {
            println("Warn: ProcLg.isAbstractDataType\n" +
                    "Small quantity of initial parameters.\n\n")
            null
        }
    }

    override fun OutData(fileOut: FileWriter) { // Вывод объекта процедурного язык
        fileOut.write("Language type: Proc\n")

        if (creationYear != null) {
            fileOut.write("Year creation: $creationYear\n")
        }
        else {
            fileOut.write("Year creation: -\n")
        }

        if (NumberOfYears() != null) {
            fileOut.write("Quantity years from creation: ${NumberOfYears()}\n")
        }
        else {
            fileOut.write("Quantity years from creation: -\n")
        }

        if (mentions != null) {
            fileOut.write("Mentions in Internet: $mentions\n")
        }
        else {
            fileOut.write("Mentions in Internet: -\n")
        }

        if (isAbstractDataType != null) {
            fileOut.write("Is abstract data type: $isAbstractDataType\n\n")
        }
        else {
            fileOut.write("Is abstract data type: -\n\n")
        }

        fileOut.write("\n")

    }
}