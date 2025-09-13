import java.sql.Timestamp

class SyslogRecord(
    val timestamp: Timestamp,
    val hostname : String,
    val application_name : String,
    val PID : String?,
    val log_entry : String
) {
    override fun toString(): String {
        var str : String = timestamp.toString()
        str+= " "+ hostname+" "+application_name+" "+PID+" "+log_entry+"\n"
        return str
    }
}