import java.io.File
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

fun hasPassedLessThan30Min(date : Date , timestamp: Timestamp):Boolean
{
    val diffInMillis = abs(timestamp.time - date.time)
    val diffInMinutes = diffInMillis/(1000 * 60)

    return diffInMinutes <= 30
}



fun main() {
    val sdf = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
    val currentDate = sdf.format(Date())

    var seq : Sequence<SyslogRecord> = sequenceOf()
    var appMap : MutableMap<String,SyslogRecord> = mutableMapOf()

    val file = File("syslog")
    val lines = file.readLines()

    val regex=Regex("""(\d{4}-\d{2}-\d{2})T(\d{2}:\d{2}:\d{2})\.\d+\+\d{2}:\d{2}\s+(\S+)\s+([^:\[]+)(?:\[(\d+)\])?:\s+([^\n]+)""")

    var i = 0
    var noEntry = 0
    while ( i < lines.size)
    {
        val line = lines[i]

        val match = regex.find(line)
        if( match != null)
        {
            val (date , time , hostname , application , pid , log_entry) = match.destructured
            val dateTime = "$date $time"
            val timestamp = Timestamp(sdf.parse(dateTime).time)

            if(hasPassedLessThan30Min(Date(),timestamp))
            {
                noEntry = 1
                val obj = SyslogRecord(timestamp,hostname,application,pid,log_entry)

                seq += obj
            }
        }

        i++
    }
    if(noEntry == 0)
    {
        println("No Entry in the last 30 minutes")
    }
   seq.forEach {
           appMap[it.application_name] = it
   }

    val sortedByLogMap = appMap.entries
        .sortedBy { it.value.log_entry }

    val filteredByLogMap = sortedByLogMap.filter { it.value.PID!=null }

    filteredByLogMap.forEach{
        println(it.value)
    }
}