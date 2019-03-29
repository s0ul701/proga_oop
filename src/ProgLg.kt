import java.io.FileWriter

open class ProgLg() {
    var creationYear : Int? = null
    protected var mentions: Int? = null

    constructor(str: String) : this() {
        creationYear = try {
            str.split(' ')[1].toInt()
        }
        catch (e: IndexOutOfBoundsException) {
            println("Warn: ProgLg.creationYear\nSmall quantity of initial parameters.\n\n")
            null
        }
        catch (e: NumberFormatException) {
            println("Warn: ProgLg.creationYear\nWrong initial parameter \"creationYear\" (Can't convert String to Int).\n\n")
            null
        }

        mentions = try {
            str.split(' ')[2].toInt()
        }
        catch (e: IndexOutOfBoundsException) {
            println("Warn: ProcLg.mentions\nSmall quantity of initial parameters.\n\n")
            null
        }
        catch (e: NumberFormatException) {
            println("Warn: ProcLg.mentions\nWrong initial parameter \"mentions\" (Can't convert String to Int).\n\n")
            null
        }
        In(str)
    }

    companion object Companion {
        fun In(str : String) : ProgLg? {
            var pg = ProgLg()

            try {
                pg = when (str.split(' ')[0]) {
                    "0" -> ProcLg(str)
                    "1" -> OopLg(str)
                    "2" -> FuncLg(str)
                    else -> {
                        println("Warn: ProgLg.In\nWrong initial parameter \"langType\".\n\n")
                        return null
                    }
                }
            }
            catch (e: IndexOutOfBoundsException) {
                println("Warn: ProgLg.langType\nSmall quantity of initial parameters.\n\n")
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

    open fun InData(str: String) {}

    open fun OutData(fileOut: FileWriter) {}
}