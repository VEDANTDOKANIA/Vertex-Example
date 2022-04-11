package vertex.FileSystem;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.FileSystem;

import java.sql.Time;
import java.time.LocalDateTime;

public class FileSystemExample {
  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    FileSystem fileSystem = vertx.fileSystem();

    //Copy two files

   /* fileSystem.copy("src/main/java/vertex/FileSystem/File1.txt","src/main/java/vertex/FileSystem/File2.txt",handler ->{
      if(handler.succeeded()){
        System.out.println("File Copied");
        vertx.close();
      }else{
        System.out.println("Not copied");
        System.out.println(handler.cause());
        System.out.println(handler.cause().getCause());
        vertx.close();
      }
    });*/

    //Reading from file

    /*fileSystem.readFile("src/main/java/vertex/FileSystem/File1.txt",handler ->{
      if(handler.succeeded()){
        System.out.println(handler.result());
      }else{
        System.out.println(handler.cause().getCause());
      }
    });*/

    //Reading from Directory

   /* fileSystem.readDir("src/main/java/vertex/FileSystem",handler ->{
      if(handler.succeeded()){
        System.out.println(handler.result());
      }else{
        System.out.println(handler.cause().getCause());
      }
    });*/

    //Writing into file

    fileSystem.writeFile("src/main/java/vertex/FileSystem/File1.txt", Buffer.buffer("I am vedant"),handler ->{
      if (handler.succeeded()){
        System.out.println("file written");
        fileSystem.readFile("src/main/java/vertex/FileSystem/File1.txt",handler1 ->{
          if(handler1.succeeded()){
            System.out.println(handler1.result());
          }else{
            System.out.println("Unable to read file");
          }
        });
      }else{
        System.out.println("Unable to write in file");
      }
    });



  }
}
