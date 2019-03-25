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
        for (i in pg) {
            for (j in pg) {
                if (j.NumberOfYears().toInt() < i.NumberOfYears().toInt()) {
                    pg[pg.indexOf(i)] = j
                    pg[pg.indexOf(j)] = i
                }
            }
        }
    }
}