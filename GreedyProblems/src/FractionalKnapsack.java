import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    static class Item {
        int value, weight;

        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }

    static class itemComparator implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        double r1 = (double) (a.value) / (double) (a.weight);
    
        double r2 = (double) (b.value) / (double) (b.weight);
        if (r1 < r2) {
            return 1;
        }
        else if (r1 > r2) {
            return -1;
        }
        else {
            return 0;
        }
    
    }
}
    public static void main(String[] args) {
 int n = 3, weight = 50;
        Item arr[] = {new Item (100,20),new Item(60,10),new Item(120,30)};
        double ans = fractionalKnapsack(weight, arr, n);
        System.out.println("The maximum value is "+ans);
    }

    public static double fractionalKnapsack(int w, Item arr[], int n) {    
        Arrays.sort(arr, new itemComparator());
        int currWeight = 0;
        double ans = 0.0;
        for (int i = 0; i < n; i++) {
            if (currWeight + arr[i].weight <= w) {
                currWeight += arr[i].weight;
                ans += arr[i].value;
            }
            else {
                int rem = w - currWeight;
                ans += ((double) arr[i].value / (double) arr[i].weight) * (double) rem;
                break;
            }
            
        }
        return ans;
    }
}
