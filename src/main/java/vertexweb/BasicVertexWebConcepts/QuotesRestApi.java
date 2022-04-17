package vertexweb.BasicVertexWebConcepts;

import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuotesRestApi {
  private static final Logger log = LoggerFactory.getLogger(MainVerticle.class);

  public static void attach(Router router){
    router.get("/quotes/:asset").handler(context ->{
     final String assetParam= context.pathParam("asset");
     log.debug("Asset Parameter {} ",assetParam);
     final  Quote quote = new Quote(new Asset(assetParam),100,100,100,100);
     final JsonObject response = quote.toJsonObject();
     log.info("Path {} responds with {}",context.normalizedPath(),response.encode());
     context.response().end(response.toBuffer());

    });
  }
}
