package com.asyysy.asyysy_core.controller;


import com.asyysy.asyysy_core.common.wx.CheckoutUtil;
import com.asyysy.asyysy_core.model.WxMessage;
import com.asyysy.asyysy_core.model.WxReplyModel;
import com.asyysy.asyysy_core.service.WxMainService;
import com.asyysy.asyysy_core.service.WxReplyModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

@Controller
//@RestController
public class MainController {
    Logger logger = Logger.getLogger("MainController");
    @Autowired
    private WxMainService wxMainService;
    @Autowired
    private WxReplyModelService wxReplyModelService;
    @Autowired
    private Environment env;

    @RequestMapping(value = "index")
    public String index(@RequestParam Map<String,Object> params,HttpServletRequest request) throws  Exception{
        logger.info("==============================MainController===============params：" + params.toString());
        List<WxReplyModel> wxReplys =  wxReplyModelService.selectWxReplyModelList();
        request.setAttribute("list",wxReplys);
        logger.info(env.getProperty("wx_token"));
        return  "index";
    }

    @ResponseBody
    @RequestMapping(value = "test")
    public  Object aaaa(@RequestParam Map<String,Object> params){
        //String openId, String message, Integer type, Date date
        WxMessage wxMessage = new WxMessage("openId", "message" ,"allMessage","text", new Date());
        boolean result = wxMainService.inserWxInCharge(wxMessage);
        return result;
    }

}

