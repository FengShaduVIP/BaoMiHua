package com.baomihua.Utils;

import com.baomihua.entity.BmhOrderManageEntity;
import com.baomihua.utils.DateUtils;

import java.util.HashMap;
import java.util.Map;

public class ToEntityObject {


    public static BmhOrderManageEntity toOrderObj(String[] str){
        BmhOrderManageEntity obj = new BmhOrderManageEntity();
        Map<String,Object> map = arrayToMap(str);
        if(map.containsKey("奖项")){
            obj.setPriceNum(map.get("奖项")+"");
        }else{
            obj.setPriceNum(6+"");
        }
        if(map.containsKey("手机号")){
            obj.setPhoneNum(map.get("手机号")+"");
        }
        if(map.containsKey("地址")){
            obj.setOrderNum(map.get("地址")+"");
        }
        if(map.containsKey("姓名")){
            obj.setVipName(map.get("姓名")+"");
        }
        if(map.containsKey("次数")){
            Integer times = Integer.parseInt(map.get("次数")+"");
            obj.setAwardTimes(times);
        }else{
            obj.setAwardTimes(1);
        }
        obj.setCreateTime(DateUtils.getNowTimestamp());
        obj.setIsDel(0);
        return obj;
    }

    private static Map<String,Object> arrayToMap(String[] str){
        Map<String,Object> map = new HashMap();
        for (int i=1;i<str.length;i++){
            String []strData = str[i].split(":");
            if(strData.length>0){
                map.put(strData[0],strData[1]);
            }
        }
        return map;
    }
}
