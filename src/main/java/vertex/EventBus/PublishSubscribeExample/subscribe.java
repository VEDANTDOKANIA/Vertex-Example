package vertex.EventBus.PublishSubscribeExample;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class subscribe extends AbstractVerticle {
  private static  final Logger log =  LoggerFactory.getLogger(subscribe.class);
  @Override
  public void start(final Promise<Void> startPromise) throws Exception {
    vertx.eventBus().consumer("address",message ->{

      log.debug("Message Received"+message.body().toString());

    });

    startPromise.complete();
  }
}
