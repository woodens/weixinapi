package com.weixin.api.util.diy;

/**
 * @author 作者：张超
 * @date     创建时间：2015年7月9日 下午10:46:38
 * @version 1.0
 */
public class PayUtil {
	/**
	 * 设置支付成功后返回的结果
	 * @param return_code
	 * @param return_msg
	 * @return
	 */
	public static String setXML(String return_code, String return_msg) {
        return "<xml><return_code><![CDATA[" + return_code
                + "]]></return_code><return_msg><![CDATA[" + return_msg
                + "]]></return_msg></xml>";
	}
}
