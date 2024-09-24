https://www.geeksforgeeks.org/problems/time-to-words3728/0

//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2];
            input = br.readLine().split(" ");
            int H = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.timeToWord(H,M));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public String timeToWord(int H, int M)
    {
        // code here
        String tick;
        String nums[]={"zero","one","two","three","four","five","six",
                "seven","eight","nine","ten","eleven","twelve",
                "thirteen","fourteen","fifteen","sixteen",
                "seventeen","eighteen","nineteen","twenty",
                "twenty one","twenty two","twenty three",
                "twenty four","twenty five","twenty six",
                "twenty seven","twenty eight","twenty nine"
        };

        String oclock=" o' clock";
        String to =" to ";
        String past=" past ";
        String qrtr="quarter";
        String half="half";
        String mints=" minutes";
        String mint=" minute";

        if(M==0){
            tick=nums[H]+oclock;
        }
        else if(M==15){
            tick=qrtr+past+nums[H];
        }
        else if(M==30){
            tick=half+past+nums[H];
        }
        else if(M==45){
            tick=qrtr+to+nums[H+1];
        }
        else{
            if(M==1){
                tick=nums[1]+mint+past+nums[H];
            }
            else if(M==59){
                tick=nums[1]+mint+to+nums[(H+1)%12];
            }
            else if(M<30){
                tick=nums[M]+mints+past+nums[H];
            }
            else{
                tick=nums[60-M]+mints+to+nums[(H%12)+1];
            }

        }
        return tick;
    }
}