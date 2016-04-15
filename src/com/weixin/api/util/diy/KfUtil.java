package com.weixin.api.util.diy;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.weixin.api.message.res.Article;
import com.weixin.api.message.res.Music;
import com.weixin.api.pojo.Kf;

/**
 * 客服工具类
 *
 */
public class KfUtil {
	private static Logger log = LoggerFactory.getLogger(KfUtil.class);
	/**
     * 添加客服帐号
     *
     * @param kf 客服实例
     * @param accessToken 有效的access_token
     * @return 0表示成功，其他值表示失败
     */
    public static boolean createKf(Kf kf, String accessToken){
        boolean result = false;
        String add_url = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN";
        // 拼装创建客服的url
        String url = add_url.replace("ACCESS_TOKEN", accessToken);
        // 将客服对象转换成json字符串
        String jsonMenu = JSONObject.fromObject(kf).toString();
        // 发起post请求创建客服
        JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", jsonMenu);

        if (jsonObject != null) {
        	int errorCode = jsonObject.getInt("errcode");
        	String errorMsg = jsonObject.getString("errmsg");
            if (errorCode == 0) {
                result = true;
            }else{
            	result = false;
            	log.error("创建客服失败 errcode:{} errmsg:{}",errorCode,errorMsg);
            }
        }

        return result;
    }
    
	/**
     * 修改客服帐号
     *
     * @param kf 客服实例
     * @param accessToken 有效的access_token
     * @return 0表示成功，其他值表示失败
     */
    public static boolean updateKf(Kf kf, String accessToken){
        boolean result = false;
        String update_url = "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=ACCESS_TOKEN";
        // 拼装修改客服的url
        String url = update_url.replace("ACCESS_TOKEN", accessToken);
        // 将客服对象转换成json字符串
        String jsonMenu = JSONObject.fromObject(kf).toString();
        // 发起post请求修改客服
        JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", jsonMenu);

        if (jsonObject != null) {
        	int errorCode = jsonObject.getInt("errcode");
        	String errorMsg = jsonObject.getString("errmsg");
            if (errorCode == 0) {
                result = true;
            }else{
            	result = false;
            	log.error("修改客服失败 errcode:{} errmsg:{}",errorCode,errorMsg);
            }
        }

        return result;
    }
    
	/**
     * 删除客服帐号
     *
     * @param kf 客服实例
     * @param accessToken 有效的access_token
     * @return 0表示成功，其他值表示失败
     */
    public static boolean delKf(Kf kf, String accessToken){
        boolean result = false;
        String update_url = "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=ACCESS_TOKEN";
        // 拼装删除客服的url
        String url = update_url.replace("ACCESS_TOKEN", accessToken);
        // 将客服对象转换成json字符串
        String jsonMenu = JSONObject.fromObject(kf).toString();
        // 发起post请求删除客服
        JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", jsonMenu);

        if (jsonObject != null) {
        	int errorCode = jsonObject.getInt("errcode");
        	String errorMsg = jsonObject.getString("errmsg");
            if (errorCode == 0) {
                result = true;
            }else{
            	result = false;
            	log.error("删除客服失败 errcode:{} errmsg:{}",errorCode,errorMsg);
            }
        }

        return result;
    }
    /**
     * 获取所有客服账号
     *
     * @param accessToken 凭证
     * @return 返回的json字符串
     */
    public static String getKfList(String accessToken)throws Exception{
        String result = null;
        String get_url = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=ACCESS_TOKEN";
        // 拼装获取客服基本信息的url
        String url = get_url.replace("ACCESS_TOKEN", accessToken);
        // 发起get请求获取客服基本信息
        JSONObject jsonObject = CommonUtil.httpsRequest(url, "GET", null);

        if (jsonObject != null) {
        	result = jsonObject.toString();
        }

        return result;
    }
    /**
     * 获取在线客服接待信息
     * 开发者利用本接口提供的信息，结合客服基本信息，可以开发例如“指定客服接待”等功能；
     * 结合会话记录，可以开发”在线客服实时服务质量监控“等功能
     * @param accessToken 凭证
     * @return 在线客服信息的json字符串
     * @throws Exception
     */
    public static String getOnlineKfList(String accessToken)throws Exception{
        String result = null;
        String get_url = "https://api.weixin.qq.com/cgi-bin/customservice/getonlinekflist?access_token=ACCESS_TOKEN";
        // 拼装获取在线客服接待信息
        String url = get_url.replace("ACCESS_TOKEN", accessToken);
        // 发起get请求获取在线客服接待信息
        JSONObject jsonObject = CommonUtil.httpsRequest(url, "GET", null);

        if (jsonObject != null) {
        	result = jsonObject.toString();
        }

        return result;
    }
	/**
	 * 组装文本客服消息
	 * 
	 * @param openId 消息发送对象
	 * @param content 文本消息内容
	 * @return 组装好的json格式文本消息
	 */
	public static String makeTextCustomMessage(String openId, String content) {
		// 对消息内容中的双引号进行转义
		content = content.replace("\"", "\\\"");
		String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"text\",\"text\":{\"content\":\"%s\"}}";
		return String.format(jsonMsg, openId, content);
	}
	/**
	 * 组装包含客服信息的文本客服消息
	 *
	 * @param openId 消息发送对象
	 * @param content 文本消息内容
	 * @param kfAccount 客服帐号
	 * @return 组装好的json文本消息
	 */
	public static String makeTextCustomMessage(String openId, String content,String kfAccount) {
		// 对消息内容中的双引号进行转义
		content = content.replace("\"", "\\\"");
		String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"text\",\"text\":{\"content\":\"%s\"},\"customservice\":{\"kf_account\": \"%s\"}}";
		return String.format(jsonMsg, openId, content,kfAccount);
	}

	/**
	 * 组装图片客服消息
	 * 
	 * @param openId 消息发送对象
	 * @param mediaId 媒体文件id
	 * @return 组装好的json图片消息
	 */
	public static String makeImageCustomMessage(String openId, String mediaId) {
		String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"image\",\"image\":{\"media_id\":\"%s\"}}";
		return String.format(jsonMsg, openId, mediaId);
	}
	/**
	 * 组装包含客服信息的图片客服消息
	 *
	 * @param openId 消息发送对象
	 * @param mediaId 媒体文件id
	 * @param kfAccount 客服帐号
	 * @return 组装好的json图片消息
	 */
	public static String makeImageCustomMessage(String openId, String mediaId,String kfAccount) {
		String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"image\",\"image\":{\"media_id\":\"%s\"},\"customservice\":{\"kf_account\": \"%s\"}}";
		return String.format(jsonMsg, openId, mediaId, kfAccount);
	}
	/**
	 * 组装语音客服消息
	 * 
	 * @param openId 消息发送对象
	 * @param mediaId 媒体文件id
	 * @return 组装好的json语音消息
	 */
	public static String makeVoiceCustomMessage(String openId, String mediaId) {
		String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"voice\",\"voice\":{\"media_id\":\"%s\"}}";
		return String.format(jsonMsg, openId, mediaId);
	}
    /**
     * 组装包含客服信息的语音客服消息
     *
     * @param openId 消息发送对象
     * @param mediaId 媒体文件id
     * @param kfAccount 客服帐号
     * @return 组装好的json语音消息
     */
    public static String makeVoiceCustomMessage(String openId, String mediaId, String kfAccount) {
        String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"voice\",\"voice\":{\"media_id\":\"%s\"},\"customservice\":{\"kf_account\": \"%s\"}}";
        return String.format(jsonMsg, openId, mediaId, kfAccount);
    }
    /**
     * 组装视频客服消息
     *
     * @param openId 消息发送对象
     * @param mediaId 媒体文件id
     * @param thumbMediaId 视频消息缩略图的媒体id
     * @return 组装好的json视频客服消息
     */
    public static String makeVideoCustomMessage(String openId, String mediaId, String thumbMediaId) {
        String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"video\",\"video\":{\"media_id\":\"%s\",\"thumb_media_id\":\"%s\"}}";
        return String.format(jsonMsg, openId, mediaId, thumbMediaId);
    }
    /**
     * 组装包含客服信息的视频客服消息
     *
     * @param openId 消息发送对象
     * @param mediaId 媒体文件id
     * @param thumbMediaId 视频消息缩略图的媒体id
     * @param kfAccount 客服帐号
     * @return 组装好的json视频客服消息
     */
    public static String makeVideoCustomMessage(String openId, String mediaId, String thumbMediaId,String kfAccount) {
        String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"video\",\"video\":{\"media_id\":\"%s\",\"thumb_media_id\":\"%s\"},\"customservice\":{\"kf_account\": \"%s\"}}";
        return String.format(jsonMsg, openId, mediaId, thumbMediaId, kfAccount);
    }

	/**
	 * 组装音乐客服消息
	 *
	 * @param openId 消息发送对象
	 * @param music 音乐对象
	 * @return 组装好的json音乐客服信息
	 */
	public static String makeMusicCustomMessage(String openId, Music music) {
		String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"music\",\"music\":%s}";
		jsonMsg = String.format(jsonMsg, openId, JSONObject.fromObject(music).toString());
		// 将jsonMsg中的thumbmediaid替换为thumb_media_id
		jsonMsg = jsonMsg.replace("humbmediaid", "thumb_media_id");
		return jsonMsg;
	}
	/**
	 * 组装音乐客服消息
	 *
	 * @param openId 消息发送对象
	 * @param music 音乐对象
     * @param kfAccount 客服帐号
	 * @return 组装好的json音乐客服信息
	 */
	public static String makeMusicCustomMessage(String openId, Music music, String  kfAccount) {
		String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"music\",\"music\":%s,\"customservice\":{\"kf_account\": \"%s\"}}";
		jsonMsg = String.format(jsonMsg, openId, JSONObject.fromObject(music).toString(),kfAccount);
		// 将jsonMsg中的thumbmediaid替换为thumb_media_id
		jsonMsg = jsonMsg.replace("thumbmediaid", "thumb_media_id");
		return jsonMsg;
	}

	/**
	 * 组装图文客服消息
	 * 
	 * @param openId 消息发送对象
	 * @param articleList 图文消息列表
	 * @return 组装好的json图片客服消息
	 */
	public static String makeNewsCustomMessage(String openId, List<Article> articleList) {
		String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"news\",\"news\":{\"articles\":%s}}";
		jsonMsg = String.format(jsonMsg, openId, JSONArray.fromObject(articleList).toString().replaceAll("\"", "\\\""));
		// 将jsonMsg中的picUrl替换为picurl
		jsonMsg = jsonMsg.replace("picUrl", "picurl");
		return jsonMsg;
	}
	/**
	 * 组装图文客服消息
	 *
	 * @param openId 消息发送对象
	 * @param articleList 图文消息列表
     * @param kfAccount 客服帐号
	 * @return 组装好的json图片客服消息
	 */
	public static String makeNewsCustomMessage(String openId, List<Article> articleList, String kfAccount) {
		String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"news\",\"news\":{\"articles\":%s},\"customservice\":{\"kf_account\": \"%s\"}}";
		jsonMsg = String.format(jsonMsg, openId, JSONArray.fromObject(articleList).toString().replaceAll("\"", "\\\""), kfAccount);
		// 将jsonMsg中的picUrl替换为picurl
		jsonMsg = jsonMsg.replace("picUrl", "picurl");
		return jsonMsg;
	}

	/**
	 * 发送客服消息
	 * 
	 * @param accessToken 接口访问凭证
	 * @param jsonMsg json格式的客服消息（包括touser、msgtype和消息内容）
	 * @return true | false
	 */
	public static boolean sendCustomMessage(String accessToken, String jsonMsg) {
		log.info("消息内容：{}", jsonMsg);
		boolean result = false;
		// 拼接请求地址
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
		// 发送客服消息
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "POST", jsonMsg);

		if (jsonObject != null) {
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (errorCode == 0) {
				result = true;
				log.info("客服消息发送成功 errcode:{} errmsg:{}", errorCode, errorMsg);
			} else {
				log.error("客服消息发送失败 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}

		return result;
	}

	public static void main(String args[]) {
//		// 获取接口访问凭证
//		String accessToken = CommonUtil.getAccessToken("APPID", "APPSECRET").getAccessToken();
//
//		/**
//		 * 发送客服消息（文本消息）
//		 */
//		// 组装文本客服消息
//		String jsonTextMsg = KfUtil.makeTextCustomMessage("oEdzejiHCDqafJbz4WNJtWTMbDcE", "点击查看<a href=\"http://blog.csdn.net/lyq8479\">柳峰的博客</a>");
//		// 发送客服消息
//        KfUtil.sendCustomMessage(accessToken, jsonTextMsg);
//
//		/**
//		 * 发送客服消息（图文消息）
//		 */
//		Article article1 = new Article();
//		article1.setTitle("微信上也能斗地主");
//		article1.setDescription("");
//		article1.setPicUrl("http://www.egouji.com/xiaoq/game/doudizhu_big.png");
//		article1.setUrl("http://resource.duopao.com/duopao/games/small_games/weixingame/Doudizhu/doudizhu.htm");
//		Article article2 = new Article();
//		article2.setTitle("傲气雄鹰\n80后不得不玩的经典游戏");
//		article2.setDescription("");
//		article2.setPicUrl("http://www.egouji.com/xiaoq/game/aoqixiongying.png");
//		article2.setUrl("http://resource.duopao.com/duopao/games/small_games/weixingame/Plane/aoqixiongying.html");
//		List<Article> list = new ArrayList<Article>();
//		list.add(article1);
//		list.add(article2);
//		// 组装图文客服消息
//		String jsonNewsMsg = KfUtil.makeNewsCustomMessage("oEdzejiHCDqafJbz4WNJtWTMbDcE", list);
//		// 发送客服消息
//        KfUtil.sendCustomMessage(accessToken, jsonNewsMsg);
	}
}
