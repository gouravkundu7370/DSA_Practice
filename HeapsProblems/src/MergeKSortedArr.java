import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArr {
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ArrayList<Integer> al : kArrays) {
            for (Integer temp : al) {
                pq.add(temp);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.peek());
            pq.poll();
        }
        return ans;
    }

    public static ArrayList<Integer> mergeKSortedArrays1(ArrayList<ArrayList<Integer>> kArrays, int k) {
        if (k == 0) {
            return new ArrayList<Integer>();
        }
        return mergeSort(kArrays, 0, k - 1);
    }

    public static ArrayList<Integer> mergeSort(ArrayList<ArrayList<Integer>> list, int l, int h) {
        if (l == h) {
            return list.get(l);
        }
        if (l + 1 == h) {
            return merge(list.get(l), list.get(h));
        }
        int mid = l + (h - l) / 2;
        ArrayList<Integer> left = mergeSort(list, l, mid);
        ArrayList<Integer> right = mergeSort(list, mid + 1, h);
        return merge(left, right);
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        int i1 = 0;
        int h1 = list1.size() - 1;
        int i2 = 0;
        int h2 = list2.size() - 1;

        ArrayList<Integer> newList = new ArrayList<>();
        while (i1 <= h1 && i2 <= h2) {
            if (list1.get(i1) <= list2.get(i2)) {
                newList.add(list1.get(i1));
                i1++;

            } else

            {

                newList.add(list2.get(i2));

                i2++;

            }
        }
            while(i1 <= h1)

        {

            newList.add(list1.get(i1));

            i1++;

        }

        while(i2 <= h2)

        {

            newList.add(list2.get(i2));

            i2++;

        }

        return newList;
        
    }
}
