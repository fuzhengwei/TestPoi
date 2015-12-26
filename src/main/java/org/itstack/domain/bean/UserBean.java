package org.itstack.domain.bean;

/**
 * Created by fuzhengwei on 2015/12/26.
 * 测试类UserBean
 */
public class UserBean {

    private String provice;     //省份
    private String city;         //城市
    private String schoolname;  //学校
    private String name;         //姓名
    private String age;          //手机号
    private String mobile;       //手机号
    private String idcard;       //身份证

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
}
