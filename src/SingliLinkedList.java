public class SingliLinkedList {


    public SingliLinkedList getNext() {
        return next;
    }

    public void setNext(SingliLinkedList next) {
        this.next = next;
    }

    public SingliLinkedList getHead() {
        return head;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setHead(SingliLinkedList head) {
        this.head = head;
    }

    public SingliLinkedList getTail() {
        return tail;
    }

    public void setTail(SingliLinkedList tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private int value;
    private SingliLinkedList next;
    private SingliLinkedList head;
    private SingliLinkedList tail;
    private int size;// denotes size of list

    SingliLinkedList createSingleLinkedList(int Node_data) {
        head = new SingliLinkedList();
        tail = new SingliLinkedList();
        SingliLinkedList node = new SingliLinkedList();
        node.setValue(Node_data);
        node.setNext(null);
        head = node;
        tail = node;
        size = 1;
       // System.out.println(node.value + "  head " + head.value + "tail " + tail.value);

        return head;
    }
    public boolean existsLinkedList() {
        // if head is not null retrun true otherwise return false
        return head != null;
    }


    public void insertInLinkedList(int nodeValue, int location) {
        SingliLinkedList node = new SingliLinkedList();
        node.setValue(nodeValue);
            if (!existsLinkedList()) { // Linked List does not exists
                System.out.println("The linked list does not exist!!");
                return;
            } else if (location == 0) {// insert at first position
                node.setNext(head);
                head = node;
            } else if (location >= size) {// insert at last position
                node.setNext(null);
                tail.setNext(node);
                tail = node;
            } else {// insert at specified location
                SingliLinkedList tempNode = head;
                int index = 0;
                while (index < location - 1) {// loop till we reach specified node
                    tempNode = tempNode.getNext();
                    index++;
                }//tempNode currently references to node after which we should insert new node
                SingliLinkedList nextNode = tempNode.getNext(); //this is the immediate next node after new node
                tempNode.setNext(node);//update reference of tempNode to reference to new node
                node.setNext(nextNode);//update newly added nodes' next.
            }
            setSize(getSize()+1);
        }


        void traverseLinkedList() {
        if (existsLinkedList()) {
            SingliLinkedList tempNode = head;
            for (int i = 0; i < getSize(); i++) {
                System.out.print(tempNode.getValue());
                if (i != getSize() - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.getNext();
            }
        } else {
            System.out.println("Linked List does not exists !");
        }
        System.out.println("\n");
    }



    //Deletes entire Linked List
    void deleteLinkedList() {
        System.out.println("\n\nDeleting Linked List...");
        head = null;
        tail = null;
        System.out.println("Linked List deleted successfully !");
    }


    //Searches a node with given value
    boolean searchNode(int nodeValue) {
        if (existsLinkedList()) {
            SingliLinkedList tempNode = head;
            for (int i = 0; i < getSize(); i++) {
                if (tempNode.getValue() == nodeValue) {
                    System.out.print("Found the node at location: " + i + "\n");
                    return true;
                }
                tempNode = tempNode.getNext();
            }
        }
        System.out.print("Node not found!! \n");
        return false;
    }

    boolean search(int values) {
        if (existsLinkedList()) {
            SingliLinkedList temp = head;
            for (int i = 0; i < getSize(); i++) {
                if (temp.getValue() == values) {
                    System.out.println("value is found at location " + i);
                    return true;
                }
                temp = temp.getNext();
            }

        }
            System.out.println("search not found");
            return false;
    }
    //Deletes a node having a given value
    public void deletionOfNode(int location) {
        if (!existsLinkedList()) {
            System.out.println("The linked list does not exist!!");// Linked List does not exists
            
        }else if (location == 0 ){
            head = head.getNext();
            setSize(getSize()-1);
            if (getSize() == 0){
                tail =null;

            }
        }else if (location >= getSize()){
                SingliLinkedList temp = head;
                for (int i=0; i<size-1;i++){
                    temp =temp.getNext();
                }
                if (temp == head) { //if this is the only element in the list
                    tail = head = null;
                    setSize(getSize()-1);
                    return;
                }
                temp.setNext(null);
                tail= temp;
                setSize(getSize()-1);
        }
            else{
                SingliLinkedList nodetemp =head;
                for (int i =0 ; i< location-1;i++){
                    nodetemp =nodetemp.getNext();//here we got second last element
                }

                nodetemp.setNext(nodetemp.getNext().getNext());
                setSize(getSize() - 1);
            }

        }






}





