package FuncLg

import ProgLg.*
import java.io.FileWriter

class FuncLg(): ProgLg() {
    var tipization: Tipization? = null
    var isLazyCalc: Boolean? = null

    constructor(str: String): this() {
        InData(str)
    }

    override fun InData(str: String) { // Функция заполнения объекта функционального языка
        creationYear = try {
            str.split(' ')[1].toInt()
        }
        catch (e: IndexOutOfBoundsException) { // Тело проверки на правильность входных данных
            println("Warn: FuncLg.creationYear\n" +
                    "Small quantity of initial parameters.\n\n")
            null
        }
        catch (e: NumberFormatException) {
            println("Warn: FuncLg.creationYear\n" +
                    "Wrong initial parameter \"creationYear\" (Can't convert String to Int).\n\n")
            null
        }

        mentions = try {
            str.split(' ')[2].toInt()
        }
        catch (e: IndexOutOfBoundsException) {
            println("Warn: FuncLg.mentions\n" +
                    "Small quantity of initial parameters.\n\n")
            null
        }
        catch (e: NumberFormatException) {
            println("Warn: FuncLg.mentions\n" +
                    "Wrong initial parameter \"mentions\" (Can't convert String to Int).\n\n")
            null
        }

        tipization = try {
            when (str.split(' ')[3]) {
                "0" -> Tipization.STRONG
                "1" -> Tipization.DYNAMIC
                else -> null
            }
        }
        catch (e: IndexOutOfBoundsException) {
            println("Warn: FuncLg.tipization\n" +
                    "Small quantity of initial parameters.\n\n")
            null
        }
        catch (e: NumberFormatException) {
            println("Warn: FuncLg.tipization\n" +
                    "Wrong initial parameter \"tipization\" (Can't convert String to Int).\n\n")
            null
        }

        isLazyCalc = try {
            when (str.split(' ')[4]) {
                "0" -> false
                "1" -> true
                else -> null
            }
        }
        catch (e: IndexOutOfBoundsException) {
            println("Warn: FuncLg.isLazyCalc\n" +
                    "Small quantity of initial parameters.\n\n")
            null
        }
        catch (e: NumberFormatException) {
            println("Warn: FuncLg.isLazyCalc\n" +
                    "Wrong initial parameter \"isLazyCalc\" (Can't convert String to Int).\n\n")
            null
        }
    }

    override fun OutData(fileOut: FileWriter) { // Функция вывода в файл
        fileOut.write("Language type: Func\n")

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

        if (tipization != null) {
            fileOut.write("FuncLg.Tipization: $tipization\n")
        }
        else {
            fileOut.write("FuncLg.Tipization: -\n\n")
        }

        if (isLazyCalc != null) {
            fileOut.write("Is lazy calc: $isLazyCalc\n\n")
        }
        else {
            fileOut.write("Is lazy calc: -\n\n")
        }

        fileOut.write("\n")
    }
}