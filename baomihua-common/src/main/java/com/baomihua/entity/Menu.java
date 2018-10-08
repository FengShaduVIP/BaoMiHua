package com.baomihua.entity;

/**
 * Created by BaoMi花 on 2018/10/8.
 */
/**
 * 微信菜单类
 * @author Damon
 */
public class Menu
{

    /* 定义名称与json中一致，不然解析名称对不上 */
    private MenuButton[] button;

    public MenuButton[] getButton()
    {
        return button;
    }

    public void setButton(MenuButton[] button)
    {
        this.button = button;
    }

}
