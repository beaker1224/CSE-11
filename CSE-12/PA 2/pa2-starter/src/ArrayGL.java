import java.util.ArrayList;

public class ArrayGL<E> implements MyList<E> {

    E[] elements;
    int size;

    public ArrayGL(E[] initialElements) {
        this.elements = initialElements;
        this.size = initialElements.length;
    }

    // Fill in all required methods here
    public E[] toArray(){
        E[] out = (E[]) new Object[this.size];
        for(int i = 0; i < this.size; i++){
          out[i] = this.elements[i];  
        }
        return out;
    }

    public void transformAll(MyTransformer mt){
        if(this.size == 0){return;}
        for(int i = 0; i < this.size; i++){
            if(this.elements[i] == null){continue;}
            this.elements[i] = (E) mt.transformElement(this.elements[i]);
        }
    }

    public void chooseAll(MyChooser mc){
        if(this.size == 0){return;}
        ArrayList<E> choosen = new ArrayList<>();
        for(int i = 0; i < this.size; i++){
            if(this.elements[i] != null && mc.chooseElement(this.elements[i])){
                choosen.add(this.elements[i]);
            }
        }
        this.elements = (E[]) new Object[choosen.size()];
        this.size = choosen.size();
        for(int i = 0; i < choosen.size(); i++){
            this.elements[i] = choosen.get(i);
        }
    }

    public boolean isEmpty(){
        if(this.size == 0){
            return true;
        }
        return false;
    }
}