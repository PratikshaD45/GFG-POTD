//{ Driver Code Starts
import java.util.*;

class StackNode {
    int data;
    StackNode next;
    StackNode(int a) {
        data = a;
        next = null;
    }
}

class GfG {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            MyStack obj = new MyStack();
            int Q = sc.nextInt();
            while (Q > 0) {
                int QueryType = 0;
                QueryType = sc.nextInt();
                if (QueryType == 1) {
                    int a = sc.nextInt();
                    obj.push(a);
                } else if (QueryType == 2) {
                    System.out.print(obj.pop() + " ");
                }
                Q--;
            }
            System.out.println("");
            t--;
        }
    }
}

// } Driver Code Ends


class MyStack {
    // Definition of StackNode
    class StackNode {
        int data;
        StackNode next;
        
        StackNode(int a) {
            data = a;
            next = null;
        }
    }

    StackNode top;

    // Constructor to initialize the stack
    MyStack() {
        top = null;
    }

    // Function to check if the stack is empty
    boolean isEmpty() {
        return top == null;
    }

    // Function to push an integer into the stack
    void push(int a) {
        StackNode newNode = new StackNode(a);
        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    // Function to remove an item from the top of the stack
    int pop() {
        if (isEmpty()) {
            return -1;
        }
        int upper = top.data;
        top = top.next;  // Move the top pointer to the next node
        return upper;
    }
}
