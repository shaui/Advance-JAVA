package collections_operation;
// push/pop/peek/search(search the index)/empty/EmptyStackException
import java.util.EmptyStackException;
import java.util.Stack;

public class MyStack {

	public static void main(String[] args) {
		Stack<String> stk = new Stack<>();
		
		stk.push("First push");
		stk.push("Second push");
		System.out.println("The original stack : " + stk);
		
		System.out.println("\"Peek\" the stack : " + stk.peek());
		System.out.println("\"Pop\" the stack : " + stk.pop());
		System.out.println("\"Peek\" the stack : " + stk.peek());
		stk.push("Second push");
		int index = stk.search("First push");
		System.out.println("Search First push index : " + index);
		System.out.println("Search Second push index : " + stk.search("Second push"));
		
		stk.pop();
		stk.pop();
		if(stk.empty()) {
			System.out.println("Stack is empty");
		}
		else {
			System.out.println("Still have elements");
		}
		try {
			stk.pop();
		}
		catch(EmptyStackException emptyStackException){
			System.out.println("Catch the EmptyStackException. Stack is empty");	
		}
		
	}
}
