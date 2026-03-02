package dailychallenge.Day15;

import java.util.Arrays;

public class MinimumMeetingRooms {
    public static void main(String[] args) {
        int[] start = {1,10,7};

        int[] end = {4,15,10};

        System.out.print(minMeetingRooms(start, end));
    }
    public static int minMeetingRooms(int[] start, int[] end) {
        Arrays.sort(start);

        Arrays.sort(end);

        int i = 0;
        int j = 0;
        int rooms = 0;
        int maxRooms = 0;

        while(i < start.length)
        {
            if(start[i] < end[j])
            {
                rooms++;
                maxRooms = Math.max(maxRooms, rooms);
                i++;
            }
            else
            {
                rooms--;
                j++;
            }
        }
        return maxRooms;
    }
}
