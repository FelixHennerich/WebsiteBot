fun main() {
    startTerminal()
}

fun startTerminal() {
    Runtime.getRuntime().exec("open /System/Applications/Utilities/Terminal.app")
    println("'Terminal' application has been started")
}
