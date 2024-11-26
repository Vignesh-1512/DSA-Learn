import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();

        int maxLength=0;
        int startIndex=-1;

        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);

        int balance=0;

        for(int i=0;i<str.length();i++)
        {
            if (str.charAt(i) == '1') {
                balance++;  // Increment for '1'
            } else {
                balance--;  // Decrement for '0'
            }

            if(map.containsKey(balance))
            {
                int prevInd=map.get(balance);
                int len=i-prevInd;

                if(len>maxLength)
                {
                    maxLength=len;
                    startIndex=prevInd+1;
                }
            }
            else{
                map.put(balance,i);
            }
        }

        if(maxLength>0)
        {
            System.out.println(startIndex +"to" + (startIndex+maxLength-1));
        }
        else{
            System.out.println("No_subString_found");
        }
    }
}