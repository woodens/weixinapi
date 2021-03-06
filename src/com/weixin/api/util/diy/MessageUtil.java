package com.weixin.api.util.diy;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.weixin.api.message.res.Article;
import com.weixin.api.message.res.BaseResMessage;
import com.weixin.api.message.res.ImageResMessage;
import com.weixin.api.message.res.MusicResMessage;
import com.weixin.api.message.res.NewsResMessage;
import com.weixin.api.message.res.TextResMessage;
import com.weixin.api.message.res.VideoResMessage;
import com.weixin.api.message.res.VoiceResMessage;


/**
 * 消息工具类
 * 
 * @author sky
 */
public class MessageUtil {

	/**
	 * 返回消息类型：文本
	 */
	public static final String RES_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 返回消息类型：图片
	 */
	public static final String RES_MESSAGE_TYPE_IMAGE = "image";
	
	/**
	 * 返回消息类型：语音
	 */
	public static final String RES_MESSAGE_TYPE_VOICE = "voice";
	
	/**
	 * 返回消息类型：视频
	 */
	public static final String RES_MESSAGE_TYPE_VIDEO = "video";
	
	/**
	 * 返回消息类型：音乐
	 */
	public static final String RES_MESSAGE_TYPE_MUSIC = "music";

	/**
	 * 返回消息类型：图文
	 */
	public static final String RES_MESSAGE_TYPE_NEWS = "news";
	
	/**
	 * 请求消息类型：文本
	 */
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 请求消息类型：图片
	 */
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

	/**
	 * 请求消息类型：链接
	 */
	public static final String REQ_MESSAGE_TYPE_LINK = "link";

	/**
	 * 请求消息类型：地理位置
	 */
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

	/**
	 * 请求消息类型：音频
	 */
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";

	/**
	 * 请求消息类型：推送
	 */
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";

	/**
	 * 事件类型：subscribe(订阅)
	 */
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

	/**
	 * 事件类型：unsubscribe(取消订阅)
	 */
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

	/**
	 * 事件类型：CLICK(自定义菜单点击拉取消息事件)
	 */
	public static final String EVENT_TYPE_CLICK = "CLICK";

	/**
	 * 事件类型，SCAN
	 */
	public static final String EVENT_TYPE_SCAN = "SCAN";
	/**
	 * 事件类型，LOCATION
	 */
	public static final String EVENT_TYPE_LOCATION = "LOCATION";
	/**
	 * 事件类型：VIEW
	 */
	public static final String EVENT_TYPE_VIEW = "VIEW";
	/**
	 * 解析微信发来的请求（XML）
	 * 
	 * @param request 请求
	 * @return 返回
	 * @throws Exception 异常
	 */
	public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
		// 将解析结果存储在HashMap中
		Map<String, String> map = new HashMap<>();

		// 从request中取得输入流
		InputStream inputStream = request.getInputStream();
		// 读取输入流
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		// 得到xml根元素
		Element root = document.getRootElement();
		// 得到根元素的所有子节点
		List<Element> elementList = root.elements();

		// 遍历所有子节点
		for (Element e : elementList){
			map.put(e.getName(), e.getText());
		}

		// 释放资源
		inputStream.close();
		return map;
	}
	
	/**
	 * 基本消息对象转换成xml
	 * 
	 * @param baseResMessage 文本消息对象
	 * @return xml
	 */
	public static String messageToXml(BaseResMessage baseResMessage) {
		xstream.alias("xml", baseResMessage.getClass());
		return xstream.toXML(baseResMessage);
	}

	/**
	 * 文本消息对象转换成xml
	 * 
	 * @param textResMessage 文本消息对象
	 * @return xml
	 */
	public static String messageToXml(TextResMessage textResMessage) {
		xstream.alias("xml", textResMessage.getClass());
		return xstream.toXML(textResMessage);
	}

	/**
	 * 图片消息对象转换成xml
	 * 
	 * @param imageResMessage 图片消息对象
	 * @return xml
	 */
	public static String messageToXml(ImageResMessage imageResMessage) {
		xstream.alias("xml", imageResMessage.getClass());
		return xstream.toXML(imageResMessage);
	}

	/**
	 * 语音消息对象转换成xml
	 * 
	 * @param voiceResMessage 语音消息对象
	 * @return xml
	 */
	public static String messageToXml(VoiceResMessage voiceResMessage) {
		xstream.alias("xml", voiceResMessage.getClass());
		return xstream.toXML(voiceResMessage);
	}

	/**
	 * 视频消息对象转换成xml
	 * 
	 * @param videoResMessage 视频消息对象
	 * @return xml
	 */
	public static String messageToXml(VideoResMessage videoResMessage) {
		xstream.alias("xml", videoResMessage.getClass());
		return xstream.toXML(videoResMessage);
	}

	/**
	 * 音乐消息对象转换成xml
	 * 
	 * @param musicResMessage 音乐消息对象
	 * @return xml
	 */
	public static String messageToXml(MusicResMessage musicResMessage) {
		xstream.alias("xml", musicResMessage.getClass());
		return xstream.toXML(musicResMessage);
	}

	/**
	 * 图文消息对象转换成xml
	 * 
	 * @param newsResMessage 图文消息对象
	 * @return xml
	 */
	public static String messageToXml(NewsResMessage newsResMessage) {
		xstream.alias("xml", newsResMessage.getClass());
		xstream.alias("item", Article.class);
		return xstream.toXML(newsResMessage);
	}

	/**
	 * 扩展xstream，使其支持CDATA块
	 * 
	 */
	private static XStream xstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
				}

				protected void writeText(QuickWriter writer, String text) {
					writer.write("<![CDATA[");
					writer.write(text);
					writer.write("]]>");
				}
			};
		}
	});
}