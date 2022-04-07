package vertex.EventBus.PublishSubscribeExample;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

import java.util.HashMap;

public class publish extends AbstractVerticle {
  @Override
  public void start(final Promise<Void> startPromise) throws Exception {
    HashMap<String,String> hashMap = new HashMap<>();
    hashMap.put("1","hello");

    vertx.eventBus().publish("address",hashMap.toString());
    startPromise.complete();
  }
}
