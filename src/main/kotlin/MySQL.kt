import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement


internal object MySQL {

    private var connection: Connection? = null

    fun startMySQL() {
        val url = "jdbc:mysql://databases-auth.000webhost.com:3306/id20158736_weatheresp"
        val user = "id20158736_admin"
        val password = "LeaGauGgel18.06"

        try {
            Class.forName("com.mysql.cj.jdbc.Driver")
            connection = DriverManager.getConnection(url, user, password)
            println("Connected to MySQL!")
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    fun stopMySQL() {
        try {
            connection?.close()
            println("Disconnected from MySQL.")
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    fun getMySQL(query: String): String? {
        var result: String? = null
        try {
            val statement: Statement = connection?.createStatement() ?: return null
            val resultSet: ResultSet = statement.executeQuery(query)
            if (resultSet.next()) {
                result = resultSet.getString(1)
            }
            resultSet.close()
            statement.close()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return result
    }

}