
import java.util.ArrayList;
import java.util.Arrays;
public class MinCoins {
    
    public static void main(String[] args) {
         int V = 49;

    int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
    int n = coins.length;
    System.out.println(minCoins(coins, n, V));
    }
    	public static int minCoins(int coins[], int M, int V) 
        {

            Arrays.sort(coins);
            int temp = V;
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = M - 1; i >= 0; i--) {
                while (V >= coins[i]) {
                    V -= coins[i];
                    ans.add(coins[i]);
                    if (sumTotal(ans) == temp) {
                        return ans.size();

                    }

                }
            }

            return -1;
        }

        static int sumTotal(ArrayList<Integer> arr) {
            int sum = 0;
            for (int i = 0; i < arr.size(); i++) {
                sum = sum + arr.get(i);
            }
            return sum;
        }
}
