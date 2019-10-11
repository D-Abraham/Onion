/**
recursive class that its constructor takes an odd number of binary digits as
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
@param binary this is the byte array
@exception thows a messege exception
*/
  public Onion(byte[] binary) throws Exception{

    if((binary.length%2 == 0) || !(isBinary(binary))){
      throw new Exception("Input must be binary and odd in length.");
    }
    else{
      this.binary = onionRecusive(binary);
    }

  }

/**
TODO
*/
  static byte[] stringToByte(String str){

    byte[] temp= new byte[str.length()];
    for(int pos=0; pos<str.length();pos++){
      temp[pos]= (byte)(str.charAt(pos)-'0');
    }
    System.out.println(temp);
    return temp;
  }

  /**
  //TODO
  */
  public byte[] getByteList(){
    return binary;
  }

  /**
  //TODO
  */
private boolean isBinary(byte[] list) {
 boolean binary = true;
 int pos=-1;
 while(binary==true && pos<list.length-1){
   pos++;
   if(list[pos]>1){
     binary=false;
   }
 }
 return binary;
}

/**
//TODO
*/
private byte flip(byte x){
  if(x == 1){
    return 0;
  }
    else {
      return 1;
    }
  }

  /**
  //TODO
  */
private  byte[] onionRecusive(byte[] list){
  Onion temp;
  byte[] tempList = new byte[list.length];
  int pos=1;
  if(list.length == 1){ //Base case
    tempList[0]=flip(list[0]);
  }
  else{
    try{
      temp = new Onion(Arrays.copyOfRange(list, 1, list.length-1));
      tempList[0]=flip(list[0]);
      for(byte x: temp.binary){
        tempList[pos] = x;
        pos++;
      }
      tempList[list.length-1]=flip(list[list.length-1]);
      System.out.println(" "+Arrays.toString(tempList)); //debugging
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
  return tempList;
}

/**
//TODO
*/
  public boolean equals(Object obj){
    if(this == obj)
      return true;
    else if(this.getClass() == obj.getClass()){
      Onion onion = (Onion) obj;
      if(this.binary == onion.binary)
        return true;
    }
    return false;
  }

  /**
  //TODO
  */
  public String toString(){
    return Arrays.toString(binary);
  }

}
