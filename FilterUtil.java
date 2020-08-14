//package com.common.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class FilterUtil implements Filter{
//
//    @SuppressWarnings("unused")
//    private FilterConfig filterConfig;
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        this.filterConfig = filterConfig;
//        System.out.println("过滤器Filter初始化");
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response,
//                         FilterChain chain) throws IOException, ServletException {
//        if (!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)) {
//            throw new ServletException("FilterUtil just supports HTTP requests");
//        }
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        httpRequest.setCharacterEncoding(this.filterConfig.getInitParameter("encoding"));
//        httpResponse.setCharacterEncoding(this.filterConfig.getInitParameter("encoding"));
//        chain.doFilter(httpRequest, httpResponse);
//    }
//
////    @Override
////    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
////            throws IOException, ServletException {
////        // Filter的url-pattern设为/*拦截访问当前应用的所有请求
////
////        // 1.强制转换request和response
////        HttpServletRequest request = (HttpServletRequest) req;
////        HttpServletResponse response = (HttpServletResponse) res;
////        // 2.实现业务逻辑
////        // 2.1 首先获取存在session中的user对象.
////        // 这一步是因为：如果用户在登陆后,继续点击其他页面而没有退出当前浏览器的时候,就可以直接从session中取出登陆成功时存在里面的user对象,不需要再次执行登陆的操作。
////        HttpSession session = request.getSession();// 获取该客户端当前web应用存储的session域对象
////        User user = (User) session.getAttribute("user");// 获取该客户端用户存储在当前web应用的user对象
////
////        try {
////            // 2.2接下来判断该user对象是否存在,如果存在,,放行,session中本就存在该user对象,无需在存储直接放行即可.如果不存在,说明session可能过期或其他原因找不到了.
////            // 如果user对象不存在,就需要获取请求中带过来的cookies,如果用户勾选了自动登录并且cookie没有过期,那么其请求中会携带账密的cookie过来
////            if (user == null) { // 用户user不存在 用户存在的话不需要进行操作,不会进入if语句,在最后执行放行代码即可
////                // 获取请求携带的所有cookies
////                Cookie[] cookies = request.getCookies();
////                String username = null;// 用户的账号
////                String password = null;// 用户的密码
////                // 遍历所有cookie,获取代表用户账号密码的Cookie
////                if (cookies != null) {
////                    for (Cookie cookie : cookies) { // 如果用户勾选了自动登录并且Cookie未失效,就会存在username和password的Cookie
////                        String name = cookie.getName();// 获取每一个Cookie的key
////                        String value = cookie.getValue();// 获取每一个Cookie的value
////                        if ("username".equals(name)) {
////                            username = value;//???
////                        }
////                        if ("password".equals(name)) {
////                            password = value;
////                        }
////                    }
////
////                    // 2.3获取到账密的Cookie进行判断,如果为空,就直接放行让其访问页面,如果不为空,就调用业务层执行登陆操作,返回一个User对象。
////                    if (username != null && password != null) { // 从Cookie中获得的用户名和账号都不为空,调用业务层执行登陆操作
////                        LoginService service = new LoginService();
////                        User user2 = service.login(username, password);// 登陆后返回的user对象
////
////                        // 2.4判断User对象是否存在,如果不存在说明账密错误自动登陆失败,放行。如果存在,将该对象存入session中,自动登录成功,并放行。
////                        if (user2 != null) { // 用户登陆成功,将代表该用户的对象存入session域
////                            session.setAttribute("user", user2);// 这里的存入与Servlet中存储的name要保持一致
////                        }
////                    }
////                }
////            }
////        } catch (SQLException e) {
////            e.printStackTrace();
////        } finally {
////            // 3.放行
////            chain.doFilter(request, response);
////        }
////    }
//
//    @Override
//    public void destroy() {
//        System.out.println("过滤器Filter销毁");
//    }
//
//}
