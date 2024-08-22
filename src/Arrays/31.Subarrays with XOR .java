https://www.naukri.com/code360/problems/count-subarrays-with-given-xor_1115652?leftPanelTabValue=SUBMISSION

import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {
    public static int subarraysXor(ArrayList<Integer> arr, int x) {
        // Write your code here.
        int n=arr.size();
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                int xorr=0;
                for(int k=i;k<=j;k++)
                {
                    xorr=xorr^arr.get(k);
                }
                if(xorr==x) cnt++;
            }
        }
        return cnt;
    }
}

//Method-2:
import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {
    public static int subarraysXor(ArrayList<Integer> arr, int x) {
        // Write your code here.
        int n=arr.size();
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            int xorr=0;
            for(int j=i;j<n;j++)
            {


                xorr=xorr^arr.get(j);

                if(xorr==x) cnt++;
            }
        }
        return cnt;
    }
}

//method-3:

import java.io.*;
        import java.util.* ;

public class Solution {
    public static int subarraysXor(ArrayList<Integer> arr, int x) {
        // Write your code here.
        int n=arr.size();
        int xr=0;
        Map<Integer,Integer> mpp=new HashMap<>();
        int cnt=0;
        mpp.put(xr, 1);

        for(int i=0;i<n;i++)
        {
            // prefix XOR till index i:
            xr=xr^arr.get(i);

            //By formula: x = xr^k:
            int k=xr^x;

            // add the occurrence of xr^k
            // to the count:
            if(mpp.containsKey(k)){
                cnt+=mpp.get(k);
            }

            // Insert the prefix xor till index i
            // into the map:
            if(mpp.containsKey(xr)){
                mpp.put(xr,mpp.get(xr)+1);
            }
            else{
                mpp.put(xr,1);
            }


        }
        return cnt;
    }
}