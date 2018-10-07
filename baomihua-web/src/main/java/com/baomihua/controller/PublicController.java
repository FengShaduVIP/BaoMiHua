package com.baomihua.controller;

import com.baomihua.entity.BmhAwardLogEntity;
import com.baomihua.entity.BmhPrizeEntity;
import com.baomihua.service.BmhAwardLogService;
import com.baomihua.service.BmhOrderManageService;
import com.baomihua.service.BmhPrizeService;
import com.baomihua.service.WechatService;
import com.baomihua.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by BaoMi花 on 2018/9/30.
 */
@RequestMapping(value = { "/webpublic" })
@RestController
public class PublicController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PublicController.class);

    @Autowired
    private BmhOrderManageService bmhOrderManageService;

    @Autowired
    private BmhPrizeService bmhPrizeService;

    @Autowired
    private BmhAwardLogService bmhAwardLogService;


    @RequestMapping("/checkAwardTimes")
    public R checkAeardTimes(@RequestParam(value = "phoneNum") String phoneNum) {
        Map<String, Object> map = bmhOrderManageService.checkAeardTimes(phoneNum);
        return R.ok(map);
    }

    /**
     * 获取奖品列表
     * @param request
     * @return
     */
    @RequestMapping("/awardlist")
    public R queryAwardList(HttpServletRequest request) {

        List<BmhPrizeEntity> bmhPrizeList = bmhPrizeService.queryAwardList();
        String servicePath = "";
        Map<String, Object> listData = new HashMap<>();
        for (int i = 0; i < bmhPrizeList.size(); i++) {
            BmhPrizeEntity obj = bmhPrizeList.get(i);
            obj.setUserName(null);
            obj.setIsDel(null);
            obj.setCreateTime(null);
            obj.setUserId(null);
            String picUrl = servicePath + obj.getPicUrl();
            obj.setPicUrl(picUrl);
            obj.setId(getAwardSortName(obj.getSort()));
        }
        listData.put("list", bmhPrizeList);
        return R.ok(listData);
    }

    @RequestMapping("/awardLoglist")
    public R queryAwardLoglist(HttpServletRequest request) {
        Map<String, Object> returnMap = new HashMap<>();
        List<Map<String, Object>> listMap = new ArrayList<>();
        List<BmhAwardLogEntity> bmhList = bmhAwardLogService.queryAwardLoglist();
        String servicePath = "";
        for (int i = 0; i < bmhList.size(); i++) {
            BmhAwardLogEntity obj = bmhList.get(i);
            Map<String, Object> map = new HashMap<>();
            map.put("time", DateUtils.timeStamp2Date(obj.getCreateTime() + "", DateUtils.DATE_PATTERN));
            String phoneNum = obj.getPhoneNum();
            phoneNum = phoneNum.replaceAll("(\\d{3})\\d{5}(\\d{3})", "$1****$2");
            map.put("phoneNum", phoneNum);
            map.put("priceName", obj.getPriceName());
            listMap.add(map);
        }
        returnMap.put("list", listMap);
        return R.ok(returnMap);
    }

    /**
     * 微信接入
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/connect", method = {RequestMethod.GET, RequestMethod.POST})
    public void connectWeixin(HttpServletRequest request, HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        try {
            request.setCharacterEncoding("UTF-8");  //微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
            response.setCharacterEncoding("ISO-8859-1"); //在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8，原理同上；
            boolean isGet = request.getMethod().toLowerCase().equals("get");
            if (isGet) {
                String signature = request.getParameter("signature");// 微信加密签名
                String timestamp = request.getParameter("timestamp");// 时间戳
                String nonce = request.getParameter("nonce");// 随机数
                String echostr = request.getParameter("echostr");//随机字符串
                // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
                if (SignUtil.checkSignature(GenUtils.getConfig().getString("DNBX_TOKEN"), signature, timestamp, nonce)) {
                    LOGGER.info("Connect the weixin server is successful.");
                    response.getWriter().write(echostr);
                } else {
                    LOGGER.error("Failed to verify the signature!");
                }
            }else{
                String respMessage = "异常消息！";
                try {
                    respMessage = WechatService.weixinPost(request);
                    respMessage = new String(respMessage.getBytes(),"ISO-8859-1");
                    out.write(respMessage);
                    LOGGER.info("The request completed successfully");
                    LOGGER.info("to weixin server " + respMessage);
                } catch (Exception e) {
                    e.printStackTrace();
                    LOGGER.error("Failed to convert the message from weixin!");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            LOGGER.error("Connect the weixin server is error.");
        }finally{
            out.close();
        }
    }

    private String getAwardSortName(int sort){
        String sortName = "";
        switch (sort){
            case 1:
                sortName =  "一等奖";
                break;
            case 2:
                sortName =  "二等奖";
                break;
            case 3:
                sortName =  "三等奖";
                break;
            case 4:
                sortName =  "四等奖";
                break;
            case 5:
                sortName =  "五等奖";
                break;
            case 6:
                sortName =  "六等奖";
                break;
            case 7:
                sortName =  "七等奖";
                break;
            case 8:
                sortName =  "八等奖";
                break;
            default:
                sortName = "";
                break;
        }
        return sortName;
    }

}
