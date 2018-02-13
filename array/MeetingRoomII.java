package leeeeeeee.array;

import java.util.Arrays;

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }


public class MeetingRoomII {
    public int minMeetingRooms(Interval[] intervals) {

        if(intervals == null || intervals.length==0)
            return 0;

        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i<n ; i++)
        {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int counter =0;
        int endpoint = 0;
        for(int i=0;i<n;i++)
        {
            if(start[i]<end[endpoint])
            {
                counter++;
                continue;
            }
            else
            {
                endpoint++;
            }
        }

        return counter;
    }
}
