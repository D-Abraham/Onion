/**
Per Blackboard: Recursive class that its constructor takes an odd number of binary digits as
its field.
The recursive method in this class is called by the constructor. It creates an
object of same class with smaller binary number by taking the two outer digits
and passing the binary number that is left.
Once no more object can be created  (the base case) the binary digit is flipped
(10101 >> 01010).

At the end, the flipped version of the original binary number is returned.

@author Lila & Daniel
@version 1.0
@since 10/5/2019
*/
import java.util.Arrays;
public class Onion{
  private byte[] binary;

/**
The constructor takes a byte array, which then check if it contain only binary
numbers and odd in length. If the array pass the check, it will call the recursive
mathod.
@@param binary this is the byte array
@@exception thows a messege exception
*/
  public Onion(byte[] binary) throws Exception{

    if((binary.length%2 == 0) || !(isBinary(binary))){
      throw new Exception("Input must be binary and odd in length.");
    }
    else{
      this.binary = onionRecursive(binary);
    }

  }

/**
Static method that takes a string of binary numbers and converte them to an
byte array.
@@param String of binary numbers.
@return byte array of binary numbers.
*/
  static byte[] stringToByte(String str){
    byte[] temp= new byte[str.length()];
    for(int pos=0; pos<str.length();pos++){
      temp[pos]= (byte)(str.charAt(pos)-'0');
    }
    return temp;
  }

  /**
  Returns the byte array (binary)
  */
  public byte[] getByteList(){
    return binary;
  }

  /**CHecks if the given byte array only contains binary numbers, returns true
  if only binary numbers, else returns false.
  @@param byte array to be Checked
  @@return true if arrey only contains binary numbers, else returns fales.
  */
private boolean isBinary(byte[] list) {
 boolean binary = true;
 int pos=0;
 while(binary==true && pos<list.length){
   if(list[pos]>1 || list[pos]<0){
     binary=false;
   }
   pos++;
 }
 return binary;
}

/**
takes on byte (binary) and returns the flipped virsion of it. Ex 0>>1 or 1>>0
@@param the binary number to be flipped
@@return retures the flipped version of the param.
**/
private byte flip(byte x){
  if(x == 1){
    return 0;
  }
    else {
      return 1;
    }
  }

  /**
  Recursive method that will take a byte array, and recursively flip each binary
  number.
  @@param byte array that contains binary numbers
  @@return A flipped version of the original array
  */
private  byte[] onionRecursive(byte[] list){
  byte[] tempList = new byte[list.length];
  if(list.length == 1){ //Base case
    tempList[0]=flip(list[0]);
  }
  else{
    try{
      Onion temp = new Onion(Arrays.copyOfRange(list, 1, list.length-1));
      int pos = 1;
      tempList[0]=flip(list[0]);
      for(byte x: temp.binary){
        tempList[pos] = x;
        pos++;
      }
      tempList[list.length-1]=flip(list[list.length-1]);
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
  return tempList;
}

@Override
  public boolean equals(Object obj){
    if(this == obj)
      return true;
    else if(this.getClass() == obj.getClass()){
      Onion onion = (Onion) obj;
      if((this.toString()).equals(onion.toString()))
        return true;
    }
    return false;
  }

  @Override
  public String toString(){
    return Arrays.toString(binary);
  }

}
