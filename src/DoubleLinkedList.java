public class DoubleLinkedList {
    private DoubleLinkedList head;
    private DoubleLinkedList tail;
    private DoubleLinkedList next;
    private DoubleLinkedList previous;
    private int value;
    private int size;

    public DoubleLinkedList getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleLinkedList previous) {
        this.previous = previous;
    }

    public DoubleLinkedList getHead() {
        return head;
    }

    public void setHead(DoubleLinkedList head) {
        this.head = head;
    }

    public DoubleLinkedList getTail() {
        return tail;
    }

    public void setTail(DoubleLinkedList tail) {
        this.tail = tail;
    }

    public DoubleLinkedList getNext() {
        return next;
    }

    public void setNext(DoubleLinkedList next) {
        this.next = next;
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

    public DoubleLinkedList createLinkedlist(int value) {
        head = new DoubleLinkedList();
        tail = new DoubleLinkedList();
        DoubleLinkedList node = new DoubleLinkedList();
        node.setValue(value);
        head = node;
        tail = node;
        head.setPrevious(null);
        head.setNext(null);
       // System.out.println(head.getValue());
        return head;

    }


    void insert(int nodeValue, int location) {
        DoubleLinkedList node = new DoubleLinkedList();
        node.setValue(nodeValue);
        if (!existsLinkedList()) {
            System.out.println("The linked list does not exist!!");
            return; // Linked List does not exists
        } else if (location == 0) {// insert at first position
            node.setNext(head);
            node.setPrevious(null);
            head.setPrevious(node);
            head = node;
        } else if (location >= size) {// insert at last position
            node.setNext(null);
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node; // to keep track of last node
        } else {// insert at specified location
            DoubleLinkedList tempNode = head;
            int index = 0;
            while (index < location - 1) {// loop till we reach specified node
                tempNode = tempNode.getNext();
                index++;
            }
            node.setPrevious(tempNode);
            node.setNext(tempNode.getNext());
            tempNode.setNext(node);
            node.getNext().setPrevious(node);
        }
        size++;
    }

    void delete(int location){
        if(!existsLinkedList()){
            System.out.println("linked list is not exist");
        }else if (location == 0){
            head = head.getNext();
            head.setPrevious(null);
            setSize(getSize()-1);

        }else if (location >= size){
            tail =tail.getPrevious();
            tail.setNext(null);
            setSize(getSize()-1);
        }else {
            DoubleLinkedList temp =head;
            int index =0;
            while (index< location-1){
                temp = temp.getNext();
                index++;
            }
         temp.setNext(temp.getNext().getNext());
            temp.getNext().setPrevious(temp);
            setSize(getSize()-1);
        }
    }


    public boolean existsLinkedList() {
        //if head is not null retrun true otherwise return false
        return head!=null;
    }



    //Traverse the linked list from head to last
    void traverseLinkedList() {
        if(existsLinkedList()) {
            //System.out.println("Linked List now: ");
            DoubleLinkedList tempNode=head;
            for(int i =0; i<size;i++) {

                System.out.print(tempNode.getValue());
                if(i!=size-1) {
                    System.out.print(" -> ");
                }
                tempNode=tempNode.getNext();
            }
        }else {
            System.out.println("Linked List does not exists");
        }
        System.out.println("\n");
    }


    // Traverse the linked list from head to last
    void traverseLinkedListInReverseOrder() {
        if (existsLinkedList()) {
            DoubleLinkedList tempNode = tail;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.getValue());
                if (i != size-1) {
                    System.out.print(" <- ");
                }
                tempNode = tempNode.getPrevious();
            }
        } else {
            System.out.println("Linked List does not exists");
        }
        System.out.println("\n");
    }

    //delete whole linked list
    void deleteLinkedList() {
        System.out.println("\n\nDeleting Linked List...");
        DoubleLinkedList tempNode = head;
        for (int i = 0; i < size; i++) {
            tempNode.setPrevious(null);
            tempNode = tempNode.getNext();
        }

        head = null;
        tail = null;
        System.out.println("Linked List deleted successfully !");
    }


    //Search for a node in linked list
    boolean searchNode(int nodeValue) {
        if(existsLinkedList()) {
            DoubleLinkedList tempNode=head;
            for(int i =0; i<size;i++) {
                if(tempNode.getValue()==nodeValue) {
                    System.out.print("Found the node at locaiton: " + i);
                    return true;
                }
                tempNode=tempNode.getNext();
            }
        }
        System.out.print("Node not found!! ");
        return false;
    }




}
