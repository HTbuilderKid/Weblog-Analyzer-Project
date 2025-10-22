1. Hours 10, 14, 17 & 18 are the busiest times of the day

2. Person[] people;

3. boolean[] vacant;

5. The error is that the square brackets are in front of the type int, when it should come after it: int[] counts; the rest if fine.

6. 
A. readings = new double[60];
B. urls = new String[90];
C. machines = new TicketMachine[5];

7. The only String object created by the declaration is the array itself, because even though it has a range of 20, we haven't yet assigned any values to it, which should mean that they are null

8. The error here is that new double(50); should be a pair of square brackets new double[50];

9. I think that it will lead to an error, since we learned that arrays in java are 0 indexed. If hours equals to hourCounts.length, it will try to access an out of bounds index, which doesn't exist, so it will return an error.

11.
public void printGreater(double[] marks, double mean) {
   for (int index = 0; index < marks.length; index++) {
     if (marks[index] > mean) {
       System.out.println(marks[index]);
     }
   }
}

13. 
public int numberOfAccesses()
{
   int total = 0;
   for (int count : hourCounts) {
      total += count;
   }
   return total;
}

17. If there are two hours with the same count, the busiest method will return the first one it found in the loop
