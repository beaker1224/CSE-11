import java.util.*;

public class MyHashMap<K, V> implements DefaultMap<K, V> {
	public static final double DEFAULT_LOAD_FACTOR = 0.75;
	public static final int DEFAULT_INITIAL_CAPACITY = 16;
	public static final String ILLEGAL_ARG_CAPACITY = "Initial Capacity must be non-negative";
	public static final String ILLEGAL_ARG_LOAD_FACTOR = "Load Factor must be positive";
	public static final String ILLEGAL_ARG_NULL_KEY = "Keys must be non-null";
	
	private double loadFactor;
	private int capacity;
	private int size;

	// Use this instance variable for Separate Chaining conflict resolution
	private List<HashMapEntry<K, V>>[] buckets;  
	
	// Use this instance variable for Linear Probing
	private HashMapEntry<K, V>[] entries; 	

	public MyHashMap() {
		this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
	}
	
	/**
	 * 
	 * @param initialCapacity the initial capacity of this MyHashMap
	 * @param loadFactor the load factor for rehashing this MyHashMap
	 * @throws IllegalArgumentException if initialCapacity is negative or loadFactor not
	 * positive
	 */
	@SuppressWarnings("unchecked")
	public MyHashMap(int initialCapacity, double loadFactor) throws IllegalArgumentException {
		if(initialCapacity < 0){
			throw new IllegalArgumentException(ILLEGAL_ARG_CAPACITY);
		}
		if(!(loadFactor > 0)){
			throw new IllegalArgumentException(ILLEGAL_ARG_LOAD_FACTOR);
		}
		this.loadFactor = loadFactor;
		this.capacity = initialCapacity;
		this.size = 0;
		// if you use Separate Chaining
		buckets = (List<HashMapEntry<K, V>>[]) new List<?>[capacity];

		// if you use Linear Probing
		// entries = (HashMapEntry<K, V>[]) new HashMapEntry<?, ?>[initialCapacity];
	}
	// next time should've wrote the checks first before the actual manipulation
	
	public void expandCapacity(){
		int newLen = this.buckets.length * 2;
		List<HashMapEntry<K, V>>[] temp = (List<HashMapEntry<K, V>>[]) (new List[newLen]);
		List<HashMapEntry<K, V>>[] ori = buckets;
		this.buckets = temp;

		for(int i = 0; i < newLen; i++){
		temp[i] = new ArrayList<>();
		}

		for(List<HashMapEntry<K, V>> b:ori){
			for(HashMapEntry<K, V> e:b){
				int index = Math.abs(e.getKey().hashCode()) % newLen;
				temp[index].add(e);
			}
		}
		buckets = temp;
		capacity = newLen;
	}

	@Override
	public boolean put(K key, V value) throws IllegalArgumentException {
		// can also use key.hashCode() assuming key is not null
		if(key == null){
			throw new IllegalArgumentException(ILLEGAL_ARG_NULL_KEY);
		}

		if(size > capacity * loadFactor){expandCapacity();}

		int hashKey = key.hashCode();
		int index = Math.abs(hashKey) % capacity; 
		List<HashMapEntry<K, V>> sBucket = buckets[index];
		if(sBucket == null){
			sBucket = new ArrayList<HashMapEntry<K, V>>();
		}
		for(HashMapEntry<K, V> e : sBucket){
			if(e.getKey().equals(key)){
				return false; // this means there is a duplicate, maybe an error msg need to be displayed?
			}
		}
		sBucket.add(new HashMapEntry<>(key, value));
		size ++;
		return true;
	}

	@Override
	public boolean replace(K key, V newValue) throws IllegalArgumentException {
		if(key == null){
			throw new IllegalArgumentException(ILLEGAL_ARG_NULL_KEY);
		}
		int hashKey = key.hashCode();
		int index = Math.abs(hashKey) % capacity;
		List<HashMapEntry<K, V>> sBucket = buckets[index];
		for (HashMapEntry<K, V> e:sBucket){
			if(e.getKey().equals(key)){
				e.setValue(newValue);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean remove(K key) throws IllegalArgumentException {
		if(key == null){
			throw new IllegalArgumentException(ILLEGAL_ARG_NULL_KEY);
		}
		int hashKey = key.hashCode();
		int index = Math.abs(hashKey) % capacity;
		List<HashMapEntry<K, V>> sBucket = buckets[index];
		for (HashMapEntry<K, V> e:sBucket){
			if(e.getKey().equals(key)){
				sBucket.remove(e);
				size--;
				return true;
			}
		}
		return false;
	}

	@Override
	public void set(K key, V value) throws IllegalArgumentException {
		if(key == null){
			throw new IllegalArgumentException(ILLEGAL_ARG_NULL_KEY);
		}

		if(replace(key, value)){ //which means if it replaces successfully, return, if it is not, add to the end.
			return;
		}else{
			put(key, value);
			size++;
		}
	
	}

	@Override
	public V get(K key) throws IllegalArgumentException {
		if(key == null){
			throw new IllegalArgumentException(ILLEGAL_ARG_NULL_KEY);
		}

		int hashKey = key.hashCode();
		int index = Math.abs(hashKey) % capacity; 
		List<HashMapEntry<K, V>> sBucket = buckets[index];

		for (HashMapEntry<K, V> e:sBucket){
			if(e.getKey().equals(key)){
				return e.getValue();
			}
		}
		return null;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return (this.size == 0);
	}

	@Override
	public boolean containsKey(K key) throws IllegalArgumentException {
		if(key == null){
			throw new IllegalArgumentException(ILLEGAL_ARG_NULL_KEY);
		}
		if(get(key) == null){
			return false;
		}
		return true;
	}

	@Override
	public List<K> keys() {
		List<K> keyList = new ArrayList<>();
		for(int i = 0; i < capacity; i++){
			if(buckets[i] == null){
				continue;
			}
			List<HashMapEntry<K, V>> sBucket = buckets[i];
			for(HashMapEntry<K, V> e:sBucket){
				keyList.add(e.key);
			}
		}
		return keyList;
	}
	
	private static class HashMapEntry<K, V> implements DefaultMap.Entry<K, V> {
		
		K key;
		V value;
		
		private HashMapEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}
		
		@Override
		public void setValue(V value) {
			this.value = value;
		}
	}
}
