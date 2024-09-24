import java.util.*;

public class GFG {
    public static void main(String[] args) {
        char ch = '}';
        // Typecasting the character to int and printing the same
        System.out.println("The ASCII value of " + ch + " is: " + (int) ch);
    }
}

________________________________
        Math.random()
        The class Math contains various methods for performing various numeric operations such as,
        calculating exponentiation, logarithms etc. One of these methods is random(),
        this method returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0.
        The returned values are chosen pseudo randomly.
        This method can only generate random numbers of type Doubles


        import java.util.*;

public class generateRandom
{
    public static void main(String args[])
    {
        System.out.println("Random doubles: " + Math.random());
        System.out.println("Random doubles: " + Math.random());
    }
}

    Using Math.random() Method
        Here is the formula to generate a random number with specific range,
        where min and max are our lower and higher limit of number:

        import java.io.*;
        import java.util.*;

class GFG {
    public static void main (String[] args) {
        int max=10,min=5;
        System.out.println(min + (int)(Math.random() * ((max - min) + 1)));
        System.out.println(min + (int)(Math.random() * ((max - min) + 1)));
        System.out.println(min + (int)(Math.random() * ((max - min) + 1)));
    }
}