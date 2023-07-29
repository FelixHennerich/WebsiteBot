import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

fun main() {
    htmlRequest()
    TestClass().testfuncation()
}

fun startTerminal() {
    Runtime.getRuntime().exec("open /System/Applications/Utilities/Terminal.app")
    println("'Terminal' application has been started")
}

fun htmlRequest(){
    /**
     * Start the HTTP request
     */
    val client = OkHttpClient()
    val url = "https://httpbin.org/get"
    val request = Request.Builder()
        .url(url)
        .build()
    val response: Response = client.newCall(request).execute()


    /**
     * Check whether response is successful or not
     */
    if (response.isSuccessful) {
        /**
         * Successful response
         */

        val responseBody = response.body?.string()
        val gson = Gson()
        val testData: TestData = gson.fromJson(responseBody, TestData::class.java)


        lineMethod(30)
        println("The HTTP-Request gives u:")
        println("ORIGIN OF RESPONSE: " + testData.origin)
        println("URL OF RESPONSE: " + testData.url)
        lineMethod(30)

    } else {
        /**
         * No response (Error)
         */

        println("Error: ${response.code} ${response.message}")
    }

    /**
     * Close request to avoid errors or lags
     */
    response.close()
}

data class TestData(
    val origin: String,
    val url: String,
)

fun lineMethod(amount: Int) {
    var i = 0
    while(i <= amount){
        i++
        print("_")
    }
    println()
}