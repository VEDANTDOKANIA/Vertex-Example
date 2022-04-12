package vertex.Json;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.*;

public class JsonObjectExample {
  public static void main(String[] args) {
    JsonObject jsonObject = new JsonObject();
    HashMap<String,Object> hashMap = new HashMap<>();
    hashMap.put("1","hello");
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.add(23);
    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("abc");
    Set<String> set = new HashSet<>();
    set.add("abcd");
    TreeMap<String,String> treeMap = new TreeMap<>();
    treeMap.put("1","hello");
    jsonObject.put("HashMap", hashMap);
    jsonObject.put("Linkedlist",linkedList);
    jsonObject.put("Arraylist",arrayList);
    jsonObject.put("TreeMap",treeMap); // Because its a type of map
   // jsonObject.put("Hashset",set); // We cannot put set as it is not defined in JacksonCodec.java

    System.out.println(jsonObject);

    JsonArray jsonArray = new JsonArray();
    jsonArray.add(0,true);
    jsonArray.add(1,hashMap);
    jsonArray.add(2,linkedList);
    jsonArray.add(3,arrayList);
    jsonArray.add(4,treeMap);
    //jsonArray.add(5,set);

    System.out.println(jsonArray);

  }
}
