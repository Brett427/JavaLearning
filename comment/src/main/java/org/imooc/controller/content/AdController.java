package org.imooc.controller.content;


import org.imooc.Service.AdService;
import org.imooc.Dto.AdDto;
import org.imooc.Service.AdServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class AdController {
    @Autowired
    private AdService adservice;



    // 传递进来的参数addto 中元素的名字和表单控件中name 字段一致，就可以进行自动匹配。
    @RequestMapping("/add")
    public String add(AdDto adDto)
    {
        adservice.add(adDto);
        return "/content/adAdd";
    }
}
