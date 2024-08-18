package Arrays;// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class HelloWorld {
    public static void main(String[] args) {
        String a="Hello";
        String b="World";

        System.out.println("Before swapping a :" +a + " b:" +b);

        a=a+b;
        b=a.substring(0,a.length()-b.length());
        a=a.substring(b.length());

        System.out.println("After swapping a :" +a + " b:" +b);
    }
}