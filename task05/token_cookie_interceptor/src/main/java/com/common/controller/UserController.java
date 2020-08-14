package com.common.controller;


import com.alibaba.fastjson.JSON;

import com.common.entity.User;
import com.common.mapper.UserMapper;
import com.common.tools.DesUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户信息管理
 */
@Controller
@RequestMapping(value = "/a")
public class UserController {
    private final  static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper userMapper;


    //列出数据表格
    //    设置listBooks页面(list第一种写法)
    @RequestMapping("/listBooks")
    public ModelAndView listBooks(){

        ModelAndView mav = new ModelAndView();
        mav.setViewName("listBooks");

        return mav;
    }

//    @RequestMapping("/insertUser0")
//    public String insertUser0(){
//        return "savepage";
//    }
    //    第二步：把下边的页面数据返回给后端，再跳转到listBooks页面
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user,HttpServletRequest request,HttpServletResponse response) throws Exception {

        if(user.getUsername().isEmpty() || user.getPassword().isEmpty()){
            logger.error("输入账号或密码不能为空！");
            return "listBooks";
        }
        User user1 = userMapper.findByUsername(user.getUsername(),user.getPassword());
        logger.info("findByUser: "+ JSON.toJSONString(user1));
        if(user1 == null){
            logger.error("账号不存在");
            return "listBooks";
        }else {
            int id = user1.getId();
            String idCard = "666222" + id + System.currentTimeMillis();

            DesUtil desUtil = new DesUtil();
            String token = desUtil.encrypt(idCard);
            Cookie cookie = new Cookie("uuid",token);
            cookie.setMaxAge(300);
            cookie.setPath("/");
            response.addCookie(cookie);
            logger.info("首次登录，设置了token和cookie");
        }


        return "updatepage";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public String logout(HttpServletRequest request,HttpServletResponse response){
        logger.info("准备退出");
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("uuid")){
                // 设置Cookie立即失效
                cookie.setMaxAge(0);
                /**
                 * 删除Cookie时，只设置maxAge=0将不能够从浏览器中删除cookie,
                 * 因为一个Cookie应当属于一个path与domain，所以删除时，Cookie的这两个属性也必须设置。
                 *
                 * 误区:刚开始时，我没有发现客户端发送到服务器端的cookie的path与domain值为空这个问题。
                 * 因为在登陆系统时，我设置了Cookie的path与domain属性的值,就误认为每次客户端请求时，都会把Cookie的
                 * 这两个属性也提交到服务器端，但系统并没有把path与domain提交到服务器端(提交过来的只有Cookie的key，value值)。
                 */
                // 重点是这里1,必须设置domain属性的值
//                cookie.setDomain(localhost);
                // 重点是这里2,必须设置path属性的值
                cookie.setPath("/");
                response.addCookie(cookie);

                logger.info("退出删除cookie");
                break;
            }
        }
        return "listBooks";
    }

}
