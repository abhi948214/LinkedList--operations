public class DoubleLinkedListMain {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.createLinkedlist(7);
        list.createLinkedlist(6);
        list.insert(0,0);
        list.insert(1,1);
        list.insert(2,2);
        list.insert(3,3);
        list.insert(4,4);
        list.insert(5,5);
        list.insert(5,6);

        System.out.println("\nSearching the node having value 40: ");
        list.searchNode(40);

        System.out.println("\n\nSearching the node having value 400: ");
        list.searchNode(400);


        System.out.println("\n\nLinked List in order");
        list.traverseLinkedList();
        System.out.println("Linked List in reverse order");
        list.traverseLinkedListInReverseOrder();


        System.out.println("\n\nDeleting the node having location = 2: ");
        System.out.println("List before deletion: ");
        list.traverseLinkedList();
        list.delete(2);
        System.out.println("List after deletion: ");
        list.traverseLinkedList();


        System.out.println("\n\nDeleting the node having location = 3: ");
        System.out.println("List before deletion: ");
        list.traverseLinkedList();
        list.delete(3);
        System.out.println("List after deletion: ");
        list.traverseLinkedList();


        list.deleteLinkedList();
        list.traverseLinkedList();


    }

}
