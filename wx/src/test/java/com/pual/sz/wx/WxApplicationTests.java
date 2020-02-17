package com.pual.sz.wx;

import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
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


    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     */
    @Test
    public void test(){
        NumberOf1(2147483647);
        NumberOf1(-2147483648);
//        System.out.println(~5);
//        System.out.println(Integer.MAX_VALUE+"   "+Integer.MIN_VALUE);
    }


    public int NumberOf1(int n) {
        int result = 0;
        if( n == 0) return result;
        if(n > 0) {
            do {
                if (n % 2 == 1) result++;
                n = n / 2;
                if (n == 1) {
                    result++;
                }
            } while (n / 2 != 0);
        }else {
            n = ~n;
            do {
                if (n % 2 == 1) result++;
                System.out.print(n % 2);
                n = n / 2;
                if (n == 1) {
                    result++;
                }
            } while (n / 2 != 0);
            result = 32 -result;
        }
        return result;
    }


    public int RectCover(int target) {
        if(target == 0)
            return 0;
        else if(target == 1) {
            return 1;
        }else if(target == 2) {
            return 2;
        }else {
            return RectCover(target-1)+RectCover(target-2);
        }
    }

}
