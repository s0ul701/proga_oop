package tests

import jdk.nashorn.internal.runtime.JSType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

import ProcLg.*
import OopLg.*
import FuncLg.*
import ProgLg.*
import Container.*
import java.io.FileReader
import java.io.FileWriter

class Tests {

    @Test
    fun ProcLgInData() {
        val str = "test test test "
        for (i in 0..20) {
            val tmp = str + "$i"
            val procLg = ProcLg()
            procLg.InData(tmp)
            when(i) {
                0, 1 -> assertEquals(
                    JSType.toBoolean(i),
                    procLg.isAbstractDataType,
                    "Wrong \"isAbstractDataType\"")
                else -> assertEquals(null,
                    procLg.isAbstractDataType,
                    "Wrong \"isAbstractDataType\"")
            }
        }
    }

    @Test
    fun OopLgInData() {
        val str = "test test test "
        for (i in 0..20) {
            val tmp = str + "$i"
            val oopLg = OopLg()
            oopLg.InData(tmp)
            when(i) {
                0 -> assertEquals(Inheritance.SINGLE,
                    oopLg.inh,
                    "Wrong \"inh\"")
                1 -> assertEquals(Inheritance.PLURAL,
                    oopLg.inh,
                    "Wrong \"inh\"")
                2 -> assertEquals(Inheritance.INTERFACE,
                    oopLg.inh,
                    "Wrong \"inh\"")
                else -> assertEquals(null,
                    oopLg.inh,
                    "Wrong \"inh\"")
            }
        }
    }

    @Test
    fun FuncLgInData() {
        val str = "test test test"
        for (i in 0..20) {
            for (j in 0..20) {
                val tmp = "$str $i $j"
                val funcLg = FuncLg()
                funcLg.InData(tmp)
                when (i) {
                    0 -> assertEquals(
                        Tipization.STRONG,
                        funcLg.tipization,
                        "Wrong \"typing\""
                    )
                    1 -> assertEquals(
                        Tipization.DYNAMIC,
                        funcLg.tipization,
                        "Wrong \"typing\""
                    )
                    else -> assertEquals(
                        null,
                        funcLg.tipization,
                        "Wrong \"typing\""
                    )
                }
                when (j) {
                    0, 1 -> assertEquals(
                        JSType.toBoolean(j),
                        funcLg.isLazyCalc,
                        "Wrong \"isLazyCalc $j\""
                    )
                    else -> assertEquals(
                        null,
                        funcLg.isLazyCalc,
                        "Wrong \"isLazyCalc\""
                    )
                }
            }
        }
    }

    @Test
    fun ProgLgNumberOfYears() {
        for (i in 0..20) {
            val str = "0 $i 0 0"
            val progLg = (ProgLg.Companion::In)(str)
            assertEquals((2019 - i), progLg!!.NumberOfYears(), "Wrong 'NumberOfYears'")
        }
    }

    @Test
    fun ContainerOut() {
        val container = Container()
        val fileIn = FileReader("in.txt")
        container.In(fileIn)
        val fileOut = FileWriter("src/tests/tmp.txt")
        container.Out(fileOut)
        fileIn.close()
        fileOut.close()

        val file1 = FileReader("src/tests/tmp.txt")
        val file2 = FileReader("src/tests/cont_out.txt")
        assertEquals(true, file1.readText() == file2.readText(), "Wrong 'Out'")
    }

    @Test
    fun ContainerFilter() {
        val container = Container()
        val fileIn = FileReader("in.txt")
        container.In(fileIn)
        val fileOut = FileWriter("src/tests/tmp.txt")
        container.FilterOut(fileOut)
        fileIn.close()
        fileOut.close()

        val file1 = FileReader("src/tests/tmp.txt")
        val file2 = FileReader("src/tests/cont_filt.txt")
        assertEquals(true, file1.readText() == file2.readText(), "Wrong 'Filter'")
    }

    @Test
    fun ContainerSort() {
        val container = Container()
        val fileIn = FileReader("in.txt")
        container.In(fileIn)
        val fileOut = FileWriter("src/tests/tmp.txt")
        container.Sort()
        container.Out(fileOut)
        fileIn.close()
        fileOut.close()

        val file1 = FileReader("src/tests/tmp.txt")
        val file2 = FileReader("src/tests/cont_sort.txt")
        assertEquals(true, file1.readText() == file2.readText(), "Wrong 'Sort'")
    }

}