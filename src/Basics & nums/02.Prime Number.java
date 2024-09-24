https://www.geeksforgeeks.org/problems/prime-number2314/1

class Solution{
    static int isPrime(int N){
        // code here
        if(N<=1)    return 0;

        for(int i=2; i<N; i++)
        {
            if(N%i==0)  return 0;
        }

        return 1;
    }
}

class Solution{
    static int isPrime(int N){
        // code here
        if(N<=1)    return 0;

        for(int i=2; i<=Math.sqrt(N); i++)
        {
            if(N%i==0)  return 0;
        }

        return 1;
    }
}