package vertex.EventLoopExample;

import io.vertx.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vertex.VerticlesExample.Verticle;
import vertex.VerticlesExample.verticleA;

import java.util.concurrent.TimeUnit;

public class EventLoopExample extends AbstractVerticle {

  private static final Logger log = LoggerFactory.getLogger(Verticle.class);

  public static void main(String[] args) {
    final var vertx = Vertx.vertx(
      new VertxOptions().setMaxEventLoopExecuteTime(50000).
        setMaxEventLoopExecuteTimeUnit(TimeUnit.MILLISECONDS).
        setBlockedThreadCheckInterval(1).
        setBlockedThreadCheckIntervalUnit(TimeUnit.SECONDS).setEventLoopPoolSize(36)
    );
    vertx.deployVerticle(new EventLoopExample(),new DeploymentOptions());
    for (int i =0 ;i<5000 ;i++) {
      vertx.deployVerticle("vertex.VerticlesExample.verticleA",res ->{

      });
    }
  }

  @Override
  public void start(final Promise<Void> startPromise) throws Exception {
    log.debug("start {}" + getClass().getName());
    startPromise.complete();
    /*Thread.sleep(5000);*/
  }
}
