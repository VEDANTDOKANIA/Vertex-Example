import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vertex.EventBus.PublishSubscribeExample.PublishSubscribe;

@ExtendWith(VertxExtension.class)
public class FuturePromiseExample {
  private static  final Logger log =  LoggerFactory.getLogger(FuturePromiseExample.class);

  @Test
  void promise_success(Vertx vertx, VertxTestContext context){

    final Promise<String> promise = Promise.promise();
    log.info("start {}");

    vertx.setTimer(500, id ->{
      promise.complete("success");
      log.info("success");
      context.completeNow();
    });
    log.info("end");


  }

}
