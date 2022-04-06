package vertex.EventBus.sendMap;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vertex.VerticlesExample.Verticle;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class SendMap extends AbstractVerticle {
  private static final Logger log = LoggerFactory.getLogger(SendMap.class);
  public static void main(String[] args) {
    var vertx = Vertx.vertx();
    vertx.deployVerticle(new sender(),ar ->{
      if(ar.failed()){
        log.debug("error {}" + ar.cause());
      }else{
        log.debug("succedded",ar.cause());
      }
    });
    vertx.deployVerticle(new receiver(),ar ->{
      if(ar.succeeded()){
        log.debug("succedded"+ ar.cause());
      }else{
        log.debug("error",ar.cause());
      }
    });
  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    startPromise.complete();
  }

  public static class sender extends AbstractVerticle{
    @Override
    public void start(final Promise<Void> startPromise) throws Exception {
      var eventBus = vertx.eventBus();
      HashMap<Integer,String> hashMap = new HashMap<>();
      hashMap.put(1,"vedant");
      hashMap.put(2,"pruthvi");
      eventBus.request("address","Hello",reply->{
        if(reply.failed()){
          log.error("Error Occured:" +reply.cause());
        }else{
          log.debug("Message reply received");
        }
      });
      startPromise.complete();
    }
  }

  public static class  receiver extends AbstractVerticle{

    @Override
    public void start(final Promise<Void> startPromise) throws Exception {
      var eventBus = vertx.eventBus();
      HashMap<Integer,String> hashMap = new HashMap<>();
      eventBus.consumer("address",message->{
        log.debug("Message Received"+message.body().toString());
        message.reply("I received message");
       /* message.reply("Thanks for the message");*/
      }).exceptionHandler(error ->{
        log.debug("Error Ocuured in receiving. Message not received");
      });
      startPromise.complete();
    }
  }
}
