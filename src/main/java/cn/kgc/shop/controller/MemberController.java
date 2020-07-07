package cn.kgc.shop.controller;

import cn.kgc.shop.service.MemberService;
import cn.kgc.shop.utils.CheckCode;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import cn.kgc.shop.model.MemberEntity;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * 
 * @author lx
 *   Member控制器
 * @date 2020-06-28 16:19:19
 */
@Controller
@RequestMapping("/member")
public class MemberController extends BaseController<MemberEntity>{

    @Autowired
    private MemberService memberService;

    /**
     * 生成验证码
     */
    @RequestMapping("/outputCode")
    @ResponseBody
    public void outputCode(HttpServletResponse response, HttpSession session){
        try {
            //得到页面输出流
            ServletOutputStream os = response.getOutputStream();
            String code = CheckCode.outputImage(116, 33, os);
            session.setAttribute("code",code);
            System.out.println("code:"+code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 验证验证码
     */
    @RequestMapping("/checkCode")
    @ResponseBody
    public Map<String, Object> checkCode(String code, HttpSession session){
        String code1 = (String) session.getAttribute("code");
        if (code1.equalsIgnoreCase(code)){
            return putMsgToJsonString(SUCCESSCODE,SUCCESS,FAILCOUNT,null);
        }
        return putMsgToJsonString(FAILCODE,FAIL,FAILCOUNT,null);
    }


    /**
     * 登录
     */
    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(MemberEntity memberEntity, HttpSession session){

        try {
            MemberEntity loginUser = baseService.findObjectByPramas(memberEntity);
            if (null!=loginUser){
                //登录成功
                session.setAttribute("loginUser",loginUser);
                return putMsgToJsonString(SUCCESSCODE,SUCCESS,FAILCOUNT,null);
            }
            return putMsgToJsonString(FAILCODE,FAIL,FAILCOUNT,null);
        } catch (Exception e) {
            e.printStackTrace();
            return putMsgToJsonString(FAILCODE,ERROR,FAILCOUNT,null);
        }

    }


    /**
     * 修改用户信息
     * @param session
     * @return
     */
    @RequestMapping("/updateMemberInfo")
    @ResponseBody
    public Map<String, Object> updateMemberInfo(MemberEntity memberEntity,String newPwd,HttpSession session){

        try {
            String s = memberService.updateMemberInfo(memberEntity,newPwd, session);
            return putMsgToJsonString(SUCCESSCODE,s,FAILCOUNT,null);
        } catch (Exception e) {
            e.printStackTrace();
            return putMsgToJsonString(FAILCODE,ERROR,FAILCOUNT,null);
        }

    }


    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    @ResponseBody
    public Map<String, Object> logout(HttpSession session){

        session.removeAttribute("loginUser");
        return putMsgToJsonString(SUCCESSCODE,FAIL,FAILCOUNT,null);

    }


}
