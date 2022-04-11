package vertex.FuturePromise;

import io.vertx.core.*;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vertex.VerticlesExample.Verticle;

import java.util.ArrayList;
import java.util.Arrays;

public class FuturePromise extends AbstractVerticle {
  private static final Logger log = LoggerFactory.getLogger(Verticle.class);
  public static void main(String[] args) {
    var vertx = Vertx.vertx();

    var futures = new ArrayList<Future>();
    final Promise<String> promise1 = Promise.promise();
    promise1.complete("Promise done by promise 1");
      futures.add(promise1.future().onComplete(handler ->{
        System.out.println("1");
      }));

    final Promise<Void> promise4 = Promise.promise();
    promise4.fail("Failed");
    futures.add(promise4.future().onComplete(handler ->{

      System.out.println("4");
    }));

    final Promise<Void> promise2 = Promise.promise();
    promise2.complete();
    futures.add(promise2.future().onComplete(handler ->{
      System.out.println("2");
    }));

    final Promise<JsonObject> promise3 = Promise.promise();

    promise3.complete();
    futures.add(promise3.future().onComplete(handler ->{
      System.out.println("3");
    }));


    final Future future1 = promise1.future();
    final Future<Void> future2 = promise2.future();
    final Future<JsonObject> future3 = promise3.future();
    final Future<Void> future4 = promise4.future();

    /*future1.map(value ->{
      JsonObject jsonObject = new JsonObject();
      jsonObject.put("id",value);
      return jsonObject.toString();
    }).onSuccess(result ->{
      log.debug((String) result);
    });*/





   /* CompositeFuture.any(Arrays.asList(future1,future2,future3,future4)).onComplete(handler->{
      if(handler.succeeded())
      {
        log.debug("Composite future Succedded");
      }else{
        log.debug("Composite future not Succedded");
      }
    });*/

    /*CompositeFuture.any(Arrays.asList(future1,future2,future3)).onComplete(handler->{
      if(handler.succeeded())
      {
        log.debug("Composite future Succedded");
      }else{
        log.debug("Composite future not Succedded");
      }
    });*/

    /*CompositeFuture.join(Arrays.asList(future1,future4,future3,future2)).onComplete(handler->{
      if(handler.succeeded())
      {
        log.debug("Composite future Succedded");
      }else{
        log.debug("Composite future not Succedded");
      }
    });*/


    /*CompositeFuture.join(futures).onComplete(handler->{
      if(handler.succeeded())
      {
        log.debug("Composite future Succedded");
      }else{
        log.debug("Composite future not Succedded");
      }
    });*/

    CompositeFuture.join(futures).onComplete(handler->{
      if(handler.succeeded())
      {
        log.debug("Composite future Succedded");
      }else{
        log.debug("Composite future not Succedded");
      }
    });



     /*CompositeFuture.join(Arrays.asList(future4)).onComplete(handler->{
      if(handler.succeeded())
      {
        log.debug("Composite future Succedded");
      }else{
        log.debug("Composite future not Succedded");
      }
    });

    CompositeFuture.all(Arrays.asList(future4)).onComplete(handler->{
      if(handler.succeeded())
      {
        log.debug("Composite future Succedded");
      }else{
        log.debug("Composite future not Succedded");
      }
    });
*



    /*future1.compose(result ->{
      if(future1.succeeded())
      {
        log.debug("Pass at level 1");
        log.debug((String) result);
      }
      return result;
    });*/


   /* CompositeFuture.any(future1,future2,future3,future4).onComplete(handler->{

      if(handler.succeeded())
      {
        log.debug("Composite future Succedded");
      }else{
        log.debug("Composite future not Succedded");
      }
    });*/







   /* CompositeFuture.all(future1,future2,future3).onComplete(handler ->{
    if(handler.succeeded()){
      log.debug("Composite future Completed");
    }else{
      log.debug("Composite Future failed");
    }
    });*/

    /*CompositeFuture.all(future1,future2,future3,future4).onComplete(handler ->{
      if(handler.succeeded()){
        log.debug("Composite future Completed");
      }else{
        log.debug("Composite Future failed");
      }
    });*/




  }
}
