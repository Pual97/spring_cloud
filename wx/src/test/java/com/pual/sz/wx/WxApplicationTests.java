package com.pual.sz.wx;

import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WxApplicationTests {

    @Autowired
    private WxMpService wxService;

    @Test
    public void contextLoads() throws WxErrorException {
        WxMenu wxMenu = new WxMenu();
        List<WxMenuButton> wxMenuButtons = new ArrayList<>();
        WxMenuButton wxMenuButton = new WxMenuButton();
        wxMenuButton.setName("加入昂司");
        wxMenuButton.setKey("JOIN_ANGSI");
        wxMenuButton.setType("click");
        wxMenuButtons.add(wxMenuButton);

        WxMenuButton wxMenuButton2 = new WxMenuButton();
        wxMenuButton2.setName("昂司是谁");
        wxMenuButton2.setKey("WHO_IS_ANGSI");
        wxMenuButton2.setType("click");
        wxMenuButtons.add(wxMenuButton2);

        WxMenuButton wxMenuButton3 = new WxMenuButton();
        wxMenuButton3.setName("生成海报");
        wxMenuButton3.setKey("GEN_POSTER");
        wxMenuButton3.setType("click");
        wxMenuButtons.add(wxMenuButton3);

        wxMenu.setButtons(wxMenuButtons);
        wxService.getMenuService().menuDelete();
        wxService.getMenuService().menuCreate(wxMenu);
//        {"button":[{"type":"click","name":"昂司是谁","key":"WHO_IS_ANGSI","sub_button":[]},
//            {"type":"click","name":"加入昂司","key":"JOIN_ANGSI","sub_button":[]},
//            {"type":"click","name":"生成海报","key":"GEN_POSTER","sub_button":[]}]}
//        WxMpMenu wxMpMenu = wxService.getMenuService().menuGet();
        System.out.println(1231);


    }

}
