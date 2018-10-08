package com.baomihua.entity;

/**
 * Created by BaoMi花 on 2018/10/8.
 */
/**
 * 导航菜单
 * @author Damon
 */
public class LevelMenu extends MenuButton
{

    /**
     * 包含多个子菜单 定义名称与json中一致，不然解析名称对不上
     */
    private SubMenuButton[] sub_button;

    public SubMenuButton[] getSub_button()
    {
        return sub_button;
    }

    public void setSub_button(SubMenuButton[] sub_button)
    {
        this.sub_button = sub_button;
    }


}
