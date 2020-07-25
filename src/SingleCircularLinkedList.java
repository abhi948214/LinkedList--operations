public class SingleCircularLinkedList {

    private SingleCircularLinkedList head;
    private SingleCircularLinkedList next;
    private SingleCircularLinkedList tail;
    private int value;
    private int size;

    public SingleCircularLinkedList getHead() {
        return head;
    }

    public void setHead(SingleCircularLinkedList head) {
        this.head = head;
    }

    public SingleCircularLinkedList getNext() {
        return next;
    }

    public void setNext(SingleCircularLinkedList next) {
        this.next = next;
    }

    public SingleCircularLinkedList getTail() {
        return tail;
    }

    public void setTail(SingleCircularLinkedList tail) {
        this.tail = tail;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    SingleCircularLinkedList CreateLinkedlist(int Node_data) {
        head = new SingleCircularLinkedList();
        tail = new SingleCircularLinkedList();
        SingleCircularLinkedList node = new SingleCircularLinkedList();
        node.setValue(Node_data);
        node.setNext(head);
        head = node;
        tail = node;
        size = 1;

        return head;
    }
    boolean isexistLinkedlist(){
        // if head is not null retrun true otherwise return false
        return head != null;
    }
    void insertInLinkedList(int location , int data ){
        SingleCircularLinkedList node = new SingleCircularLinkedList();
        node.setValue(data);
        System.out.println("Insert new node at location "  + location);
        if (!isexistLinkedlist()){
            System.out.println("there is no linked list\n");
            return;

        }else if (location == 0){

            node.setNext(head);
            head = node;
            tail.setNext(head);

        }
        else if (location >= size){
           tail.setNext(node);
           tail = node;
           tail.setNext(head);
        }
        else {
            SingleCircularLinkedList middle = head;
            int index =0;
            while (index < location -1 ){
                middle = middle.getNext();
                index++;
            }
            node.setNext(middle.getNext());
            middle.setNext(node);

        }
        size++;
    }

    void traverseLinkedList() {
        if (isexistLinkedlist()){
            SingleCircularLinkedList temp = head;
            for (int  i =0 ; i< size ; i++){
                System.out.print(temp.getValue());
                if (i != getSize() -1){
                    System.out.print("->");
                }
                temp = temp.getNext();
            }
            System.out.println("\n");

        }else {
            System.out.println("linked list is not exist");
        }
    }
    void printHeadUsingTail() {
        if (isexistLinkedlist()) {
            System.out.println("Printing Tail...");
            System.out.println(tail.getValue());

            System.out.println("Printing Head using Head reference...");
            System.out.println(head.getValue());

            System.out.println("Printing Head using Tail reference...");
            System.out.println(tail.getNext().getValue());

        }else{
            System.out.println("Linked List does not exists");
        }
    }

    void  deletionOfNode(int location){
        if (isexistLinkedlist()){
            SingleCircularLinkedList delete_node;
            if (location == 0){
                head = head.next;
                tail.setNext(head);
                setSize(getSize()-1);
            }if ( getSize() == 0){
                head  = tail =null;
            }
            else if (location >= getSize()){
                SingleCircularLinkedList temp = head;
                for (int i=0; i <size -1; i++){
                    temp = temp.getNext();

                }
                if (temp == head){
                    head = tail = null;
                }
                tail = temp;
                temp.setNext(head);
                setSize(getSize() -1);
            }
            else {
                SingleCircularLinkedList temp = head;
                int index= 0;
                while ( index < location -1){
                    temp =temp.getNext();
                    index ++;
                }

                temp.setNext(temp.getNext().getNext());
                setSize(getSize()-1);

            }

        } else {
            System.out.println("Linkedlist is not exist");
        }


    }
    boolean search ( int value) {
        if (isexistLinkedlist()) {

            SingleCircularLinkedList start = head;
            for (int i = 0; i < size ; i++) {
                if (start.getValue() == value) {
                    System.out.println("yes search is found at location" + i);
                    return true;
                }

                start = start.getNext();
            }
        }
        System.out.println("linked list is not exist or search not found");
        return false;
    }
}


