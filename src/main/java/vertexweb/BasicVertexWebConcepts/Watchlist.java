package vertexweb.BasicVertexWebConcepts;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.vertx.core.json.JsonObject;

import java.util.List;

public class Watchlist {
  private List<Asset> assets;
  public JsonObject toJsonObject(){
    return JsonObject.mapFrom(this);
  }
}
