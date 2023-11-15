package com.tjetc.sys.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.tjetc.sys.constants.SysConstant;
import com.tjetc.sys.doman.User;
import com.tjetc.sys.doman.UserVo;
import com.tjetc.sys.service.IUserService;
import com.tjetc.sys.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    IUserService userService;

    /**
     * 跳转到登录⻚⾯
     */
    @RequestMapping("toLogin")
    public String toLogin() {
        return "system/main/login";
    }

    /**
     * ⽣成验证码
     */
    @RequestMapping("getCode")
    public void getCode(HttpServletResponse response, HttpSession session) throws IOException {
        //定义图形的⻓度宽度和符号和⼲扰线
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116, 36, 4, 5);
        //⽣成的验证码放到了session
        session.setAttribute("code", lineCaptcha.getCode());
        //获取输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //将数据以图⽚的⽅式输出
        ImageIO.write(lineCaptcha.getImage(), "PNG", outputStream);
    }

    /**
     * 登录⽅法
     */
    @RequestMapping("login")
    public String login(UserVo userVo, Model model) {
        //1.获取验证码
        String code = WebUtils.getHttpSession().getAttribute("code").toString();
        //2.判断⽤户输⼊的验证码和session中的验证码是否⼀致
        if (userVo.getCode().equals(code)) {
            //3.如果验证码⼀样,就要验证⽤户名或密码是否正确
            User user = userService.login(userVo);
            if (null != user) {
                //4.如果⽤户存在,说明登陆成功,需要跳转到index⻚⾯,同时将⽤户信息放到session中
                WebUtils.getHttpSession().setAttribute("user", user);
                return "system/main/index";
            } else {
                //没有查到⽤户,说明⽤户名或密码错误
                model.addAttribute("error", SysConstant.USER_LOGIN_ERROR_MSG);
                return "system/main/login";
            }
        } else {
            model.addAttribute("error", SysConstant.USER_LOGIN_CODE_ERROR_MSG);
            return "system/main/login";
        }
    }
}
