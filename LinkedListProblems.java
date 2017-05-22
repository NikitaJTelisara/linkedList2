public class LinkedListProblems {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.appendToTail(2);
        System.out.println("Input");
        printList(n);
        Node result = swapNodesInPair(n);
        System.out.println("Output");
        printList(result);

        Node n1 = new Node(1);
        n1.appendToTail(2);
        n1.appendToTail(3);
        n1.appendToTail(4);
        n1.appendToTail(5);
        n1.appendToTail(6);
        n1.appendToTail(7);
        n1.appendToTail(8);

        System.out.println("Reverse Nodes");
        Node res = reverseNodesforK(n1, 3);
        printList(res);

    }

    /* Swap nodes in pair ,Input 1->2->3->4 */
    /* Expected Output 2->1->4->3 */
    public static Node swapNodesInPair(Node n) {
        Node head = n;
        while (head != null && head.next != null) {
            int temp = head.next.data;
            head.next.data = head.data;
            head.data = temp;
            head = head.next.next;
        }
        return n;
    }

    public static void printList(Node n) {
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    /* reverse nodes till every kth node ,
      Input 1->2->3->4->5->6, if k =3 */
    /* Expected Output 3->2>1->6->5>4 */
    public static Node reverseNodesforK(Node start, int k) {
        Node resultStart = null;
        Node resultEnd = null;
        return createStack(start, k, resultStart, resultEnd);
    }

    public static Node createStack(Node start, int k, Node resultStart, Node resultEnd) {
        if (start == null) {
            return null;
        }
        Stack s = new Stack();
        for (int i = 0; i < k; i++) {
            s.push(start.data);
            start = start.next;
            if (start == null) {
                break;
            }
        }
        while (!s.isEmpty()) {
            if (resultStart == null) {
                resultStart = s.pop();
                resultEnd = resultStart;
            } else {
                resultEnd.next = s.pop();
                resultEnd = resultEnd.next;
            }
        }
        createStack(start, k, resultStart, resultEnd);
        return resultStart;
    }
    
    /* iterative
    public static LinkedListNode swapKNodes(LinkedListNode n, int k1) {
        LinkedListNode result = null;
        LinkedListNode n1 = null;
        int k = k1;
        if (n == null || n.next == null) {
            return n;
        }
        while (n != null) {
            Stack s = new Stack();
            while (n != null && k > 0) {
                s.push(n.data);

                k--;
                n = n.next;
            }
            while (!s.isEmpty()) {
                if (n1 == null) {
                    n1 = new LinkedListNode(s.pop().data);
                    result = n1;
                } else {
                    n1.next = new LinkedListNode(s.pop().data);
                    n1 = n1.next;
                }
            }
            k = k1;
        }
        return result;
    }*/
}
