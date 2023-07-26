fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    test(1);
}

fun test(a: Int){
    println("tests are important");
    if(a == 1){
        println("abcd");


    }
}