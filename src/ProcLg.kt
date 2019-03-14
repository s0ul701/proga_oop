import java.io.FileWriter

class ProcLg() : ProgLg() {
    private var isAbstractDataType : Boolean ? = null

    constructor(str: String) : this() {
        InData(str)
    }

    override fun InData(str: String) {
        isAbstractDataType = when (str.split(' ')[2]) {
            "0" -> false
            "1" -> true
            else -> null
        }
        creationYear = str.split(' ')[1]
    }

    override fun OutData(fileOut: FileWriter) = fileOut.write("Language type: Proc\nYear creation: $creationYear\nIs abstract data type: $isAbstractDataType\n\n")
}