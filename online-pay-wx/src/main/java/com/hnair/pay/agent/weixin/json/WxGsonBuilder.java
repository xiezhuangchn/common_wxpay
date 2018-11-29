package com.hnair.pay.agent.weixin.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hnair.pay.agent.weixin.bean.WxAccessToken;
import com.hnair.pay.agent.weixin.bean.menu.WxMenu;
import com.hnair.pay.agent.weixin.bean.result.WxMediaUploadResult;
import com.hnair.pay.agent.weixin.exception.WxError;

public class WxGsonBuilder {

  public static final GsonBuilder INSTANCE = new GsonBuilder();

  static {
    INSTANCE.disableHtmlEscaping();
    INSTANCE.registerTypeAdapter(WxAccessToken.class, new WxAccessTokenAdapter());
    INSTANCE.registerTypeAdapter(WxError.class, new WxErrorAdapter());
    INSTANCE.registerTypeAdapter(WxMenu.class, new WxMenuGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMediaUploadResult.class, new WxMediaUploadResultAdapter());
  }

  public static Gson create() {
    return INSTANCE.create();
  }

}
