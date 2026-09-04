public class SinglyLinkedList<E> {  
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    // Write your codes below
    public String toString(){
        if (isEmpty()) return "";

        StringBuilder text = new StringBuilder();
        Node<E> walk = head;

        for(int i = 0; i < size; i++) {
            text.append(walk.getElement().toString());
            walk = walk.getNext();
        }

        return text.toString();
    }

    public E removeLast(){
        if (isEmpty()) return null;

        Node<E> walk = head;
        E answer = tail.getElement();
        
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            while(walk.getNext() != tail) {
                walk = walk.getNext();
            }
            walk.setNext(null);
            tail = walk;
        }

        size--;
        return answer;
    }

public void reverse(){
        if (isEmpty()) return ;

        Node<E> oldHead = head;
        Node<E> oldTail = tail;
        
        //head is the old tail, but it's next element is still null
        head = oldTail;
        tail = oldHead;
        Node<E> walk = head;

        while(tail.getNext() != null) {
            //previous starts from the old head
            Node<E> prev = tail;
            for (int i = 0; i < size; i++ ){
                //get the node before the old tail.
                if (!prev.getNext().equals(walk)) {
                    prev = prev.getNext();
                } else {
                    break;
                }
            }
            //walk points to the next element for the new head, 
            //which was the previous element for old tail
            walk.setNext(prev);
            walk = prev;

            if (walk.equals(oldHead)) {
                tail.setNext(null);
            }
        }
    }
}