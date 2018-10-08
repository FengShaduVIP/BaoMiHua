package com.baomihua.utils.wx;

import com.baomihua.entity.LevelMenu;
import com.baomihua.entity.Menu;
import com.baomihua.entity.MenuButton;
import com.baomihua.entity.SubMenuButton;
import com.baomihua.utils.ConfigConstant;
import net.sf.json.JSONObject;
import org.apache.http.HttpException;

import java.io.IOException;

/**
 * Created by BaoMi花 on 2018/10/8.
 */
public class CreateMenuUtils {
    /**
     * 创建菜单
     * @param menu
     * @return
     */
    public boolean createMenu(){

        // 1、获取access_token
        //WeChatTokenService tWeChatTokenService = new WeChatTokenService();
        String tAccess_Token = null;//tWeChatTokenService.getToken("appid", "appsceret").getToken();

        // 2、组建菜单
        String tMenuJSON = JSONObject.fromObject(getMenu()).toString();

        // 3、请求调用
        String result = createMenubyHttps(tAccess_Token, tMenuJSON);

        System.out.println(result);

        return true;
    }

    /**
     * 定义菜单属性
     * @return
     */
    private Menu getMenu(){
        Menu menu = new Menu();
        // 建3个导航菜单
        LevelMenu tLevelMenuOne = new LevelMenu();
        tLevelMenuOne.setName("Damon");
        LevelMenu tLevelMenuTwo = new LevelMenu();
        tLevelMenuTwo.setName("Panou");
        LevelMenu tLevelMenuThree = new LevelMenu();
        tLevelMenuThree.setName("Papaw");

        // 第一个导航菜单的子菜单
        SubMenuButton tSubMenuButton_oneone = new SubMenuButton();
        tSubMenuButton_oneone.setType(ConfigConstant.WECHAT_MENU_TYPE_CLICK);
        tSubMenuButton_oneone.setName("play basketball");
        tSubMenuButton_oneone.setKey("11");

        SubMenuButton tSubMenuButton_onetwo = new SubMenuButton();
        tSubMenuButton_onetwo.setType(ConfigConstant.WECHAT_MENU_TYPE_CLICK);
        tSubMenuButton_onetwo.setName("swimming");
        tSubMenuButton_onetwo.setKey("12");

        // 加入导航菜单
        tLevelMenuOne.setSub_button(new SubMenuButton[]
                { tSubMenuButton_oneone, tSubMenuButton_onetwo });

        // 第二 个导航菜单的子菜单
        SubMenuButton tSubMenuButton_twoone = new SubMenuButton();
        tSubMenuButton_twoone.setType(ConfigConstant.WECHAT_MENU_TYPE_CLICK);
        tSubMenuButton_twoone.setName("watching TV");
        tSubMenuButton_twoone.setKey("21");

        SubMenuButton tSubMenuButton_twotwo = new SubMenuButton();
        tSubMenuButton_twotwo.setType(ConfigConstant.WECHAT_MENU_TYPE_CLICK);
        tSubMenuButton_twotwo.setName("play games");
        tSubMenuButton_twotwo.setKey("22");

        SubMenuButton tSubMenuButton_twothree = new SubMenuButton();
        tSubMenuButton_twothree.setType(ConfigConstant.WECHAT_MENU_TYPE_CLICK);
        tSubMenuButton_twothree.setName("shopping");
        tSubMenuButton_twothree.setKey("23");

        // 加入导航菜单
        tLevelMenuTwo.setSub_button(new SubMenuButton[]
                { tSubMenuButton_twoone, tSubMenuButton_twotwo, tSubMenuButton_twothree });

        // 第三个导航菜单的子菜单
        SubMenuButton tSubMenuButton_threeone = new SubMenuButton();
        tSubMenuButton_threeone.setType(ConfigConstant.WECHAT_MENU_TYPE_CLICK);
        tSubMenuButton_threeone.setName("cring");
        tSubMenuButton_threeone.setKey("31");

        SubMenuButton tSubMenuButton_threetwo = new SubMenuButton();
        tSubMenuButton_threetwo.setType(ConfigConstant.WECHAT_MENU_TYPE_CLICK);
        tSubMenuButton_threetwo.setName("laughing");
        tSubMenuButton_threetwo.setKey("32");

        // 加入导航菜单
        tLevelMenuThree.setSub_button(new SubMenuButton[]
                { tSubMenuButton_threeone, tSubMenuButton_threetwo });

        menu.setButton(new MenuButton[]
                { tLevelMenuOne, tLevelMenuTwo, tLevelMenuThree });

        return menu;

    }


    /**
     * 请求调用，设置菜单信息
     * @param url
     * @param requestData
     * @return
     */
    private String createMenubyHttps(String access_token, String requestData){
        // 返回报文
        String strResp = "";
        String path = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + access_token;
        try{
            strResp = WeChatUtil.doHttpsPost(path, requestData);
        }
        catch (HttpException e){
            // 发生致命的异常，可能是协议不对或者返回的内容有问题
            System.out.println("Please check your provided http address!" + e);
            e.printStackTrace();
        }
        catch (IOException e){
            // 发生网络异常
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally{

        }
        return strResp;

    }
}
