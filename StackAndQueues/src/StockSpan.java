import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpan {
   Stack<Integer> st;
   List<Integer> list;
    //Simple approach :  We will calculate the previous greatest element
    public StockSpan() {
         st=new Stack<>();
        list=new ArrayList<>();
    }

   

    public int next(int price) {
        list.add(price);
        while (st.size() > 0 && list.get(st.peek()) <= price) {
            st.pop();
            //remove index because the index will never become a 
            //previous greatest element as it is smaller       
            //than the current element itself hence we found a bigger 
            //number than the number present at that particular index...
        }
        int PGI;
        if (st.size() > 0) {
            PGI = st.peek();//if previous greates element exist......
        } else {
            PGI = -1;//if no previous greatest element present...
        }
        st.push(list.size() - 1);//add the current price to the list.....
        return (list.size() - 1) - PGI;
    }

   public static void main(String[] args) {
       StockSpan stkSpan = new StockSpan();
       System.out.println(stkSpan.next(7));
       System.out.println(stkSpan.next(2));
       System.out.println(stkSpan.next(1));
       System.out.println(stkSpan.next(3));
       System.out.println(stkSpan.next(3));
       System.out.println(stkSpan.next(1));
       System.out.println(stkSpan.next(8));
   }
  

  
}
