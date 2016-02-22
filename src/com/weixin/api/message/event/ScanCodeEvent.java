package com.weixin.api.message.event;

/**
 * 扫码推事件的事件推送/扫码推事件且弹出“消息接收中”提示框的事件推送
 *
 */
public class ScanCodeEvent extends BaseEvent{
	//扫描信息
	private ScanCodeInfo ScanCodeInfo;
	public ScanCodeInfo getScanCodeInfo() {
		return ScanCodeInfo;
	}
	public void setScanCodeInfo(ScanCodeInfo scanCodeInfo) {
		ScanCodeInfo = scanCodeInfo;
	}
}
