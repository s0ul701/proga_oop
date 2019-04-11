import java.io.File
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
        fileOut.write("Elements:\n")
        for (item in pg) {
            item.OutData(fileOut)
        }
    }

    fun Clear() {
        pg.clear()
    }

    fun Multimethod(fileOut: FileWriter) {
        for (item1 in pg) {
            for (item2 in pg) {
                item1.Multimethod(item2, fileOut)
            }
        }
    }
}