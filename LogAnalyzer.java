
/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 7.0
 */
public class LogAnalyzer
{
    public static final int HOURS_PER_DAY = 24;
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer(String filename)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[HOURS_PER_DAY];
        // Create the reader to obtain the data.
        reader = new LogfileReader(filename);
    }
    
    public int busiestHour()
    {
        // a for loop is better here because I need the index of the busiest hour, not just the value
        int busiest = 0;
        for(int hour = 1; hour < hourCounts.length; hour++) {
            if (hourCounts[hour] > hourCounts[busiest]) {
                busiest = hour;
            }
        }
        return busiest;
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    //public void printHourlyCount()
    //{
    //    System.out.println("Hr: Count");
    //    for(int hour = 0; hour < hourCounts.length; hour++) {
    //        System.out.println(hour + ": " + hourCounts[hour]);
    //    }
    //}
    public void printHourlyCounts()
    {
        int hour = 0;
        System.out.println("Hr: Count");
        while(hour < hourCounts.length) {
            System.out.println(hour + ": " + hourCounts[hour]);
            hour++;
        }
    }
    
    public int numberOfAccesses()
    {
        int total = 0;
        for (int count : hourCounts) {
            total += count;
        }
        return total;
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}
