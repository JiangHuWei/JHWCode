package com.jhw.controller.test;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

@ServerEndpoint("/websocket.ws/{userCode}")
public class WebSocketController {
	
	private static Logger LOGGER = (Logger) LoggerFactory.getLogger(WebSocketController.class);

    private static Map<String,Session> webSocketSet = new ConcurrentHashMap<>();

    /**
     * 打开连接事触发
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("userCode") String userCode,Session session){
        LOGGER.info("打开websocket连接...");
        webSocketSet.put(userCode,session);
    }

    /**
     * 收到客户端消息时触发，并发送给特定用户
     * @param textJson
     * @return
     */
    @OnMessage
    public String onMessage(String textJson){
        String userCode = "";
        String message = "";
        try {
            if(StringUtils.isNotEmpty(textJson)){
                //解析字符串
                JSONObject object = JSONObject.fromObject(textJson);
                userCode = object.getString("sendName");
                message = object.getString("message");
                Session session = webSocketSet.get(userCode);
                if(null != session){
                    session.getBasicRemote().sendText(message);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        return "已经给"+userCode+"发送消息啦！message："+message;
    }


    /**
     * 异常时触发
     */
    @OnError
    public void onError(Throwable throwable) {
        LOGGER.info("Websocket连接出现异常:");
        LOGGER.info(throwable.getMessage(), throwable);
    }

    /**
     * 关闭连接时触发
     */
    @OnClose
    public void onClose(@PathParam("userCode") String userCode) {
        LOGGER.info("Websocket 关闭连接...");
        webSocketSet.remove(userCode);
    }
}
