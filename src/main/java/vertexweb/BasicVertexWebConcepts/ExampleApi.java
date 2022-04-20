package vertexweb.BasicVertexWebConcepts;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.AllowForwardHeaders;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.AuthenticationHandler;
import io.vertx.ext.web.handler.BasicAuthHandler;
import io.vertx.ext.web.handler.SessionHandler;
import io.vertx.ext.web.sstore.LocalSessionStore;

public class ExampleApi {
  public static void attach(Router router) {
   /* router.route().method(HttpMethod.POST).path("/example").handler(context ->{
      System.out.println(context.getBody().toString());

      context.put("name","vedant");
      context.next();
      //System.out.println(context);
    });
    router.route().method(HttpMethod.POST).path("/example/123").handler(context ->{
      //System.out.println(context.getBody().toString());
      System.out.println(context.get("name").toString());
      System.out.println(context);
      context.response().end(context.getBody().toString());
    });
*/

   /* router.get("/some/path").putMetadata("name","akcjbsdjvhadbvj").handler(ctx -> {
    //ctx.response().end(ctx.getBody().toString());
      System.out.println(ctx.currentRoute().getMetadata("name").toString());;
      ctx.response().end("Response done");

    });*/
    /*router.post("/some/path").handler(ctx -> {
      ctx.response().setChunked(true);

      ctx.put("foo", "bar");
     // ctx.response().write("Hello");
      ctx.redirect("www.google.com");
      //ctx.reroute("/some/path/123");

    });
    router.post("/some/path/123").handler(ctx ->{
      ctx.response().setChunked(true);
     ctx.response().write("world");

      ctx.response().end();
    });*/

    /*router
      .post("/some/path/B")
      .handler(ctx -> {
        System.out.println(ctx.get("foo").toString());

        ctx.response().end(ctx.get("foo").toString());});

    router
      .post("/some/path")
      .handler(ctx -> {
        System.out.println("i am here");
        ctx.reroute("/some/path/B");});*/


    //Authentication

    router.route().handler(SessionHandler.create(LocalSessionStore.create(Vertx.vertx())));
    //AuthenticationHandler basicAuthenticationHandler = BasicAuthHandler.create(authProvider);
     // router.route().path("/private/*").handler()

  }
}
