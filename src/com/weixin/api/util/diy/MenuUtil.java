package com.weixin.api.util.diy;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.weixin.api.menu.Menu;

/**
 * 菜单的创建、查询、删除
 * 
 * @author 作者：张超
 * @date     创建时间：2015年4月15日 下午5:32:18
 * @version 1.0
 */
public class MenuUtil {
	private static Logger log = LoggerFactory.getLogger(MenuUtil.class);
	/*自定义菜单多种类型按钮,注意区分大小写*/
	//-------常用类型
	//1、click：点击推事件
	public static String  MENU_TYPE_CLICK = "click";
	//2、view：跳转URL
	public static String  MENU_TYPE_VIEW = "view";
	//-------新增类型
	//3、scancode_push：扫码推事件
	public static String  MENU_TYPE_SCANCODE_PUSH = "scancode_push";
	//4、scancode_waitmsg：扫码推事件且弹出“消息接收中”提示框
	public static String  MENU_TYPE_SCANCODE_WAITMSG = "scancode_waitmsg";
	//5、pic_sysphoto：弹出系统拍照发图
	public static String  MENU_TYPE_PIC_SYSPHOTO = "pic_sysphoto";
	//6、pic_photo_or_album：弹出拍照或者相册发图
	public static String  MENU_TYPE_PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
	//7、pic_weixin：弹出微信相册发图器
	public static String  MENU_TYPE_PIC_WEIXIN = "pic_weixin";
	//8、location_select：弹出地理位置选择器
	public static String  MENU_TYPE_LOCATION_SELECT = "location_select";
	
    /**
     * 创建菜单
     *
     * @param menu 菜单实例
     * @param accessToken 有效的access_token
     * @return 0表示成功，其他值表示失败
     * 	
     */
    public static boolean createMenu(Menu menu, String accessToken){
        boolean result = false;
        // 菜单创建 限100（次/天）
        String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
       
        // 拼装创建菜单的url
        String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
        // 将菜单对象转换成json字符串
        String jsonMenu = JSONObject.fromObject(menu).toString();
        // 发起post请求创建菜单
        JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", jsonMenu);

        if (jsonObject != null) {
        	int errorCode = jsonObject.getInt("errcode");
        	String errorMsg = jsonObject.getString("errmsg");
            if (errorCode == 0) {
                result = true;
            }else{
            	result = false;
            	log.error("创建菜单失败 errcode:{} errmsg:{}",errorCode,errorMsg);
            }
        }

        return result;
    }
    
    /**
     * 查询菜单
     *
     * @param accessToken 凭证
     * @return 正确的Json返回结果:
	 *	{"menu":{"button":[{"type":"click","name":"今日歌曲","key":"V1001_TODAY_MUSIC","sub_button":[]},
	 *								{"type":"click","name":"歌手简介","key":"V1001_TODAY_SINGER","sub_button":[]},
	 *								{"name":"菜单","sub_button":[
	 *									{"type":"view","name":"搜索","url":"http://www.soso.com/","sub_button":[]},
	 *									{"type":"view","name":"视频","url":"http://v.qq.com/","sub_button":[]},
	 *									{"type":"click","name":"赞一下我们","key":"V1001_GOOD","sub_button":[]}
	 *									]}
	 *								]
	 *					}
	 *	}
     */
    public static String getMenu(String accessToken)throws Exception{
        String result = null;

        //菜单查询 限1000（次/天）
        String menu_get_url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
  
        
        // 拼装查询菜单的url
        String url = menu_get_url.replace("ACCESS_TOKEN", accessToken);
        // 发起get请求查询菜单
        JSONObject jsonObject = CommonUtil.httpsRequest(url, "GET", null);

        if (jsonObject != null) {
        	result = jsonObject.toString();
        }

        return result;
    }
    
    /**
     * 删除菜单
     * @param accessToken 凭证
     * @return true 成功 false 失败
     */
    public static boolean deleteMenu(String accessToken){
    	boolean result = false;
        //菜单删除 限100（次/天）
        String menu_delete_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
        
    	String requestUrl = menu_delete_url.replace("ACCESS_TOKEN", accessToken);
    	//发起get请求删除菜单
    	JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
    	
    	if(jsonObject != null){
    		int errorCode = jsonObject.getInt("errcode");
        	String errorMsg = jsonObject.getString("errmsg");//正确返回{"errcode":0,"errmsg":"ok"}
        	if (errorCode == 0) {
                result = true;
            }else{
            	result = false;
            	log.error("删除菜单失败 errcode:{} errmsg:{}",errorCode,errorMsg);
            }
    	}
    	return result;
    }
}
