import com.google.gson.Gson
import okhttp3.*
import org.openqa.selenium.By
import org.openqa.selenium.By.ByCssSelector
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import java.awt.Desktop
import java.io.IOException
import java.lang.IllegalArgumentException
import java.net.URI
import kotlin.system.measureTimeMillis

fun main() {
    val time1 = measureTimeMillis {
        println(charChecker("hallHDUJEGDZUIOrodasH$&/()O§$%&/()OLKNBVCXSRTHkjhgfcvbnfRTZJMKL;JDisteintest"))
    }
    println(time1)
}
fun charChecker(value: String): Boolean{
    val acceptedCharset = mutableListOf("a","b","c","d","e","f","g","'",">",
        "h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x",
        "y","z","1","2","3","4","5","6","7","8","9","0","!","§","$","%","&",
        "/","(",")","=","?","ß","*","+","`","´","-","_",".",":",",",";","<"," ")
    for(i in value.indices){
        if(!acceptedCharset.contains(value[i].toString().lowercase())){
            println(value[i])
            return false
        }
    }
    return true
}



fun fetchErrorCode(nexception: String): Int{
    var letterarray = mutableListOf<Char>()
    for(i in 0 until nexception.toString().length){
        letterarray.add(nexception.toString()[i])
    }
    val size = letterarray.size
    return ("" + letterarray[size-3] + letterarray[size-2] + letterarray[size-1]).toInt()
}

fun mysqltests(){
    val client = OkHttpClient()

    val url = "https://cross-cultural-auto.000webhostapp.com/php/connectUpdate.php"

    val requestBody = FormBody.Builder()
        .add("table", "newsapplication")
        .add("column", "b")
        .add("value", "123")
        .add("where", "test")
        .add("unit", "1")
        .build()

    val request = Request.Builder()
        .url(url)
        .post(requestBody)
        .build()

    client.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            e.printStackTrace()
        }

        override fun onResponse(call: Call, response: Response) {
            val responseBody = response.body?.string()
            println("Response: $responseBody")
        }
    })
}

fun mysql(){
    MySQL.startMySQL()

    val valueFromDB = MySQL.getMySQL("SELECT a FROM newsapplication WHERE test = 1")

    if (valueFromDB != null) {
        println("Value from MySQL: $valueFromDB")
    } else {
        println("Failed to retrieve value from MySQL.")
    }

    MySQL.stopMySQL()

}

fun encryption(){
    var password: String = "MeinSuperstar//($%&/()))(/&%$%%$$§§§$!%&"
    println(password)
    val cryp = EncryptionManager
    var newpw = cryp.encryption(password)
    println(newpw)
    println(cryp.decryption(newpw))

    if(password == cryp.decryption(newpw)){
        println("Password successful encrypted and decrypted")
    }
}

fun method(){
    newmethod.testvalue = -1.0
    println(newmethod.testvalue)
}
class newmethod() {
    companion object {
    var testvalue = 0.0
        get() = field
        set(value){
            if(value <= 0)
                throw IllegalArgumentException("Radius muss > 0 sein")
            field = value
        }

    }
}

fun testmethod(){
    val n = (1..100).random()
    val text =
        if(n<50) "a"
        else if(n == 50)  "b"
            else "c"

    println(text)

    when(n){
        1,2,3,4,5,6,7,8,9,10 -> println("abcd")
        else                 -> println("no luck")
    }

    lineMethod(20)
    var set = mutableSetOf<Int>()
    do{
        set.add((1..49).random())
    }while(set.size < 6)
    val lotto = set.toList().sorted()
    println(lotto)
    lineMethod(20)

    val lst = listOf(1,2,3,4)
    val newlst = lst.map({it -> it*it}) //? it*it = f(x) = x
    println(newlst)
}

/**
 * Method to start chromedriver and open youtube through it
 */
fun chromeDriver(){
    System.setProperty("webdriver.chrome.driver" , "/Users/felix/Desktop/Dev-Schreibtisch/WebsiteBot/ChromeDriver/chromedriver_mac_arm64/chromedriver")

    val chromeOptions = ChromeOptions()
    // ? chromeOptions.addArguments("--headless") creates new tab in background

    val driver: WebDriver = ChromeDriver(chromeOptions)
    driver.get("https://www.youtube.com")

    Thread.sleep(100)

    // ? Suchen des "Cookie Buttons" und clicken
    clickButton("#content > div.body.style-scope.ytd-consent-bump-v2-lightbox > div.eom-buttons.style-scope.ytd-consent-bump-v2-lightbox > div:nth-child(1) > ytd-button-renderer:nth-child(2) > yt-button-shape > button", driver)
    Thread.sleep(100)

    // ? Suchen des Anmelden Buttons
    clickButton("#buttons > ytd-button-renderer > yt-button-shape > a > yt-touch-feedback-shape > div > div.yt-spec-touch-feedback-shape__fill", driver)
    Thread.sleep(100)

    // ? Anmelden email
    val element2 = driver.findElement(By.ByCssSelector("#identifierId"))
    element2.clear()
    val email = "nitroxblue1@gmail.com"
    element2.sendKeys(email)
    Thread.sleep(100)

    // ? Anmelden weiter
    clickButton("#identifierNext > div > button > span", driver)
    Thread.sleep(6000)

    // ? quits chrome instantly
    driver.quit()

}

fun clickButton(selector: String, driver: WebDriver){
    val element = driver.findElement(By.ByCssSelector(selector))
    element.click()
}

fun startApplication() {
    val chromePath = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome"

    val processBuilder = ProcessBuilder(chromePath)
    try {
        processBuilder.start()
    } catch (e: IOException) {
        e.printStackTrace()
    }
    println("Application has been started")
}

fun browseWebsite(){
    val safariBrowser = Desktop.getDesktop()

    if (safariBrowser.isSupported(Desktop.Action.BROWSE)) {
        val youtubeURL = URI("https://www.youtube.com")
        safariBrowser.browse(youtubeURL)
    } else {
        println("Safari-Browser wird auf diesem System nicht unterstützt.")
        return
    }
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