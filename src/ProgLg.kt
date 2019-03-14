import java.io.File
import java.io.FileWriter

open class ProgLg() {
    protected var creationYear : String ? = null
    constructor(str: String) : this() {
        creationYear = str.split(' ').last()
        In(str)
    }

    companion object Companion {
        fun In(str : String) : ProgLg  {
            var pg : ProgLg = ProgLg()
            when (str.split(' ')[0]) {
                "0" -> pg = ProcLg(str)
                "1" -> pg = OopLg(str)
                "2" -> pg = FuncLg(str)
            }
            return pg
        }
    }


    open fun InData(str: String) {}

    open fun OutData(fileOut: FileWriter) {}
}