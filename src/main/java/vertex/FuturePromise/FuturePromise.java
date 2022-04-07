package vertex.FuturePromise;

import io.vertx.core.*;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vertex.VerticlesExample.Verticle;

public class FuturePromise extends AbstractVerticle {
  private static final Logger log = LoggerFactory.getLogger(Verticle.class);
  public static void main(String[] args) {
    var vertx = Vertx.vertx();

    final Promise<String> promise1 = Promise.promise();


    vertx.setTimer(500,result->{
      promise1.complete("Promise done by promise 1");
    });

    final Promise<Void> promise2 = Promise.promise();
    vertx.setTimer(500,result->{
      promise2.complete();
    });

    final Promise<JsonObject> promise3 = Promise.promise();
    vertx.setTimer(500,result ->{
      JsonObject jsonObject = new JsonObject();
      jsonObject.put("id",1);
      jsonObject.put("name","vedant");
      jsonObject.put("JsonObject",true);
      promise3.complete(jsonObject);
    });

    final Promise<Void> promise4 = Promise.promise();
    vertx.setTimer(500,result->{
      promise4.fail("Failed");
    });

    final Future future1 = promise1.future();
    final Future<Void> future2 = promise2.future();
    final Future<JsonObject> future3 = promise3.future();
    final Future<Void> future4 = promise4.future();

    future1.map(value ->{
      JsonObject jsonObject = new JsonObject();
      jsonObject.put("id",value);
      return jsonObject.toString();
    }).onSuccess(result ->{
      log.debug((String) result);
    });





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

   /* CompositeFuture.join(Arrays.asList(future1,future2,future3,future4)).onComplete(handler->{
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
