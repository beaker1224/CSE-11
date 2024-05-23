import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @param <K> The type of the keys of this BST. They need to be comparable by nature of the BST
 * "K extends Comparable" means that BST will only compile with classes that implement Comparable
 * interface. This is because our BST sorts entries by key. Therefore keys must be comparable.
 * @param <V> The type of the values of this BST. 
 */
public class BST<K extends Comparable<? super K>, V> implements DefaultMap<K, V> {
	//supposed to be a linked list
	//do I have to add KV? A node should have left and right
	Node<K,V> root; 
	int size;
	public BST (){
		this.root = null;
		this.size = 0;
	}


	@Override
	public boolean put(K key, V value) throws IllegalArgumentException {
		//check if the key is null
		if(key == null){throw new IllegalArgumentException(DefaultMap.ILLEGAL_ARG_NULL_KEY);}
		//check if the key is already there, if it is, then just return
		if(containsKey(key)){return false;}
		root = put(root, key, value);
		return true;
	}

	//helper
	/**
	 * will add the key and value to the end of a BST
	 * @param node should be root for all time
	 * @param key the new key you want to add
	 * @param value the new value you want to add
	 * @return return the added node with key and value
	 */
	public Node<K,V> put(Node<K,V> node, K key, V value){
		if(node == null){
			//this is a check if the node reaches the end tree
			size ++;
			return new Node<K,V>(key, value);
		}
		
		if(key.compareTo((K)node.key) < 0){
			//if the key is smaller, move to left
			node.left = put(node.left, key, value);
		}
		else if(key.compareTo((K)node.key) > 0){
			//if the key is bigger, move to right
			node.right = put(node.right, key, value);
		}else{
			//if this is the key, update
			node.value = value;
		}
		return node;

	}

	@Override
	public boolean replace(K key, V newValue) throws IllegalArgumentException {
		if(key == null){throw new IllegalArgumentException(DefaultMap.ILLEGAL_ARG_NULL_KEY);}
		
		Node<K,V> n = locateNode(root, key);
		if(n != null){
			n.value = newValue;
			return true;
		}else{
			return false;
		}
	}


	//helper (maybe can replace by input only key and node into root)

	/**
	 * will return a node for a input value, use root as the first input
	 */
	public Node<K,V> locateNode(Node<K,V> node, K key){
		if (node == null){return null;}

		if(key.compareTo((K)node.key) == 0){
			return node;
		}	
		else if(key.compareTo((K)node.key) > 0){
			return locateNode(node.right, key);
		}
		else{
			return locateNode(node.left, key);
		}
		
	}

	@Override
	public boolean remove(K key) throws IllegalArgumentException {
		if(key == null){throw new IllegalArgumentException(DefaultMap.ILLEGAL_ARG_NULL_KEY);}
		Node<K,V> n = locateNode(root, key);
		int start = size;
		root = remove(root, key);
		return size < start;
	}
	//helper
	Node<K,V> remove (Node<K,V> node, K key){
		if (node == null){return null;}

		if(key.compareTo((K)node.key) < 0){
			node.left = remove(node.left, key);
		}
		else if(key.compareTo((K)node.key) > 0){
			node.right = remove(node.right, key);
		}
		else{//at the node that key matches
			if(node.left == null && node.right == null){
				node = null;
				size --;
			}
			else if(node.left == null){
				node = node.right;
				size --;
			}
			else if(node.right == null){
				node = node.left;
				size --;
			}
			else{
				Node<K,V> maxNode = max(node.left);
				node.key = maxNode.key;
				node.value = maxNode.value;
				node.left = remove(node.left, maxNode.key);
			}
		}
		return node;
	}
// find the max node
	Node<K,V> max(Node<K,V> node){
		if(node.right == null){return node;}
		return max(node.right);
	}


	@Override
	public void set(K key, V value) throws IllegalArgumentException {
		if(key == null){throw new IllegalArgumentException(DefaultMap.ILLEGAL_ARG_NULL_KEY);}
		if(!containsKey(key)){
			put(key, value);
		}
		else{
			replace(key, value);
		}
	}

	@Override
	public V get(K key) throws IllegalArgumentException {
		if(key == null){throw new IllegalArgumentException(DefaultMap.ILLEGAL_ARG_NULL_KEY);}
		Node<K,V> n = locateNode(root, key);
		if(n == null){
			return null;
		}
		return n.getValue();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public boolean containsKey(K key) throws IllegalArgumentException {
		if(key == null){throw new IllegalArgumentException(DefaultMap.ILLEGAL_ARG_NULL_KEY);}

		return locateNode(root, key) != null;
	}

	// Keys must be in ascending sorted order
	// You CANNOT use Collections.sort() or any other sorting implementations
	// You must do inorder traversal of the tree
	@Override
	public List<K> keys() {
		ArrayList<K> keyList = new ArrayList<>();
		toList(root, keyList);
		return keyList;
	}
	//this should be added from left to right from the last level
	//then level goes up
	void toList(Node<K,V> node, List<K> list){
		if(node == null){return;}
		toList(node.left, list);
		list.add(node.getKey());
		toList(node.right, list);
	}
	
	private static class Node<K extends Comparable<? super K>, V> 
								implements DefaultMap.Entry<K, V> {
		K key;
		V value;
		Node<K,V> left;
		Node<K,V> right;

		private Node(K key, V value){
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
			//this will give us everytime once we create a node
			//we will get a node that have left and right as null
		}

		@Override
		public K getKey() {
			return this.key;
		}

		@Override
		public V getValue() {
			return this.value;
		}

		@Override
		public void setValue(V value) {
			this.value = value;
		}	
	
	}
	 
}