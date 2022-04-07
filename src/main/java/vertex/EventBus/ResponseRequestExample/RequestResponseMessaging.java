package vertex.EventBus.ResponseRequestExample;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vertex.VerticlesExample.Verticle;

public class RequestResponseMessaging extends AbstractVerticle {
  private static final Logger log = LoggerFactory.getLogger(Verticle.class);
  public static void main(String[] args) {
    var vertx = Vertx.vertx();
    vertx.deployVerticle(new ResponseVerticle()).onComplete(Handler1 ->{
      vertx.deployVerticle(new RequestVerticle());
    });

  }
  @Override
  public  void start(Promise<Void> startPromise) throws Exception{
    startPromise.complete();

  }

  static  class RequestVerticle extends  AbstractVerticle{
    @Override
    public void start(Promise<Void> startPromise) throws Exception {
    startPromise.complete();
      var eventBus = vertx.eventBus();
      eventBus.request("address1","Hello World",reply ->{
        log.debug("Response {}"+reply.result().body());

      });
    }
  }

  static  class ResponseVerticle extends  AbstractVerticle{
    @Override
    public void start(Promise<Void> startPromise) throws Exception {
      startPromise.complete();
      var eventBus = vertx.eventBus();
      eventBus.<String>consumer("address1",message ->{
        log.debug("Message received "+ message.body());
        message.reply("Received the message");
      });

    }

  }
}
