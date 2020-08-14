package com.common.interceptor;


import com.common.entity.User;
import com.common.mapper.UserMapper;
import com.common.tools.DesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    private final static Logger logger = LoggerFactory.getLogger(MyInterceptor.class);
    private static long MAX_TIME = 60000;

    @Autowired
    UserMapper userMapper;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("执行了prehandle方法");


        Cookie[] cookies = request.getCookies();
        String token;
        String mycode = "";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("uuid")) {
                token = cookie.getValue();
                DesUtil desUtil = new DesUtil();
                logger.info("完整的token: " + desUtil.decrypt(token));
                mycode = desUtil.decrypt(token).substring(0, 6);

                String userIdString = desUtil.decrypt(token).substring(6, 7);
                logger.info("userIdString: "  + userIdString);
                int userId = Integer.parseInt(userIdString);
                User user = userMapper.findById(userId);

                if (user == null || !mycode.equals("666222")) {
                    logger.error("token存在但是不正确，删除该token");
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    request.getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp").forward(request, response);
                    return false;
                }

                String loginTimeString = desUtil.decrypt(token).substring(7, 20);
//                    logger.info("allstring : " + allstring);
//                    logger.info("allstring01 : " + allstring01);
                long currentTime01 = Long.parseLong(loginTimeString);
//                    logger.info("currentTime01 : "+ currentTime01);

                long currentTime02 = System.currentTimeMillis();
//                    logger.info("currentTime02 : "+ currentTime02);

                long timeInterval = currentTime02 - currentTime01;
                logger.info("timeInterval: " + timeInterval);

                if (timeInterval < MAX_TIME) {
                    logger.info("通过token，登录成功！");
//                    response.sendRedirect("updatepage");
                    request.getRequestDispatcher("/WEB-INF/jsp/updatepage.jsp").forward(request, response);
                    return false;
                } else {
                    logger.error("token存在且正确但失效，删除token");
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    return true;
                }
            }
        }

        logger.error("token不存在,首次登录请输入账号密码");
        return true;
    }
}
