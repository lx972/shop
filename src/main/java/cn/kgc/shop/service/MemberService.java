package cn.kgc.shop.service;

import cn.kgc.shop.model.MemberEntity;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 
 * @author lx
 *    Member业务层接口
 * @date 2020-06-28 16:19:19
 */
public interface MemberService extends BaseService<MemberEntity>{


    /**
     * 修改用户信息
     * @param session
     * @return
     * @throws Exception
     */
   String updateMemberInfo(MemberEntity memberEntity,String newPwd,HttpSession session)throws Exception;
	
}
