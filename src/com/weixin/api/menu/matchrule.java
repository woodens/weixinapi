package com.weixin.api.menu;

/**
 * 个性化菜单匹配规则
 * 匹配字段均可空，但不能全部为空，至少要有一个匹配信息是不为空的。
 *  country、province、city组成地区信息，将按照country、province、city的顺序进行验证，
 *  要符合地区信息表的内容。地区信息从大到小验证，小的可以不填，即若填写了省份信息，
 *  则国家信息也必填并且匹配，城市信息可以不填。 例如 “中国 广东省 广州市”、“中国 广东省”都是合法的地域信息，
 *  而“中国 广州市”则不合法，因为填写了城市信息但没有填写省份信息。
 * Created by 张超 on 2016/4/12.
 */
public class MatchRule {
    private String group_id;
    private String sex;
    private String country;
    private String province;
    private String city;
    private String client_platform_type;//客户端版本,当前只具体到系统型号：IOS(1), Android(2),Others(3)，不填则不做匹配
    /**
     * 1、简体中文 "zh_CN"  2、繁体中文TW "zh_TW"  3、繁体中文HK "zh_HK" 4、英文 "en"
     * 5、印尼 "id"  6、马来 "ms"  7、西班牙 "es"  8、韩国 "ko"
     * 9、意大利 "it"  10、日本 "ja" 11、波兰 "pl"  12、葡萄牙 "pt"
     * 13、俄国 "ru"  14、泰文 "th"  15、越南 "vi"  16、阿拉伯语 "ar"
     * 17、北印度 "hi"  18、希伯来 "he"  19、土耳其 "tr"  20、德语 "de"
     * 21、法语 "fr"*/
    private String language;

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getClient_platform_type() {
        return client_platform_type;
    }

    public void setClient_platform_type(String client_platform_type) {
        this.client_platform_type = client_platform_type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
