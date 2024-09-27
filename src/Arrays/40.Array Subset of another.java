https://www.geeksforgeeks.org/find-whether-an-array-is-subset-of-another-array-set-1/

//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());

            long n = Long.parseLong(stt.nextToken());
            long m = Long.parseLong(stt.nextToken());
            long a1[] = new long[(int)(n)];
            long a2[] = new long[(int)(m)];


            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a1[i] = Long.parseLong(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                a2[i] = Long.parseLong(inputLine1[i]);
            }


            Compute obj = new Compute();
            System.out.println(obj.isSubset( a1, a2, n, m));

        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Compute {
    public String isSubset(long a1[], long a2[], long n, long m) {
        // Create a HashMap to store the frequency of each element in a1[]
        HashMap<Long, Integer> freqMap = new HashMap<>();

        // Populate the frequency map for a1[]
        for (long value : a1) {
            freqMap.put(value, freqMap.getOrDefault(value, 0) + 1);
        }

        // Check if all elements of a2[] have enough occurrences in a1[]
        for (long value : a2) {
            if (!freqMap.containsKey(value) || freqMap.get(value) == 0) {
                return "No";  // If the element is not found or has no more occurrences left
            }
            // Decrease the count for the element in the map
            freqMap.put(value, freqMap.get(value) - 1);
        }

        // If all elements are found with enough occurrences, return "Yes"
        return "Yes";

    }
}