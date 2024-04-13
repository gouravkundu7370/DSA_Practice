import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <=numRows; i++) {
            List<Integer> temp = generateRows(i);
            ans.add(temp);
            
        }

        return ans;
    }

    public static List<Integer> generateRows(int row) {
        int ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);
        

        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / (col);
            
            ansRow.add((ans));
            
        }

        return ansRow;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = generate(5);
        System.out.println(ans);
        
        
    
    }
}
