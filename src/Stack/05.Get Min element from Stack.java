https://www.geeksforgeeks.org/problems/get-minimum-element-from-stack/1?page=1&category=Stack&sortBy=submissions

//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int q = sc.nextInt();
            GfG g = new GfG();
            while(q>0)
            {
                int qt = sc.nextInt();

                if(qt == 1)
                {
                    int att = sc.nextInt();
                    g.push(att);
                    //System.out.println(att);
                }
                else if(qt == 2)
                {
                    System.out.print(g.pop()+" ");
                }
                else if(qt == 3)
                {
                    System.out.print(g.getMin()+" ");
                }

                q--;
            }
            System.out.println();
            T--;
        }

    }
}



// } Driver Code Ends


class GfG
{
    int minEle;
    Stack<Integer> s;
    Stack<Integer> minStack;
    // Constructor
    GfG()
    {
        minEle = Integer.MAX_VALUE;
        s = new Stack<>();
        minStack = new Stack<>();
    }

    /*returns min element from stack*/
    int getMin()
    {
        // Your code here
        if (minStack.isEmpty()) {
            return -1; // or throw an exception, as the stack is empty
        } else {
            return minStack.peek();
        }
    }

    /*returns poped element from stack*/
    int pop()
    {
        // Your code here
        if(s.isEmpty()) return -1;
        else
        {
            int top= s.pop();
            if(top==minStack.peek())
            {
                minStack.pop();
            }
            return top;
        }
    }

    /*push element x into the stack*/
    void push(int x)
    {
        // Your code here
        s.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }
}

