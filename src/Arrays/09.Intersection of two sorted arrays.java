https://www.naukri.com/code360/problems/intersection-of-2-arrays_1082149?leftPanelTabValue=SUBMISSION

import java.util.* ;
import java.io.*;
public class Solution
{
    public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m)
    {
        // Write Your Code Here.
        int i=0;
        int j=0;
        ArrayList<Integer> list=new ArrayList<>();
        while(i<n && j<m){
            if(arr1.get(i)<arr2.get(j)){
                i++;
            }
            else if(arr2.get(j)<arr1.get(i)){
                j++;
            }
            else{
                list.add(arr1.get(i));
                i++;
                j++;
            }
        }
        return list;
    }
}
