package com.asyysy.asyysy_core.common.wx;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.asyysy.asyysy_core.common.wx.model.TextMeaasge;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import com.thoughtworks.xstream.XStream;



public class MessageUtil {
    /**      * 返回消息类型：文本      */
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";
    /**      * 返回消息类型：音乐      */
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
    /**      * 返回消息类型：图文      */
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";
    /**      * 请求消息类型：文本      */
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";
    /**      * 请求消息类型：图片      */
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";
    /**      * 请求消息类型：链接      */
    public static final String REQ_MESSAGE_TYPE_LINK = "link";
    /**      * 请求消息类型：地理位置      */
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";
    /**      * 请求消息类型：音频      */
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
    /**      * 请求消息类型：推送      */
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";
    /**      * 事件类型：subscribe(订阅)      */
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
    /**      * 事件类型：unsubscribe(取消订阅)      */
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
    /**      * 事件类型：CLICK(自定义菜单点击事件)      */
    public static final String EVENT_TYPE_CLICK = "CLICK";

    /*	 * 	 * 将xml转换成map集合	 * 	 * */
    public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
        Map<String, String> map=new HashMap<String,String>();
        SAXReader reader=new SAXReader();//使用dom4j解析xml
        InputStream ins=request.getInputStream();//从request中获取输入流
        Document doc=reader.read(ins);
        Element root=doc.getRootElement();   //获取根元素
        List<Element> list=root.elements();   //获取所有的节点
        for(Element e:list){
            map.put(e.getName(), e.getText());
            System.out.println(e.getName()+"----->"+e.getText());
        }
        ins.close();   //关流
        return map;
    }
    /*s	 * 将文本消息对象转换成xml	 * 	 * 	 * */
    public static String textMessageToXML(TextMeaasge textMessage){
        XStream xstream = new XStream();              // 使用XStream将实体类的实例转换成xml格式
        xstream.alias("xml", textMessage.getClass()); // 将xml的默认根节点替换成“xml”
         return xstream.toXML(textMessage);
    }
}
