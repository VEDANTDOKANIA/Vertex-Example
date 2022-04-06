package vertex.EventBus.PublishSubscribeExample;

import io.vertx.core.*;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PublishSubscribe {
  private static  final Logger log =  LoggerFactory.getLogger(PublishSubscribe.class);

  public static void main(String[] args) {
    var vertx = Vertx.vertx();




      vertx.deployVerticle(new subscribe1()).onComplete(handler ->
      {
        vertx.deployVerticle(new subscribe2()).onComplete(handler1 ->
        {
          vertx.deployVerticle(new publish());

          vertx.undeploy(handler.result(),handler2 ->
          {
          });

        });

      });



    System.out.println("chaitas");


  }



  public  static class publish extends AbstractVerticle{
    @Override
    public void start(final Promise<Void> startPromise) throws Exception {

      vertx.eventBus().publish("address","hello");



      startPromise.complete();
    }
  }
  public static  class subscribe1 extends AbstractVerticle{
    @Override
    public void start(final Promise<Void> startPromise) throws Exception {
      vertx.eventBus().<String>consumer("address",message ->{
        System.out.println(message.body());
        log.debug("Message Received"+message.body());
        message.reply("message received");
      });

      startPromise.complete();
    }
  }

  public static class subscribe2 extends AbstractVerticle{
    @Override
    public void start(final Promise<Void> startPromise) throws Exception {
      vertx.eventBus().<String>consumer("address",message ->{
        log.debug("Message Received"+message.body()+"from subscriber 2");
        System.out.println(message.body());

      });
      vertx.eventBus().<String>consumer("address",message ->{
        log.debug("Message Received"+message.body()+"from subscriber 2-1");
        System.out.println(message.body());

      });
      startPromise.complete();

    }
  }

}
