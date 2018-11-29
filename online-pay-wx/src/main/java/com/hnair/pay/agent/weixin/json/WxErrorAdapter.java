package com.hnair.pay.agent.weixin.json;

import com.google.gson.*;
import com.hnair.pay.agent.weixin.exception.WxError;

import java.lang.reflect.Type;

public class WxErrorAdapter implements JsonDeserializer<WxError> {

  @Override
  public WxError deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
    throws JsonParseException {
    JsonObject wxErrorJsonObject = json.getAsJsonObject();
    //TODO
    return new WxError();
  }

}
