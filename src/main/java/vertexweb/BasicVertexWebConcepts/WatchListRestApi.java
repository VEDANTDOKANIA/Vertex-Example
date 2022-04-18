package vertexweb.BasicVertexWebConcepts;

import io.netty.handler.codec.http.HttpResponseStatus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

public class WatchListRestApi {
  private static final Logger log = LoggerFactory.getLogger(WatchListRestApi.class);
  public static final String path = "/account/watchlist/:accountId";

  public static void attach(Router router) {
    final HashMap<UUID,Watchlist> watchlistPerAccount = new HashMap<UUID, Watchlist>();

    router.get(path).handler(context ->{
      var accountId = context.pathParam("accountId");
      log.debug("{} for account {}",context.normalizedPath(),accountId);
      var watchlist = Optional.ofNullable(watchlistPerAccount.get(UUID.fromString(accountId)));
      if(watchlist.isEmpty()){
        context.response().setStatusCode(HttpResponseStatus.NOT_FOUND.code()).end(
          new JsonObject().put("message","watchlist for account"+accountId+"not available")
            .put("path",context.normalizedPath()).toBuffer());
          return;
      }
      context.response().end(watchlist.get().toJsonObject().toBuffer());
    });
    router.put(path).handler(context ->{
      var accountId = context.pathParam("accountId");
      log.debug("{} for account {}",context.normalizedPath(),accountId);
     var json = context.getBodyAsJson();
     var watchlist = json.mapTo(Watchlist.class);
     watchlistPerAccount.put(UUID.fromString(accountId),watchlist);
     context.response().end(json.toBuffer());
    });
    router.delete(path).handler(context ->{});

  }
}
