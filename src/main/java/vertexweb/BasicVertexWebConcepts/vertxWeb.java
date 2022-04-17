package vertexweb.BasicVertexWebConcepts;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

public class vertxWeb {
  public static void main(String[] args) {
    var vertex = Vertx.vertx();
    HttpServer httpServer = vertex.createHttpServer();
    Router router = Router.router(vertex);
    router.route().handler(handler ->{
      System.out.println("client connected");
      HttpServerResponse httpServerResponse = handler.response();
      httpServerResponse.putHeader("content-type","text/plain");
      httpServerResponse.end("Hello");
    });
    httpServer.requestHandler(router).listen(8080);
  }
}
