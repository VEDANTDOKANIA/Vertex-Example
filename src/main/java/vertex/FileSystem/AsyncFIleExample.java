package vertex.FileSystem;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.AsyncFile;
import io.vertx.core.file.FileSystem;
import io.vertx.core.file.OpenOptions;

import java.nio.file.OpenOption;

public class AsyncFIleExample {
  public static void main(String[] args) {
    Vertx vertx= Vertx.vertx();
    OpenOptions openOptions = new OpenOptions();
    FileSystem fileSystem = vertx.fileSystem();

    // Async File write
   /* fileSystem.open("src/main/java/vertex/FileSystem/File2.txt",openOptions,handler ->{
      if(handler.succeeded()){
        AsyncFile file = handler.result();
        Buffer buffer = Buffer.buffer("My name is vedant123");
        file.write(buffer,handler1 ->{
          if(handler1.succeeded()){
            System.out.println("file written");
            vertx.close();
          }else{
            System.out.println("Error Occured"+handler1.cause().getCause());
          }
        });
      }else{
        System.out.println("error");
      }
    });*/

    //Async file read
    fileSystem.open("src/main/java/vertex/FileSystem/File2.txt",openOptions,handler ->{
      if(handler.succeeded()){
        Buffer buffer = Buffer.buffer();
        AsyncFile file= handler.result();
        file.read(buffer,0,0,1000,handler1 ->{
          System.out.println(buffer);
          file.write(Buffer.buffer("vedant"), buffer.length());
        });
        }else{
        System.out.println("Unable to write on file");
      }
      }
    );


  }
  }
