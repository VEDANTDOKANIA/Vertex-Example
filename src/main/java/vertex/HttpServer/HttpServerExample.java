package vertex.HttpServer;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;

public class HttpServerExample {
  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    HttpServerOptions httpServerOptions = new HttpServerOptions().setPort(2000);
    HttpServer server = vertx.createHttpServer(httpServerOptions);
    server.requestHandler(handler ->{


    });
      server.listen(2000,"0.0.0.0",handler ->{
        if(handler.succeeded()){
          System.out.println("Server is listening");
        }else{
          System.out.println("Server is not listening");
        }
      });


  }
}
