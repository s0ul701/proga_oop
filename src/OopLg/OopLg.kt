package OopLg

import ProgLg.*
import java.io.FileWriter

class OopLg(): ProgLg() {
    var inh: Inheritance ? = null

    constructor(str: String): this() {
        InData(str)
    }

    override fun InData(str: String) { Заполнение объекта ООП язык
        creationYear = try {
            str.split(' ')[1].toInt()
        }
        catch (e: IndexOutOfBoundsException) { // Проверка на корректность
            println("Warn: OopLg.creationYear\n" +
                    "Small quantity of initial parameters.\n\n")
            null
        }
        catch (e: NumberFormatException) {
            println("Warn: OopLg.creationYear\n" +
                    "Wrong initial parameter \"creationYear\" (Can't convert String to Int).\n\n")
            null
        }

        mentions = try {
            str.split(' ')[2].toInt()
        }
        catch (e: IndexOutOfBoundsException) {
            println("Warn: OopLg.mentions\n" +
                    "Small quantity of initial parameters.\n\n")
            null
        }
        catch (e: NumberFormatException) {
            println("Warn: OopLg.mentions\n" +
                    "Wrong initial parameter \"mentions\" (Can't convert String to Int).\n\n")
            null
        }

        inh = try {
            when (str.split(' ')[3]) {
                "0" -> Inheritance.SINGLE
                "1" -> Inheritance.PLURAL
                "2" -> Inheritance.INTERFACE
                else -> {
                    println("Warn: OopLg.inh\n" +
                            "Wrong initial parameter \"OopLg.Inheritance\".\n\n")
                    null
                }
            }
        }
        catch (e: IndexOutOfBoundsException) {
            println("Warn: OopLg.inh\n" +
                    "Small quantity of initial parameters.\n\n")
            null
        }
    }

    override fun OutData(fileOut: FileWriter) { // Вывод объекта ООП язык
        fileOut.write("Language type: Oop\n")

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

        if (inh != null) {
            fileOut.write("OopLg.Inheritance: $inh\n\n")
        }
        else {
            fileOut.write("OopLg.Inheritance: -\n\n")
        }

        fileOut.write("\n")

    }
}