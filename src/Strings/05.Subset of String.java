https://www.javatpoint.com/java-program-to-find-all-subsets-of-a-string

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String str = "AZAR";
        int len = str.length();
        String[] ans = new String[len*(len+1)/2];
        int idx=0;
        for(int i=0; i<len; i++)
        {
            for(int j=i; j<len; j++)
            {
                ans[idx]= str.substring(i,j+1);
                idx++;
            }
        }
        for(int i=0; i<ans.length; i++)
            System.out.print(ans[i]+" ");
    }
}