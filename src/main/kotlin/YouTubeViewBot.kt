import java.awt.Robot
import java.awt.event.KeyEvent
import java.io.IOException

class YouTubeViewBot {

    /****
     *
     * IMPORTANT
     * A VIEW MUST BE AT LEAST 30 SECONDS LONG TO COUNT AS VIEW
     *
     */

    /**
     * Method to start the Viewer Bot
     */
    fun startViewBot(){
        while(true){
            openYoutube()
            Thread.sleep(1000)
       }
    }

    /**
     * Method to start Google Chrome and open Youtube.com
     */
    fun openYoutube(){
        val youtubeUrl = "https://www.youtube.com/watch?v=0Vbq4wiErzo"
        val chromePath = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome"

        try {
            val process = ProcessBuilder(chromePath, youtubeUrl).start()
            Thread.sleep(3000)
            pressSpace()
            Thread.sleep(31000)
            process.destroy()
        } catch (e: IOException) {
            e.printStackTrace()
        }


    }

    /**
     * Method to start Youtube Video (Press space)
     */
    fun pressSpace(){
        val robot = Robot()

        robot.keyPress(KeyEvent.VK_SPACE)
        robot.keyRelease(KeyEvent.VK_SPACE)
    }
}