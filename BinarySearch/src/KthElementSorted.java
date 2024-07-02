public class KthElementSorted {
    public static void main(String[] args) {
        int arr1[] = {2, 3, 6, 7, 9};
        int arr2[] = { 1, 4, 8, 10 };
        System.out.println(kthElement(arr1, arr2, arr1.length, arr2.length, 5));

    }
      public static long kthElement( int arr1[], int arr2[], int n, int m, int k) {
          if (n > m) {
              return kthElement(arr2, arr1, m, n, k);
          }
        
          int low = Math.max(0, k - m);
          int high = Math.min(k, n);
          while (low <= high) {
              int c1 = (low + high) / 2;
              int c2 = k - c1;
              int l1 = c1 == 0 ? Integer.MIN_VALUE : arr1[c1 - 1];
              int l2 = c2 == 0 ? Integer.MIN_VALUE : arr2[c2 - 1];
              int r1 = c1 == 0 ? Integer.MAX_VALUE : arr1[c1 ];
              int r2 = c2 == 0 ? Integer.MAX_VALUE : arr2[c2 ];
              if (l1 <= r2 && l2 <= r1) {
                  return (long) Math.max(l1, l2);
              }
              else if (l1 > r2) {
                  high = c1 - 1;
              }
              else {
                  low = c1 + 1;
                 }
          }
          return 1;
    }
}
