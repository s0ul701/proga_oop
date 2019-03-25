import java.io.FileWriter

class FuncLg(): ProgLg() {
    private var tipization: Tipization? = null
    private var isLazyCalc: Boolean? = null

    constructor(str: String): this() {
        InData(str)
    }

    override fun InData(str: String) {
        tipization = when (str.split(' ')[2]) {
            "0" -> Tipization.STRONG
            "1" -> Tipization.DYNAMIC
            else -> null
        }
        isLazyCalc = when (str.split(' ')[3]) {
            "0" -> false
            "1" -> true
            else -> null
        }
        creationYear = str.split(' ')[1]
    }

    override fun OutData(fileOut: FileWriter) = fileOut.write("Language type: Func\nYear creation: $creationYear\nNumber of years: ${this.NumberOfYears()}\nTyping: $tipization\nIs lazy calc: $isLazyCalc\n\n")

}