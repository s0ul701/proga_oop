import java.io.File
import java.io.FileWriter

class ProcLg() : ProgLg() {
    private var isAbstractDataType : Boolean ? = null

    constructor(str: String) : this() {
        InData(str)
    }

    override fun InData(str: String) {
        isAbstractDataType = when (str.split(' ')[1]) {
            "0" -> false
            "1" -> true
            else -> null
        }
        creationYear = str.split(' ')[2]
    }

    override fun OutData(fileOut: FileWriter) = fileOut.write("Proc\tYear creation: $creationYear\t$isAbstractDataType\n")
}