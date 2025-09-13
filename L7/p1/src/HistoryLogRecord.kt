import java.sql.Timestamp
import java.util.Date

class HistoryLogRecord (
    val startDate: Timestamp,
    val command : String
): Comparable<HistoryLogRecord>
{
    override fun compareTo(other: HistoryLogRecord):Int {
        if (startDate > other.startDate)
        {
            return 1
        }
        return 0
    }

    override fun toString():String{
        return "StartTime : $startDate\n Commandline : $command"
    }
}