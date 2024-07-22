import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-5);
        stack.push(-1);
        stack.push(-4);
        stack.push(5);
        stack.push(-1);
        sortStack(stack);
        System.out.println(stack);
            

    }
    public static void sortStack(Stack<Integer> st) {
		
		if (st.size() == 0) {
			return;
		}
		int temp = st.pop();
		sortStack(st);
		insertSorted(temp,st);

	}
	public static void insertSorted(int currEl,Stack<Integer> st){
		if (st.empty() || st.peek() < currEl) {
			st.push(currEl);
			return;
		}
		int temp = st.pop();
		insertSorted(currEl, st);
		st.push(temp);
	}
}
