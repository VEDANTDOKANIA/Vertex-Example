package vertexweb.BasicVertexWebConcepts;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class AssetsRestApi extends AbstractVerticle {
  private static final Logger log = LoggerFactory.getLogger(AssetsRestApi.class);

  public static final List<String> Assets = Arrays.asList("AMPl","NTFl","TSLA","Goog","Faceb");

   public static void attach(Router parent){
   parent.get("/assets").handler(context ->{
      final JsonArray jsonArray = new JsonArray();

      Assets.stream().map(Asset::new).forEach(jsonArray::add);
      log.info("Path {} responds with {}"+context.normalizedPath(),jsonArray.encode());
      context.response().end(jsonArray.toBuffer());
    });
  }
}
