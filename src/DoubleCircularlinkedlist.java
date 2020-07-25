public class DoubleCircularlinkedlist {

  public  DoubleCircularlinkedlist head;
  public DoubleCircularlinkedlist tail;
  public DoubleCircularlinkedlist next;
  public  DoubleCircularlinkedlist previoud;
  public  int value;
  public  int size;

  public  DoubleCircularlinkedlist getHead(){
      return head;

  }
  public  void  setHead(DoubleCircularlinkedlist head){
      this.head =head;
  }
  public  DoubleCircularlinkedlist getTail(){
      return tail;
  }
  public  void  setTail(DoubleCircularlinkedlist tail){
      this.tail =tail;
  }
  public  int getValue(){
      return  value;
  }

    public DoubleCircularlinkedlist getNext() {
        return next;
    }

    public void setNext(DoubleCircularlinkedlist next) {
        this.next = next;
    }

    public DoubleCircularlinkedlist getPrevioud() {
        return previoud;
    }

    public void setPrevioud(DoubleCircularlinkedlist previoud) {
        this.previoud = previoud;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public  void  setValue(int value){
      this.value=value;
  }

  public  DoubleCircularlinkedlist createlinkedlist(int value){
      head = new DoubleCircularlinkedlist();
      DoubleCircularlinkedlist node =new DoubleCircularlinkedlist();
      node.setValue(value);
      head = node;
      tail = node;
      node.setNext(node);
      node.setPrevioud(node);

      setSize(getSize()+1);
      return head;
  }
  boolean isexist(){
      // if head is not null retrun true otherwise return false
      return head != null;
  }

  void insertInLinkedList(int value, int loaction){
      DoubleCircularlinkedlist node= new DoubleCircularlinkedlist();
      node.setValue(value);
      if (! isexist()){
          System.out.println(" linked list is not exist");
          return;
      } else if (loaction == 0) {
          node.setNext(head);
          node.setPrevioud(tail);
          head.setPrevioud(node);
          tail.setNext(node);
          head = node;
      } else if (loaction >= size){
              tail.setNext(node);
              head.setPrevioud(node);
              node.setPrevioud(tail);
              node.setNext(head);
              tail = node;
      }
      else {
              DoubleCircularlinkedlist temp = head;
              int index = 0;
              while ( index < loaction-1){
                  temp = temp.getNext();
                  index++;
              }
              node.setNext(temp.getNext());
              node.setPrevioud(temp);
              temp.setNext(node);
              node.getNext().setPrevioud(node);
          }
          size++;
  }

  void traverseLinkedList() {
          if(isexist()) {
              //System.out.println("Linked List now: ");
             DoubleCircularlinkedlist tempNode=head;
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

  void deletionOfNode(int location){
      DoubleCircularlinkedlist node = new DoubleCircularlinkedlist();
      if (!isexist()){
          System.out.println("linked  list is not execute");
      }else if (location == 0){
          head = head.getNext();
          head.setPrevioud(tail);
          tail.setNext(head);
          setSize(getSize()-1);
      }else if (location >= size){
          DoubleCircularlinkedlist temp;
          temp = tail.getPrevioud();
          temp.setNext(head);
          tail=temp;
          head.setPrevioud(tail);
          setSize(getSize()-1);
      }else {
          DoubleCircularlinkedlist temp = head;
          int index =0;
          while (index < location-1){
              temp = temp.getNext();
              index++;
          }

          temp.setNext(temp.getNext().getNext());
          temp.getNext().setPrevioud(temp);
          setSize(getSize() - 1);

      }
  }

    // Traverse Linked List reverse order
    void traverseLinkedListInReverseOrder() {
        if (isexist()) {
            DoubleCircularlinkedlist tempNode = tail;
            System.out.println("\nPrinting Linked list in reverse order...");
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.getValue());
                if (i != size-1) {
                    System.out.print(" <- ");
                }
                tempNode = tempNode.getPrevioud();
            }
        } else {
            System.out.println("Linked List does not exists !");
        }
    }


    // Traverse Linked List
    void printHeadUsingTail() {
        if (isexist()) {
            System.out.println("\n\nPrinting Tail...");
            System.out.println(tail.getValue());

            System.out.println("\nPrinting Head using Head reference...");
            System.out.println(head.getValue());

            System.out.println("\nPrinting Head using Tail reference...");
            System.out.println(tail.getNext().getValue());

        } else {
            System.out.println("Linked List does not exists");
        }
    }


    //Deletion of linked list
    void deleteLinkedList() {
        System.out.println("\n\nDeleting Linked List...");
        if (tail == null) {
            System.out.println("Linked List is already deleted, nothing to delete anymore !");

        }else {
            head.setPrevioud(null);
            tail.setNext(null);
            head = null;
            tail = null;
            System.out.println("Linked List deleted successfully !");
        }
    }//end of method


    // Searching a specified value in linked list
    boolean searchNode(int nodeValue) {
        if (isexist()) {
            DoubleCircularlinkedlist tempNode = head;
            traverseLinkedList();
            for (int i = 0; i < size; i++) {
                if (tempNode.getValue() == nodeValue) {
                    System.out.print("Found the node at location: " + i);
                    return true;
                }
                tempNode = tempNode.getNext();
            }
        }
        System.out.print("Node not found!! ");
        return false;
    }







}
