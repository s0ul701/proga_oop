import java.io.File
import java.io.FileReader
import java.io.FileWriter
import kotlin.system.exitProcess

// val - неизмен, var - измен

fun main(args: Array<String>) {
    if (args.size != 2) {
        println("***\nIncorrect command line!\nWaited: command in_file out_file\n***")
        exitProcess(1)
    }

//    val a = fileOut.write("1234567")
//    fileOut.close()
//    fileIn.close()

    println("***\nStart\n***\n")

    var cont : Container = Container()

    val fileIn = FileReader(args[0])
    cont.In(fileIn)
    fileIn.close()
    println("***\nFilled container\n***\n")

    val fileOut1 = FileWriter(args[1], false)
    cont.Out(fileOut1)
    fileOut1.close()
    println("***\nFilled file\n***\n")

    cont.Clear()
    println("***\nErased container\n***\n")

    val fileOut2 = FileWriter(args[1], false)
    cont.Out(fileOut2)
    fileOut2.close()
    println("***\nStop\n***\n")







}