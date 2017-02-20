/**
 * <p>Title: SessionUtils.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年6月24日
 * @version 1.0.0
 */
package cn.sh.ittc.uitls;

import java.util.Map;

import cn.sh.ittc.model.UserModel;

import com.opensymphony.xwork2.ActionContext;

/**
 * <p>Title: SessionUtils</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年6月24日
 */
public class SessionUtils {
	
	/**
	 * 
	 * <p>Title: putUserSession</p>
	 * <p>Description: </p>
	 * @param userModel
	 * @author 焦冬冬
	 * @date 2014年6月24日
	 */
	public static void putUserSession(UserModel userModel) {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		session.put("USER_INFO", userModel);
	}
	
	/**
	 * 
	 * <p>Title: getUserSession</p>
	 * <p>Description: </p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年6月24日
	 */
	public static UserModel getUserSession(){
		ActionContext actionContext = ActionContext.getContext();
        Map<String,Object> session = actionContext.getSession();
        UserModel tbusers=(UserModel) session.get("USER_INFO");
        return tbusers;
	}
	
	/**
	 * 
	 * <p>Title: clearSession</p>
	 * <p>Description: </p>
	 * @author 焦冬冬
	 * @date 2014年6月24日
	 */
	public static void clearSession(){
		ActionContext actionContext = ActionContext.getContext();
        Map<String,Object> session = actionContext.getSession();
        session.clear();
	}

}
