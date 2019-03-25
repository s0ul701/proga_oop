import java.io.FileWriter

class FuncLg(): ProgLg() {
    private var tipization: Tipization? = null
    private var isLazyCalc: Boolean? = null

    constructor(str: String): this() {
        InData(str)
    }

    override fun InData(str: String) {
        tipization = when (str.split(' ')[1]) {
            "0" -> Tipization.STRONG
            "1" -> Tipization.DYNAMIC
            else -> null
        }
        isLazyCalc = when (str.split(' ')[2]) {
            "0" -> false
            "1" -> true
            else -> null
        }
        creationYear = str.split(' ').last()
    }

    override fun OutData(fileOut: FileWriter) = fileOut.write("Language type: Func\nYear creation: $creationYear\nTyping: $tipization\nIs lazy calc: $isLazyCalc\n\n")

}