import java.util.Scanner;
import java.util.Arrays;

public class Tester{
public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  System.out.println("Enter you binary numbers:");
  String str = scan.nextLine();
  byte[] list = Onion.stringToByte(str);
  try{
    Onion onion = new Onion(list);
    System.out.println(onion.toString());
  }
  catch (Exception e) {
    e.printStackTrace();
    }
    scan.close();
}
}
