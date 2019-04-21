package com.baomihua.controller;

import com.baomihua.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by BaoMi花 on 2018/9/30.
 */
@RequestMapping(value = { "/public" })
@Controller
public class UploadController {


    @ResponseBody
    @RequestMapping(value = "/upload",method= RequestMethod.POST)
    public R upload(HttpServletRequest request,
                         HttpServletResponse response,
                         @RequestParam("file")MultipartFile files){
        System.out.println("upload");
        Map<String, Object> data = new HashMap<String, Object>();
        String picWeb = ""; //图片保存名
        String name = files.getOriginalFilename();
        return R.ok();
    }



}
