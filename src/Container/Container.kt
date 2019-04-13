package Container

import java.io.FileReader
import java.io.FileWriter

import ProcLg.*
import ProgLg.*

class Container {
    var len: Int = 0
    var pg: MutableList<ProgLg?> = mutableListOf()

    fun In(fileIn: FileReader) { // Тела функций контейнеров
        val lines: List<String> = fileIn.readLines()
        for (line in lines) {
            pg.add((ProgLg.Companion::In)(line))
            len++
        }
    }

    fun Out(fileOut: FileWriter) {
        fileOut.write("Elements:\n\n")
        for (item in pg) {
            if (item != null) {
                item.OutData(fileOut)
            }
            else {
                fileOut.write("-\n\n")
            }
        }
    }

    fun Clear() { // Функция очистки контейнеров
        pg.clear()
    }

    fun Sort() { // Функция сортировки по возрасту языка программирования
        for (i in 0 until len) {
            if (pg[i] == null) {
                pg.add(pg.removeAt(i))
                continue
            }
            else
                if (pg[i]!!.NumberOfYears() == null) {
                    pg.add(pg.removeAt(i))
                    continue
                }
        }

        for (i in 0 until len) {
            if (pg[i] == null)
                break
            else
                if (pg[i]!!.NumberOfYears() == null)
                    break

            for (j in i until len) {
                if (pg[j] == null)
                    break
                else
                    if (pg[j]!!.NumberOfYears() == null)
                        break

                if (pg[i]!!.NumberOfYears()!! > pg[j]!!.NumberOfYears()!!) {
                    val tmp = pg[i]
                    pg[i] = pg[j]
                    pg[j] = tmp
                }
            }
        }
    }

    fun FilterOut(fileOut: FileWriter) { // Функция фильтрованного вывода
        for(item in pg) {
            if (item != null)
                if (item is ProcLg) {
                    item.OutData(fileOut)
                }
        }
    }
}