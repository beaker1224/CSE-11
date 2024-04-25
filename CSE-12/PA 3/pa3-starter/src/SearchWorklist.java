/*
 * Class to implement SearchWorklist as a Stack and a Queue.
 * You can use any built-in Java collections for this class.
 */
import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;

class StackWorklist implements SearchWorklist {
	Stack<Square> squareStack; 
	//constructor
	StackWorklist(){
		this.squareStack = new Stack<Square>();
	}
	//methods for implementations
	public void add(Square c){
		this.squareStack.push(c);
	}
	public Square remove(){
		return this.squareStack.pop();
	}
	public boolean isEmpty(){
		return this.squareStack.isEmpty();
	}
}

class QueueWorklist implements SearchWorklist {
	ArrayList<Square> squareQueue;
	//constructor
	QueueWorklist(){
		this.squareQueue = new ArrayList<Square>();
	}
	//methods for implementations
	public void add(Square c){
		this.squareQueue.add(c);
	}
	public Square remove(){
		return this.squareQueue.remove(0);
	}
	public boolean isEmpty(){
		return this.squareQueue.size() == 0;
	}
}

public interface SearchWorklist {
	void add(Square c);
	Square remove();
	boolean isEmpty();
}
