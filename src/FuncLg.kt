import java.io.FileWriter

class FuncLg(): ProgLg() {
    private var typing: Typing? = null
    private var isLazyCalc: Boolean? = null

    constructor(str: String): this() {
        InData(str)
    }

    override fun InData(str: String) {
        typing = when (str.split(' ')[2]) {
            "0" -> Typing.STRONG
            "1" -> Typing.DYNAMIC
            else -> null
        }
        isLazyCalc = when (str.split(' ')[3]) {
            "0" -> false
            "1" -> true
            else -> null
        }
        creationYear = str.split(' ')[1]
    }

    override fun OutData(fileOut: FileWriter) = fileOut.write("Language type: Func\nYear creation: $creationYear\nTyping: $typing\nIs lazy calculations: $isLazyCalc\n\n")

}