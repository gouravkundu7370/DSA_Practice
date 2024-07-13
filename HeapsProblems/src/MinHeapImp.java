import java.util.ArrayList;
import java.util.List;


public class MinHeapImp {
    public static class MinHeap {
     int[] arr;
    int size;
    int capacity;

    MinHeap(int c) {
        size = 0;
        capacity = c;
        arr = new int[c];
    }

    int left(int i) {
        return (2 * i + 1);

    }

    int right(int i) {
        return (2 * i + 2);
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    void insert(int key) {
        if (size == capacity) {
            return; // heap is full
        }
        size++;
        int i = size - 1;
        arr[i] = key;
        // fix them in heap property if its violated
        while (i != 0 && arr[parent(i)] > arr[i]) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }

    int extractMin() {
        if (size <= 0) {
            return Integer.MAX_VALUE;// heap is empty
        }
        if (size == 1) {
            size--;
            return arr[0];
        }
        // Store the min value and remove
        int root = arr[0];
        arr[0] = arr[size - 1];
        size--;
        minHeapify(0);
        return root;

    }

    void minHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < size && arr[l] < arr[smallest]) {
            smallest = l;
        }
        if (r < size && arr[r] < arr[smallest]) {
            smallest = r;
        }
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            minHeapify(smallest);            
        }
    }
    }
    
    public static void main(String[] args) {
   int[][] queries = {{0, 2}, {0, 1}, {1}, {0, 43}, {0, 15}, {0, 5}, {1}};
        int[] results = minHeap(queries.length, queries);
        for (int result : results) {
            System.out.println(result);
        }
    }
      // minHeap function which take size of Queries and Queries as Input.
// Returns an array out outputs depending on the query.
  public  static int[] minHeap(int n, int[][] q) {
      // Write your code here.

      MinHeap heap = new MinHeap(n);
      List<Integer> results = new ArrayList<>();
      for (int[] qurey : q) {
          if (qurey[0] == 0) {
              heap.insert(qurey[1]);
          } else if (qurey[0] == 1) {
              results.add(heap.extractMin());
          }
      }
      int[] resArr = new int[results.size()];
      for (int i = 0; i < resArr.length; i++) {
          resArr[i] = results.get(i);
      }
      return resArr;
    }
}
