package vertex.VerticlesExample;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vertex.VerticlesExample.Verticle;

public class verticleA extends AbstractVerticle {
  private static  final Logger log =  LoggerFactory.getLogger(Verticle.class);
  @Override
  public void start(final Promise<Void> startPromise )throws Exception{
    log.debug("start " +Thread.currentThread().getName());

    /*Thread.sleep(2000);*/
    startPromise.complete();
  }
}
