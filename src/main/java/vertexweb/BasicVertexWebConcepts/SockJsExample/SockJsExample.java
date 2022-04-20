package vertexweb.BasicVertexWebConcepts.SockJsExample;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.shareddata.SharedData;
import io.vertx.ext.bridge.PermittedOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.handler.sockjs.SockJSBridgeOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;
import io.vertx.ext.web.handler.sockjs.SockJSHandlerOptions;

public class SockJsExample extends AbstractVerticle {

 @Override
  public void start(){
    Router router = Router.router(vertx);
    router.route("/eventbus/*").handler((Handler<RoutingContext>) eventBusHandler());
    router.route().handler(staticHandler());
   vertx.createHttpServer().requestHandler(router).exceptionHandler(exceptionHandler ->{
     System.out.println(exceptionHandler.getCause());
   }).listen(8888);

  }

  private Handler<RoutingContext> staticHandler() {
    return StaticHandler.create()
      .setCachingEnabled(false);

  }


  private Object eventBusHandler() {

    SockJSBridgeOptions options = new SockJSBridgeOptions().addOutboundPermitted(new PermittedOptions().setAddressRegex("out")).
      addInboundPermitted(new PermittedOptions().setAddressRegex("in"));
    SharedData sharedData = vertx.sharedData();
    CounterRepository counterRepository = new CounterRepository(sharedData);
    EventBus eventBus = vertx.eventBus();
    CounterHandler counterHandler = new CounterHandler(eventBus,counterRepository);
    SockJSHandler sockJSHandler = SockJSHandler.create(vertx);
    return (Handler) sockJSHandler.bridge(options,counterHandler);
  }

  /*public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    Router router = Router.router(vertx);
    SockJSHandlerOptions sockJSHandlerOptions = new SockJSHandlerOptions().setHeartbeatInterval(2000);
    SockJSHandler sockJSHandler = SockJSHandler.create(vertx,sockJSHandlerOptions);
    router.mountSubRouter("/myapp",sockJSHandler.socketHandler(sockJsSocket ->{

      sockJsSocket.handler(sockJsSocket::write);
    }));

  }*/
}
