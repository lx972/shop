package cn.kgc.shop.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.kgc.shop.model.MemberEntity;
import cn.kgc.shop.service.MemberService;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 
 * @author lx
 *    Member业务层实现类
 * @date 2020-06-28 16:19:19
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MemberServiceImpl extends BaseServiceImpl<MemberEntity> implements MemberService {


    /**
     * 修改用户信息
     * @param session
     * @return
     * @throws Exception
     */
    @Override
    public String updateMemberInfo(MemberEntity memberEntity,String newPwd,HttpSession session) throws Exception {
        MemberEntity loginUser = (MemberEntity) session.getAttribute("loginUser");
        if (loginUser.getPwd().equals(memberEntity.getPwd())){
            //旧密码正确
            memberEntity.setMemberId(loginUser.getMemberId());
            memberEntity.setPwd(newPwd);
            baseMapper.update(memberEntity);
            session.setAttribute("loginUser",memberEntity);
            return SUCCESS;
        }else {
            return FAIL;
        }



    }
}
