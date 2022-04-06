package vertex.VerticlesExample;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class Verticle extends AbstractVerticle {
  private static  final Logger log =  LoggerFactory.getLogger(Verticle.class);

  public static void main(String[] args) {
    final Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new Verticle());
  }

    @Override
      public void start( final Promise<Void> startPromise) throws Exception{
    log.debug("start {}" + getClass().getName());

      vertx.deployVerticle(new verticleA());
      vertx.deployVerticle(new verticleB());
      vertx.deployVerticle(verticleN.class.getName(), new DeploymentOptions().
        setInstances(4).
        setConfig(new JsonObject().put("Id", UUID.randomUUID().toString()).
          put("name",verticleN.class.getSimpleName()))
      );
      startPromise.complete();

    }

}
