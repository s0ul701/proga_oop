import java.io.File
import java.io.FileWriter

open class ProgLg() {
    protected var creationYear : String ? = null
    constructor(str: String) : this() {
        creationYear = str.split(' ')[1]
        In(str)
    }

    companion object Companion {
        fun In(str : String) : ProgLg  {
            var pg : ProgLg = ProgLg()
            when (str.split(' ')[0]) {
                "0" -> pg = ProcLg(str)
                "1" -> pg = OopLg(str)
            }
            return pg
        }
    }

    open fun NumberOfYears(): Int = 2018 - (creationYear?.toInt() ?: 2019)

    open fun InData(str: String) {}

    open fun OutData(fileOut: FileWriter) {}
}