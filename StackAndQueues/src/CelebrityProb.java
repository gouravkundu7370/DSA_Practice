public class CelebrityProb {
    // known by all
    // knows no one
    public static void main(String[] args) {

        
        int[][] cel = {{0,1,1,0},
                {0,0,0,0},
                    {0,1,0,0},
                { 1, 1, 0, 1 } };

                System.out.println(Celeb(cel));

    }

    public static int Celeb(int[][] arr) {
        int top = 0;
        int down = arr.length - 1;

        while (top < down && top <= arr.length-1 && down >= 0 ) {
            // if top knows down => top cant be a celeb
            if (arr[top][down] == 1) {
                top++;
                // if down knows top down cant be a celeb
            } else if (arr[down][top] == 1) {
                down--;
            }
            // if top not knows down and down not knows top => then cant be a celeb
            else {
                down--;
                top++;
            }
        }
        if (top > down) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            // diagonal
            if (i == top) {
                continue;
            }
           if (arr[top][i] == 0 && arr[i][top] == 1) {
               return top;
           }
        }
        return -1;
    }
}
