import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Nmeetings {
    

    public static void main(String[] args) {
     int   start[] = {1,3,0,5,8,5};
     int end[] = { 2, 4, 6, 7, 9, 9 };
     maxMeetings(start, end, start.length);
    }

   static class meeting {
        int start;
        int end;
        int pos;

        public meeting(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    static class meetingComparator implements Comparator<meeting> {
        @Override
        public int compare(meeting o1, meeting o2) {
            if (o1.end < o2.end)
                return -1;
            else if (o1.end > o2.end)
                return 1;
            else if (o1.pos < o2.pos)
                return -1;
            return 1;
        }
    }

     public static void maxMeetings(int start[], int end[], int n)
    {
        ArrayList<meeting> meet = new ArrayList<>();
        for (int i = 0; i < end.length; i++) {
            meet.add(new meeting(start[i], end[i], i + 1));
        }
        meetingComparator mc = new meetingComparator();
        Collections.sort(meet, mc);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(meet.get(0).pos);
        int limit = meet.get(0).end;

        for (int i = 1; i < end.length; i++) {
            if (meet.get(i).start > limit) {
                limit = meet.get(i).end;
                ans.add(meet.get(i).pos);
            }
        }
        for (int i = 0; i <ans.size(); i++) {
            System.out.print(ans.get(i)+ " ");
        }

    }
    public static int maxMeetings1(int start[], int end[], int n)
    {
        ArrayList<meeting> meet = new ArrayList<>();
        for (int i = 0; i < end.length; i++) {
            meet.add(new meeting(start[i], end[i], i + 1));
        }
        meetingComparator mc = new meetingComparator();
        Collections.sort(meet, mc);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(meet.get(0).pos);
        int limit = meet.get(0).end;

        for (int i = 1; i < end.length; i++) {
            if (meet.get(i).start > limit) {
                limit = meet.get(i).end;
                ans.add(meet.get(i).pos);
            }
        }
        return ans.size();

    }
    
}
