import io.vertx.core.Vertx;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.junit5.VertxTestContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vertexweb.BasicVertexWebConcepts.MainVerticle;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebClientTesting {
  private static final Logger log = LoggerFactory.getLogger(WebClientTesting.class);

  @BeforeEach
  void deploy_verticle(Vertx vertx,VertxTestContext context){
    vertx.deployVerticle(new MainVerticle(),context.succeeding(id ->{context.completeNow();}));
  }
  @Test
  void  return_all_assests(Vertx vertx, VertxTestContext context) throws Exception{
    var client = WebClient.create(vertx,new WebClientOptions().setDefaultPort(MainVerticle.PORT));
    client.get("/assets")
      .send()
        .onComplete(context.succeeding(response ->{
        var json = response.bodyAsJsonArray();
        log.info("Response {} :" + json);
        assertEquals("" , json.encode());
        assertEquals(200,response.statusCode());
        context.completeNow();

      }));
  }
}
