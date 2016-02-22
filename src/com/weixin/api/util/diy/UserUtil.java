package com.weixin.api.util.diy;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.weixin.api.pojo.WeixinGroup;
import com.weixin.api.pojo.WeixinUserInfo;
import com.weixin.api.pojo.WeixinUserList;

/**
 * 微信用户工具类
 *
 */
public class UserUtil {
	private static Logger log = LoggerFactory.getLogger(UserUtil.class);
	
	/**
	 * 设置备注名
	 * @param accessToken 接口访问凭证
	 * @param openId 用户标识
	 * @param remark 备注名
	 * @return 设置结果 0 成功  其他失败
	 */
	public static boolean updateRemark(String accessToken, String openId,String remark){
		boolean result = false;
		// 拼接请求地址
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=ACCESS_TOKEN";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
		// 需要提交的json数据
		String jsonData = "{\"openid\": \"%s\", \"remark\": \"%s\"}";
		// 修改备注名
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "POST", String.format(jsonData, openId, remark));

		if (jsonObject != null) {
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (errorCode == 0) {
				result = true;
				log.info("设置备注名成功 errcode:{} errmsg:{}", errorCode, errorMsg);
			} else {
				log.error("设置备注名失败 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return result;
	}
	/**
	 * 获取用户信息
	 * 
	 * @param accessToken 接口访问凭证
	 * @param openId 用户标识
	 * @return WeixinUserInfo
	 */
	public static WeixinUserInfo getUserInfo(String accessToken, String openId) {
		WeixinUserInfo weixinUserInfo = null;
		// 拼接请求地址
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		// 获取用户信息
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

		if (jsonObject != null) {
			try {
				weixinUserInfo = new WeixinUserInfo();
				// 用户的标识
				weixinUserInfo.setOpenId(jsonObject.getString("openid"));
				// 关注状态（1是关注，0是未关注），未关注时获取不到其余信息
				weixinUserInfo.setSubscribe(jsonObject.getInt("subscribe"));
				// 用户关注时间
				weixinUserInfo.setSubscribeTime(jsonObject.getString("subscribe_time"));
				// 昵称
				weixinUserInfo.setNickname(jsonObject.getString("nickname"));
				// 用户的性别（1是男性，2是女性，0是未知）
				weixinUserInfo.setSex(jsonObject.getInt("sex"));
				// 用户所在国家
				weixinUserInfo.setCountry(jsonObject.getString("country"));
				// 用户所在省份
				weixinUserInfo.setProvince(jsonObject.getString("province"));
				// 用户所在城市
				weixinUserInfo.setCity(jsonObject.getString("city"));
				// 用户的语言，简体中文为zh_CN
				weixinUserInfo.setLanguage(jsonObject.getString("language"));
				// 用户头像
				weixinUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
			} catch (Exception e) {
				if (0 == weixinUserInfo.getSubscribe()) {
					log.error("用户{}已取消关注", weixinUserInfo.getOpenId());
				} else {
					int errorCode = jsonObject.getInt("errcode");
					String errorMsg = jsonObject.getString("errmsg");
					log.error("获取用户信息失败 errcode:{} errmsg:{}", errorCode, errorMsg);
				}
			}
		}
		return weixinUserInfo;
	}

	/**
	 * 获取关注者列表
	 * 
	 * @param accessToken 调用接口凭证
	 * @param nextOpenId 第一个拉取的openId，不填默认从头开始拉取
	 * @return WeixinUserList
	 */
	@SuppressWarnings( { "unchecked" })
	public static WeixinUserList getUserList(String accessToken, String nextOpenId) {
		WeixinUserList weixinUserList = null;

		if (null == nextOpenId)
			nextOpenId = "";

		// 拼接请求地址
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("NEXT_OPENID", nextOpenId);
		// 获取关注者列表
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
		// 如果请求成功
		if (jsonObject != null) {
			try {
				weixinUserList = new WeixinUserList();
				weixinUserList.setTotal(jsonObject.getInt("total"));
				weixinUserList.setCount(jsonObject.getInt("count"));
				weixinUserList.setNextOpenId(jsonObject.getString("next_openid"));
				JSONObject dataObject = (JSONObject) jsonObject.get("data");
				weixinUserList.setOpenIdList(JSONArray.toList(dataObject.getJSONArray("openid"), List.class));
			} catch (JSONException e) {
				weixinUserList = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				log.error("获取关注者列表失败 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return weixinUserList;
	}
//------------------------------------------------------------------------
//============以下有关分组====================
//------------------------------------------------------------------------
	/**
	 * 查询分组
	 * 
	 * @param accessToken 调用接口凭证
	 */
	@SuppressWarnings( { "unchecked" })
	public static List<WeixinGroup> getGroups(String accessToken) {
		List<WeixinGroup> weixinGroupList = null;
		// 拼接请求地址
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=ACCESS_TOKEN";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
		// 查询分组
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

		if (jsonObject != null) {
			try {
				weixinGroupList = JSONArray.toList(jsonObject.getJSONArray("groups"), WeixinGroup.class);
			} catch (JSONException e) {
				weixinGroupList = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				log.error("查询分组失败 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return weixinGroupList;
	}

	/**
	 * 创建分组
	 * 
	 * @param accessToken 接口访问凭证
	 * @param groupName 分组名称
	 * @return
	 */
	public static WeixinGroup createGroup(String accessToken, String groupName) {
		WeixinGroup weixinGroup = null;
		// 拼接请求地址
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
		// 需要提交的json数据
		String jsonData = "{\"group\" : {\"name\" : \"%s\"}}";
		// 创建分组
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "POST", String.format(jsonData, groupName));

		if (jsonObject != null) {
			try {
				weixinGroup = new WeixinGroup();
				weixinGroup.setId(jsonObject.getJSONObject("group").getInt("id"));
				weixinGroup.setName(jsonObject.getJSONObject("group").getString("name"));
			} catch (JSONException e) {
				weixinGroup = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				log.error("创建分组失败 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return weixinGroup;
	}

	/**
	 * 修改分组名
	 * 
	 * @param accessToken 接口访问凭证
	 * @param groupId 分组id
	 * @param groupName 修改后的分组名
	 * @return true | false
	 */
	public static boolean updateGroup(String accessToken, int groupId, String groupName) {
		boolean result = false;
		// 拼接请求地址
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=ACCESS_TOKEN";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
		// 需要提交的json数据
		String jsonData = "{\"group\": {\"id\": %d, \"name\": \"%s\"}}";
		// 修改分组名
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "POST", String.format(jsonData, groupId, groupName));

		if (jsonObject != null) {
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (errorCode == 0) {
				result = true;
				log.info("修改分组名成功 errcode:{} errmsg:{}", errorCode, errorMsg);
			} else {
				log.error("修改分组名失败 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return result;
	}

	/**
	 * 移动用户分组
	 * 
	 * @param accessToken 接口访问凭证
	 * @param openId 用户标识
	 * @param groupId 分组id
	 * @return true | false
	 */
	public static boolean updateMemberGroup(String accessToken, String openId, int groupId) {
		boolean result = false;
		// 拼接请求地址
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=ACCESS_TOKEN";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
		// 需要提交的json数据
		String jsonData = "{\"openid\":\"%s\",\"to_groupid\":%d}";
		// 移动用户分组
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "POST", String.format(jsonData, openId, groupId));

		if (jsonObject != null) {
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (errorCode == 0) {
				result = true;
				log.info("移动用户分组成功 errcode:{} errmsg:{}", errorCode, errorMsg);
			} else {
				log.error("移动用户分组失败 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// 获取接口访问凭证
		String accessToken = CommonUtil.getAccessToken("APPID", "APPSECRET").getAccessToken();
		
		/**
		 * 获取用户信息
		 */
		WeixinUserInfo user = getUserInfo(accessToken, "oEdzejiHCDqafJbz4WNJtWTMbDcE");
		System.out.println("OpenID：" + user.getOpenId());
		System.out.println("关注状态：" + user.getSubscribe());
		System.out.println("关注时间：" + user.getSubscribeTime());
		System.out.println("昵称：" + user.getNickname());
		System.out.println("性别：" + user.getSex());
		System.out.println("国家：" + user.getCountry());
		System.out.println("省份：" + user.getProvince());
		System.out.println("城市：" + user.getCity());
		System.out.println("语言：" + user.getLanguage());
		System.out.println("头像：" + user.getHeadImgUrl());

		/**
		 * 获取关注者列表
		 */
		WeixinUserList weixinUserList = getUserList(accessToken, "");
		System.out.println("总关注用户数：" + weixinUserList.getTotal());
		System.out.println("本次获取用户数：" + weixinUserList.getCount());
		System.out.println("OpenID列表：" + weixinUserList.getOpenIdList().toString());
		System.out.println("next_openid：" + weixinUserList.getNextOpenId());

		/**
		 * 查询分组
		 */
		List<WeixinGroup> groupList = getGroups(accessToken);
		// 循环输出各分组信息
		for (WeixinGroup group : groupList) {
			System.out.println(String.format("ID：%d 名称：%s 用户数：%d", group.getId(), group.getName(), group.getCount()));
		}

		/**
		 * 创建分组
		 */
		WeixinGroup group = createGroup(accessToken, "公司员工");
		System.out.println(String.format("成功创建分组：%s id：%d", group.getName(), group.getId()));

		/**
		 * 修改分组名
		 */
		updateGroup(accessToken, 100, "同事");

		/**
		 * 移动用户分组
		 */
		updateMemberGroup(accessToken, "oEdzejiHCDqafJbz4WNJtWTMbDcE", 100);
	}
}
