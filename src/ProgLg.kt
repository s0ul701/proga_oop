import java.io.File
import java.io.FileWriter

open class ProgLg() {
    protected var creationYear : String ? = null
    constructor(str: String) : this() {
        creationYear = str.split(' ')[2]
        In(str)
    }

    companion object Companion {
        fun In(str : String) : ProgLg  {
            var pg : ProgLg = ProgLg()
            when (str.split(' ')[0]) {
                "1" -> pg = ProcLg(str)
                "2" -> pg = OopLg(str)
            }
            return pg
        }
    }


    open fun InData(str: String) {}

    open fun OutData(fileOut: FileWriter) {}

    open fun Multimethod(progLg: ProgLg, fileOut: FileWriter) {}

    open fun MMOop(fileOut: FileWriter) {}

    open fun MMProc(fileOut: FileWriter) {}
}