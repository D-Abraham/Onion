import java.util.Scanner;
import java.util.Arrays;

public class Tester{
public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  System.out.println("Enter your binary numbers:");
  String str = scan.nextLine();
  byte[] list = Onion.stringToByte(str);
  try{
    Onion onion = new Onion(list);
    System.out.println("Before: "+ Arrays.toString(str.toCharArray()));//Just for 
    System.out.println("After:  "+onion.toString());//visualization purpose only.
  }
  catch (Exception e) {
    e.printStackTrace();
    }
    scan.close();

  //to test the equals method
  byte[] list2 = {0, 1, 0, 1, 0};
  try {
    Onion onion = new Onion(list);
    Onion onion2 = new Onion(list2);
    Onion onion3 = new Onion(list2);

    if(onion.equals(onion2))
      System.out.println("These two are equal.");

    else System.out.println("These are not equal.");

    if(onion2.equals(onion3))
      System.out.println("These two are equal.");

    else System.out.println("These are not equal.");

  }
  catch (Exception e) {
    e.printStackTrace();
  }


}




}
