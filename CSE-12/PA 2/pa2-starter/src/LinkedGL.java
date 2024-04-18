import java.util.ArrayList;


public class LinkedGL<E> implements MyList<E> {

    class Node {
        E value;
        Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    Node front;
    int size;

    public LinkedGL(E[] contents) {
        this.front = new Node(null, null);
        Node current = this.front;
        for(int i = 0; i < contents.length; i++){
            current.next = new Node(contents[i], null);
            current = current.next; // this is the update on the current node
        }
        this.size = contents.length;
    }

    // Fill in all methods
    public E[] toArray(){
        E[] out = (E[]) new Object[this.size];
        Node current = this.front;
        int i = 0;
        while(current.next != null){
            current = current.next;
            out[i] = current.value;
            i++;
        }
        return out;
    }

    public void transformAll(MyTransformer mt){
        if(this.isEmpty()){return;}
        Node current = this.front;
        while(current.next != null){
            current = current.next;
            if(current.value == null){
                continue; 
            }
            current.value = (E) mt.transformElement(current.value);
        }
    }

    public void chooseAll(MyChooser mc){
        if(this.isEmpty()){return;}
        Node current = this.front;
        Node newCurrent = this.front;
        int i = 0;
        while(current.next != null){
            current = current.next;
            if(current.value == null){
                newCurrent.next = null;
                continue;
            }

            if(mc.chooseElement(current.value)){
                newCurrent.next = current;
                newCurrent = newCurrent.next;
                i++;
            }else{
                newCurrent.next = null;
            }
        }
        this.size = i;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }
}