import java.io.FileReader
import java.io.FileWriter

class Container {
    var len : Int = 0
    var pg : MutableList<ProgLg> = mutableListOf()

    fun In(fileIn : FileReader) {
        val lines : List<String> = fileIn.readLines()
        for (line in lines) {
            pg.add((ProgLg.Companion::In)(line))
            len++
        }
    }

    fun Out(fileOut : FileWriter) {
        fileOut.write("Elements:\n\n")
        for (item in pg) {
            item.OutData(fileOut)
        }
    }

    fun Clear() {
        pg.clear()
    }

    fun Sort() {
        for (i in 0 until this.len) {
            for (j in i until this.len) {
                if (this.pg[i].NumberOfYears() > this.pg[j].NumberOfYears()) {
                    val tmp = this.pg[i]
                    this.pg[i] = this.pg[j]
                    this.pg[j] = tmp
                }
            }
        }
    }

    fun FilterOut(fileOut : FileWriter) {
        for(item in pg) {
            if (item::class.toString() == "class ProcLg") {
                item.OutData(fileOut)
            }
        }
    }
}