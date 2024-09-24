https://leetcode.com/problems/fibonacci-number/

//With recursion
class Solution {
    public int fib(int n) {
        if(n<=1) return n;

        int last = fib(n-1);
        int seclast = fib(n-2);

        return (last+seclast);
    }
}

//Without Recusrion

class Solution {
    public int fib(int n) {
        int num1 = 0, num2 = 1;
        int num3 = 0;
        for (int i = 0; i < n; i++) {
            num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
        }
        return num1;
    }
}