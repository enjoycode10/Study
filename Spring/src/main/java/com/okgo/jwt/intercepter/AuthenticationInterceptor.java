package com.okgo.jwt.intercepter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.okgo.jwt.annotation.TokenRequired;
import com.okgo.jwt.entity.User;
import com.okgo.jwt.service.UserService;
import com.okgo.jwt.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author Shawn
 * @date 2020/7/5 2:40
 * @title AuthenticationInterceptor拦截器实现了HandlerInterceptor接口的三个方法：
 * <p>
 * 1. boolean preHandle()：
 * 预处理回调方法,实现处理器的预处理，第三个参数为响应的处理器,自定义Controller返回值，返回值为true会调用下一个拦截器或处理器，
 * 或者接着执行postHandle()和afterCompletion()；false表示流程中断，不会继续调用其他的拦截器或处理器，中断执行。
 * <p>
 * 2. void postHandle()：
 * 后处理回调方法，实现处理器的后处理（DispatcherServlet进行视图返回渲染之前进行调用），
 * 此时我们可以通过modelAndView对模型数据进行处理或对视图进行处理，modelAndView也可能为null。
 * <p>
 * 3. void afterCompletion():
 * 整个请求处理完毕回调方法,该方法也是需要当前对应的Interceptor的preHandle()的返回值为true时才会执行，
 * 也就是在DispatcherServlet渲染了对应的视图之后执行。用于进行资源清理。
 * <p>
 * 该拦截器的执行流程为：
 * 从 http 请求头中取出 token；
 * 检查有没有需要用户权限的注解，如果需要，检验token是否为空；
 * 如果token不为空，查询用户信息并校验token；
 * 校验通过，则进行业务访问处理，校验失败则返回token失效信息。
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        // 从 http 请求头中取出 token
        String token = httpServletRequest.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(TokenRequired.class)) {
            TokenRequired userLoginToken = method.getAnnotation(TokenRequired.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    throw new RuntimeException("无token，请重新登录");
                }
                // 获取 token 中的 user id
                String userId;
                try {
                    userId = JWT.decode(token).getClaim("userId").asString();
                } catch (JWTDecodeException j) {
                    throw new RuntimeException("401");
                }
                User user = UserService.user;
                if (user == null) {
                    throw new RuntimeException("用户不存在，请重新登录");
                }
                // 验证 token
                try {
                    if (!JwtUtil.verity(token, user.getPassword())) {
                        throw new RuntimeException("无效的令牌");
                    }
                } catch (JWTVerificationException e) {
                    throw new RuntimeException("401");
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
