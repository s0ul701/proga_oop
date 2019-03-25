import java.io.FileWriter

open class ProgLg() {
    protected var creationYear : String ? = null
    protected var mentions: Int? = null
    constructor(str: String) : this() {
        creationYear = str.split(' ')[1]
        mentions = str.split(' ')[2].toInt()
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

    open fun NumberOfYears(): Int = 2018 - (creationYear?.toInt() ?: 2019)

    open fun InData(str: String) {}

    open fun OutData(fileOut: FileWriter) {}
}