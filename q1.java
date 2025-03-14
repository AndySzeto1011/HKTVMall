public class q1 {

    public static void main(String[] args) {
         // check Input
         if (args.length == 0) {
            System.out.println("Input");
            return;
        }

        String input = args[0];
        int length = input.length();
        char[] reversedChars = new char[length]; // store input length

        // reverse function
        for (int i = 0; i < length; i++) {
            reversedChars[i] = input.charAt(length - 1 - i);  
        }

        // show the reverse result
        System.out.println("output: " + new String(reversedChars));
    }

    //can be use the toCharArray and scanner ,other method with using class StringBuilder which is a class on JDK  , but avoid to use more built-in method here that only use chatAt
    //java q1 Andy
    //output : ydnA 
}


