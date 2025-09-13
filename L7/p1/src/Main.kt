import java.sql.Timestamp
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date

fun <T : Comparable<T>>max(first : T , second : T):T{
   val k = first.compareTo(second)
   return if ( k == 1) first else second
}

fun Change( searched : HistoryLogRecord, changed : HistoryLogRecord, obj : MutableMap< out Timestamp,out HistoryLogRecord> ):MutableMap<Timestamp,HistoryLogRecord>?{

    val copy = obj.toMutableMap()
    val find = obj.get(searched.startDate)
    if( find !=null)
    {
         copy[searched.startDate] = changed
    }

   return copy
}

fun main() {

   val file = File("history.log")

   var history : MutableMap<Timestamp,HistoryLogRecord> = mutableMapOf()
   val regexTime = Regex("""Start-Date:\s+(\d{4}-\d{2}-\d{2})\s+(\d{2}:\d{2}:\d{2})""")
   val regexCommand = Regex("""Commandline:\s+(.+)""")
   val dataFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

   var i=0
   val lines = file.readLines()
   while ( i < lines.size)
   {
      val line = lines[i]
      val matchTime = regexTime.find(line)

      if (matchTime != null)
      {
         val (date, time) = matchTime.destructured
         val dateTime = "$date $time"
         val timestamp = Timestamp(dataFormat.parse(dateTime).time)

         if( i+1 < lines.size)
         {
            val matchCommand = regexCommand.find(lines[i+1])
            if(matchCommand !=null)
            {
               val command = matchCommand.groupValues[1]

               var obj = HistoryLogRecord(timestamp, command)   //finish
               history.plusAssign(timestamp to obj)

            }
         }
      }
      i++
   }
   i=1
   history.forEach{ (time , command) ->
      println("\tRecord : $i")
      println(command)
      println()
      i++
   }

   val timestamp1 = Timestamp(2023,12,23,3,4,2,0)
   val timestamp2 = Timestamp(2024,2,2,3,4,2,1)
   val a = HistoryLogRecord(timestamp1,"pwd")
   val b = HistoryLogRecord(timestamp2,"mkdir")
   val maxDate = max(a,b)
   println(maxDate)

   val c = Change(maxDate,a,history)

   i=1
   println()
   if(c !=null)
   {
      c.forEach{ (time , command) ->
         println("\tRecord : $i")
         println(command)
         println()
         i++
      }
   }
}