// Recursive Java program to compute atoi()
class GFG{

    // Recursive function to compute atoi()
    static int myAtoiRecursive(String str, int n)
    {
        // If str is NULL or str contains non-numeric
        // characters then return 0 as the number is not
        // valid
        if (str == "" || !str.matches("^\\d*$")) {
            return 0;
        }
        // Base case (Only one digit)
        if (n == 1)
        {
            return str.charAt(0) - '0';
        }

        // If more than 1 digits, recur for (n-1),
        // multiply result with 10 and add last digit
        return (10 * myAtoiRecursive(str, n - 1) +
                str.charAt(n - 1) - '0');
    }

    // Driver code
    public static void main(String[] s)
    {
        String str = "112";
        int n = str.length();

        System.out.println(myAtoiRecursive(str, n));
    }
}
