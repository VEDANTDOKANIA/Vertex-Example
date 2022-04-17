package vertexweb.BasicVertexWebConcepts;

import io.vertx.core.json.JsonObject;

import java.math.BigDecimal;

public class Quote {
Asset asset;
int bid ;
int ask;
int lastPrice;
int volume;

  public Asset getAsset() {
    return asset;
  }

  public void setAsset(Asset asset) {
    this.asset = asset;
  }

  public int getBid() {
    return bid;
  }

  public void setBid(int bid) {
    this.bid = bid;
  }

  public int getAsk() {
    return ask;
  }

  public void setAsk(int ask) {
    this.ask = ask;
  }

  public int getLastPrice() {
    return lastPrice;
  }

  public void setLastPrice(int lastPrice) {
    this.lastPrice = lastPrice;
  }

  public int getVolume() {
    return volume;
  }

  public void setVolume(int volume) {
    this.volume = volume;
  }

  public Quote(Asset asset, int bid, int ask, int lastPrice, int volume) {
    this.asset = asset;
    this.bid = bid;
    this.ask = ask;
    this.lastPrice = lastPrice;
    this.volume = volume;
  }

  public JsonObject toJsonObject(){
    return JsonObject.mapFrom(this);
  }
}
