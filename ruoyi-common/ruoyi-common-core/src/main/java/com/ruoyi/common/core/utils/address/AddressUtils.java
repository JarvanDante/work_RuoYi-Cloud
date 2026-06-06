package com.ruoyi.common.core.utils.address;


public class AddressUtils {


    public static String getRealAddressByIp(String ip) {

        if(ip==null||ip.length()==0){
            return "未知地址";
        }
        if("127.0.0.1".equals(ip) || "localhost".equalsIgnoreCase(ip)){
            return "内网IP";
        }
        if(ip.startsWith("192.168.") || ip.startsWith("10.") || ip.startsWith("172.")){
            return "内网IP";
        }

        return "未知地址";
    }
}
