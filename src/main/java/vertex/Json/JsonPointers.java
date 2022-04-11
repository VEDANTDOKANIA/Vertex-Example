package vertex.Json;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.pointer.JsonPointer;

public class JsonPointers {
  public static void main(String[] args) {
    JsonPointer jsonPointer = JsonPointer.from("/i/name/vedant");
  jsonPointer.append("Dokania");
    System.out.println(jsonPointer);
    JsonObject jsonObject = new JsonObject();
    jsonObject.put("name","vedant");
    System.out.println(jsonPointer.queryJson(jsonObject));
  }


}
