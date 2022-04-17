package vertexweb.BasicVertexWebConcepts;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vertex.VerticlesExample.Verticle;

public class MainVerticle extends AbstractVerticle {
  private static final Logger log = LoggerFactory.getLogger(MainVerticle.class);
  public static final int PORT = 8081;

  public static void main(String[] args) {
    var vertx = Vertx.vertx();
    vertx.exceptionHandler(error ->{
      log.error("unhandled{}"+error);
    });
    vertx.deployVerticle("vertexweb.BasicVertexWebConcepts.MainVerticle",response ->{
      if(response.failed()){
        log.error("Failed to load the verticle"+response.cause());
        return;
      }else{
        log.info("Verticle Deployed");
      }
    });
  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    final Router router = Router.router(vertx);
    AssetsRestApi.attach(router);
    QuotesRestApi.attach(router);
    WatchListRestApi.attach(router);
    FailureHandler(router);
    vertx.createHttpServer().requestHandler(router).exceptionHandler(exception ->{
      log.error("Exception Occurred"+exception.getCause().getMessage());
    }).listen(PORT, http -> {
      if(http.succeeded()){
        startPromise.complete();
        System.out.println("Server Started");
      }else{
        startPromise.fail(http.cause());
        System.out.println("Server failed to satrt");
      }
    });
  }

  private void FailureHandler(Router router) {
    router.route().failureHandler(errorContext ->{
      if(errorContext.response().ended()){
        //response ended by the client or response not completed
      }else{
        log.error("Route Error",errorContext.failure());
      }
      errorContext.response().setStatusCode(500).end(new JsonObject().put("Message","Someting went Wrong").toBuffer());
    });
  }
}
