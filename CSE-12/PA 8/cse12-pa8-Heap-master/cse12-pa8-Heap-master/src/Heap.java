import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Comparator;

class Heap<K, V> implements PriorityQueue<K, V> {
    public List<Entry<K, V>> entries;
    public Comparator<K> comparator;

    public Heap(Comparator comparator){
        this.entries = new ArrayList<Entry<K, V>>();
        this.comparator = comparator;
    }

    // methods
    public void add(K k, V v){
        this.entries.add(new Entry<K,V>(k, v));
        bubbleUp(this.size() - 1);
    }

    public Entry<K, V> poll(){
        if(this.size() == 0){throw new NoSuchElementException();}
        // only one presents
        if(this.size() == 1){ return this.peek();}

        Entry<K, V> remove = this.peek();
        // change with the last from the list, then remove
        swap(0, this.size() - 1);
        this.entries.remove(this.size() - 1);
        bubbleDown(0);

        return remove;
    }

    public Entry<K, V> peek(){
        if(this.size() == 0){throw new NoSuchElementException();}

        return this.entries.get(0);
    }

    public List<Entry<K, V>> toArray(){
        return this.entries;
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    // additional method
    public int parent(int index){ // this is type int, not double
        return (index - 1) / 2;
    }

    public int left(int index){
        return index * 2 + 1;
    }

    public int right(int index){
        return (index + 1) * 2;
    }

    public void swap(int i1, int i2){
        Entry<k, V> e1 = this.entries.get(i1);
        Entry<k, V> e2 = this.entries.get(i2);

        this.entries.set(i2, e1);
        this.entries.set(i1, e2);
    }

    public void bubbleUp(int index){ //maxHeap
        // check if it is at top first
        if(index <= 0){return;}
        // compare and swap with the parent
        Entry<K, V> child = this.entries.get(index);
        Entry<K, V> parent = this.entries.get(parent(index));
        // cannot compare entry directly, key goes first
        if(this.comparator.compare(child.key, parent.key) > 0 ){
            // this means bigger child
            swap(index, parent(index));
            bubbleUp(parent(index));
        }
        else{
            //stop until parent is bigger
            return;
        }
        
    }

    public void bubbleDown(int index){ //minHeap might be wrong, test on this
        // check if it is at bottom first
        if(index >= this.entries.size()){return;}
        // compare and swap with the child
        Entry<K, V> current = this.entries.get(index);
        
        if(existsAndGreater(this.left(index), index)){
            // left child bigger
            swap(this.left(index), index);
            bubbleDown(left(index));
        }
        if(existsAndGreater(this.right(index), index)){
            // right child bigger
            swap(this.right(index), index);
            bubbleDown(right(index));
        }

        }

    public boolean existsAndGreater(int index1, int index2){
        try{
            Entry<K, V> e1 = this.entries.get(index1);
            Entry<K, V> e2 = this.entries.get(index2);
            K k1 = this.entries.get(index1).key;
            K k2 = this.entries.get(index2).key;
            if(comparator.compare(k1, k2) >= 0){
                return true;
            }
            else{
                return false;
            }
        }
        catch(NoSuchElementException e){
            return false;
        }
        catch(IndexOutOfBoundsException e){
            return false;
        }
    }

    public int size(){
        return entries.size();
    }

    public String toString(){
        return entries.toString();
    }
}