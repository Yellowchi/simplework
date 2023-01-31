package com.simplework.simplework.Controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.simplework.simplework.Config.WebSocketConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@ServerEndpoint("/api/websocketserver/{item}/{id}")
@Component
@ConditionalOnBean(value = WebSocketConfig.class)
public class WebSocketServer {
    /**静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。*/
    private static int onlineCount = 0;
    /**concurrent包的线程安全Set，用来存放每个客户端对应的WebSocket对象。*/
    private static final ConcurrentHashMap<String,WebSocketServer> webSocketMap = new ConcurrentHashMap<>();
    /**与某个客户端的连接会话，需要通过它来给客户端发送数据*/
    private Session session;
    /**接收userId*/
    private String id = "",item = "";

    /**
     * 连接建立成
     * 功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "item") String item, @PathParam(value = "id") String id){
        this.session = session;
        this.id = id;
        this.item = item;
        if (webSocketMap.containsKey(item+id)){
            webSocketMap.remove(item+id);
            webSocketMap.put(item+id,this);
        }else {
            webSocketMap.put(item+id,this);
            addOnlineCount();
        }
        log.info("用户连接："+session+"，ID："+item+id+"，当前在线人数："+getOnlineCount());
        sendMessage("用户连接成功");
    }

    /**
     * 关闭连接
     * 调用方法
     */
    @OnClose
    public void onClose(Session session,@PathParam("item") String item,@PathParam("id") String id){
        if (webSocketMap.containsKey(item+id)){
            webSocketMap.remove(item+id);
            subOnlineCount();
        }
        log.info("用户连接："+item+id+"，当前在线人数："+getOnlineCount());
    }

    /**
     * 收到客户端消息后
     * 调用方法
     * @param message
     * 客户端发来信息
     */
    @OnMessage
    public void onMessage(String message,Session session){
        log.info("用户连接："+item+id+"，报文："+message);
        if  (StringUtils.isNotBlank(message)){
            try {
                //解析发送的报文
                JSONObject jsonObject = JSON.parseObject(message);
                //追加发送人(防止串改)
                jsonObject.put("fromUserId",this.id);
                String toid=jsonObject.getString("toid");
                String toitem = jsonObject.getString("toitem");
                String content = jsonObject.getString("content");
                log.info("-------toitem:"+toitem+"; toid:"+toid+"; content:"+content);
                //传送给对应toUserId用户的websocket
                if(StringUtils.isNotBlank(toitem+toid)&&webSocketMap.containsKey(toitem+toid)){
                    sendInfo(content,toitem, toid);
                    log.info("message:"+message);
                }else{
                    //否则不在这个服务器上，发送到mysql或者redis
                    log.error("请求的userId:"+toitem+toid+"不在该服务器上");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("用户错误:"+this.item+this.id+",原因:"+error.getMessage());
        error.printStackTrace();
    }

    /**
     * 实现服务
     * 器主动推送
     */
    public void sendMessage(String message) {
        try {
            log.info("this session:"+this.session);
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *发送自定
     *义消息
     **/
    public static void sendInfo(String message, String item, String id) {
        log.info("发送消息到:"+item+id+"，报文:"+message);
        if(StringUtils.isNotBlank(item+id) && webSocketMap.containsKey(item+id)){
            webSocketMap.get(item+id).sendMessage(message);
        }else{
            log.error("用户"+item+id+",不在线！");
        }
    }

    private static synchronized void addOnlineCount(){
        WebSocketServer.onlineCount++;
    }

    private static synchronized void subOnlineCount(){
        WebSocketServer.onlineCount--;
    }

    private int getOnlineCount(){
        return onlineCount;
    }
}
