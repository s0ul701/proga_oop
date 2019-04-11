import java.io.FileNotFoundException
import java.io.FileReader
import kotlin.system.exitProcess

import Container.*
import java.io.FileWriter


fun main(args: Array<String>) {
    if (args.size != 2) {
        println("***\nIncorrect command line!\n" +
                "Waited: command in_file out_file\n***")
        exitProcess(1)
    }

    println("***\nStart\n***\n")

    val cont = Container()

    val fileIn: FileReader

    try {
        fileIn = FileReader(args[0])
    }
    catch (e: FileNotFoundException) {
        println("File not exist!\n")
        return
    }

    cont.In(fileIn)
    fileIn.close()
    println("***\nFilled container\n***\n")

    val fileOut1 = FileWriter(args[1], false)
    cont.Out(fileOut1)
    fileOut1.close()
    println("***\nFilled file\n***\n")

    val fileOut3 = FileWriter(args[1], false)
    cont.Sort()
    cont.Out(fileOut3)
    fileOut3.close()
    println("***\nFilled file (sort)\n***\n")

    val fileOut4 = FileWriter(args[1], false)
    cont.FilterOut(fileOut4)
    fileOut4.close()
    println("***\nFilled file (filter)\n***\n")

    cont.Clear()
    println("***\nErased container\n***\n")

    val fileOut2 = FileWriter(args[1], false)
    cont.Out(fileOut2)
    fileOut2.close()
    println("***\nStop\n***\n")
}