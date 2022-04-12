package vertex.Buffers;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;

public class BufferExample {
  public static void main(String[] args) {
    Buffer buffer = Buffer.buffer(1000); //Size empty hee hain. Bas itna size define kiya hain
    /*buffer.setInt(0,1);
    System.out.println(buffer.length());
    buffer.setString(4,"hiii");*/

    buffer.setDouble(0,1);
    System.out.println(buffer.length());

/*    buffer.appendInt(1212333333);
    buffer.appendString("Hello1111"); //Each index pe ek letter honga
    buffer.appendInt(16);*/
    System.out.println(buffer.getInt(0));
    System.out.println(buffer.getString(4,buffer.length()));

    JsonObject jsonObject = new JsonObject();


   /* byte   aByte   = buffer.getByte  ( 0); // Byte - 2
    short  aShort  = buffer.getShort ( 2);  // short 2
    int    anInt   = buffer.getInt   ( 4);  // int 4
    long   aLong   = buffer.getLong  ( 8);  //long 8
    float  aFloat  = buffer.getFloat (16);  //float 4
    double aDouble = buffer.getDouble(20);  // double 8
    */



  }
}
