import java.io.File
import java.io.FileWriter

class OopLg() : ProgLg() {
    private var inh : Inheritance ? = null

    constructor(str: String) : this () {
        InData(str)
    }

    override fun InData(str: String) {
        inh = when (str.split(' ')[1]) {
            "0" -> Inheritance.SINGLE
            "1" -> Inheritance.PLURAL
            "2" -> Inheritance.INTERFACE
            else -> null
        }
        creationYear = str.split(' ')[2]
    }

    override fun OutData(fileOut: FileWriter) = fileOut.write("OOP\tYear creation: $creationYear\t$inh\n")

    override fun MMProc(fileOut: FileWriter) {
        fileOut.write("PROCEDURE and OOP\n")
    }

    override fun MMOop(fileOut: FileWriter) {
        fileOut.write("OOP and OOP\n")
    }

    override fun Multimethod(progLg: ProgLg, fileOut: FileWriter) {
        progLg.MMOop(fileOut)
    }
}
