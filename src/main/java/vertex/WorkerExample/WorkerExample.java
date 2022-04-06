package vertex.WorkerExample;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vertex.VerticlesExample.Verticle;
import vertex.VerticlesExample.verticleA;

public class WorkerExample extends AbstractVerticle {
  private static  final Logger log =  LoggerFactory.getLogger(WorkerExample.class);
  public static void main(String[] args) {
    var vertx = Vertx.vertx();
    vertx.deployVerticle(new WorkerExample());
    vertx.deployVerticle(new verticleA(),new DeploymentOptions().setWorker(true));
  }
  @Override
  public void start(final Promise<Void> startPromise) throws Exception{
    startPromise.complete();
    vertx.executeBlocking(event -> {
      log.debug("Executing Debug");
      try {
        Thread.sleep(5000);
        event.complete();
      } catch (InterruptedException e) {
        log.error("Failed:",e);
        event.fail(e);
      }

    },result ->{
      if(result.succeeded()){
        log.debug("Blocking Code Done");
      }else{
        log.debug("Blocking Code failed");
      }

    });
  }

}
