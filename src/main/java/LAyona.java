import java.util.Scanner;

public class LAyona {
    public static void main(String[] args) {

        String question = "What is the biggest planet in solar system?";
        String choiceOne = "Earth";
        String choiceTwo = "jupiter";
        String choiceThree = "Saturn";
        String correctAnswer = choiceTwo;
        //What a pirnt statement asking a question
        System.out.println(question);
        // Write a statement giving the answer choices
        //Have user input an answer
        Scanner sc = new Scanner(System.in);
        //REtrive the user input
        String input = sc.next().toLowerCase();
        if (correctAnswer.contains(input)) {
            System.out.println("Congratulations");
        } else {
            System.out.println("Incorrect");
        }
        // fizzbuzz
        //if any given mum equally split to 3 -- Fizz if, equally split to 5 -- buzz. if equally split  for 3 and 5 it is fizzbuzz
//        Scanner scanner= new Scanner (System.in);
//        System.out.println("Please enter number: ");
//        int num= scanner.nextInt();
//    //    String stringInput=scanner.next();
//        if (num%3==0){//true
//            if (num%5==0){//false
//                System.out.println("FizzBuzz");
//            }else {
//                System.out.println("Fizz");
//            }
//        }else if (num%5==0){
//            System.out.println("Buzz");
//        }
//
//        String fizzBuzz= (num%3==0) ? (num%5==0) ? "FizzBuss" : "Fizz" : (num%5==0) ?  "Buzz" : num+ " is not multiplier";
//        System.out.println(fizzBuzz);


//Anastasia
//
//        String toConvert="102";
//        int n =Integer.parseInt(toConvert);
//        Integer.parseInt(toConvert);
//
//        System.out.println(toConvert+4);
//        System.out.println(Integer.parseInt(toConvert)+4);
//
//        int y=8;
//        System.out.println(Integer.toString(y)+" String value");
//
//        String example = "age: 47";
//        System.out.println(example);
//
        System.out.println("Reverse String Method 1 using CharAt Method:");
        String initial="Hello guys!";
        String reversed="";
        for (int i=initial.length()-1; i >=0 ; i--) {
            reversed=reversed+initial.charAt(i);

        }
        System.out.println("Reversed string: " +reversed);





        System.out.println("Reverse String Method 2 using String Builder:");

        String string="Hello Techtorial!";

        System.out.println( new StringBuilder(string).reverse());





        System.out.println("Reverse String Method 3 using Reverse Iteration:");
        String s="Hi All";
        char Array[]=s.toCharArray();
        String reverse="";
        for (int i = Array.length-1; i >=0 ; i--) {
            reverse+=Array[i];
        }
        System.out.println(reverse);



        System.out.println("Reverse String Method 4 :");
        String string2="Welcome to Java";
        String[] strArray=string2.split(" ");
        for (String temp:strArray) {
            System.out.println(temp);

        }
        for (int i = 0; i < 3; i++) {
            char[]s1=strArray[i].toCharArray();

            for (int j = s1.length-1; j >=0 ; j--)
            {
                System.out.print(s1[j]);
            }        System.out.println("");

        }

        System.out.println("Reverse String Method 5 using Recursion:");
        String sentence = "Go work";
        String reversed2 = reverse(sentence);
        System.out.println("The reversed sentence is: " + reversed2);
    }


    public static String reverse(String sentence) {
        if (sentence.isEmpty())
            return sentence;

        return reverse(sentence.substring(1)) + sentence.charAt(0);
    }
}

