/**
 * <p>Title: LoginInterceptor.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author ������
 * @date 2014��6��24��
 * @version 1.0.0
 */
package cn.sh.ittc.interceptot;

import cn.sh.ittc.model.UserModel;
import cn.sh.ittc.uitls.SessionUtils;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * <p>Title: LoginInterceptor</p>
 * <p>Description: </p>
 * @author ������
 * @date 2014��6��24��
 */
public class LoginInterceptor extends MethodFilterInterceptor{

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/* ��no Javadoc��
	 * <p>Title: doIntercept</p>
	 * <p>Description: </p>
	 * @param arg0
	 * @return
	 * @throws Exception
	 * @see com.opensymphony.xwork2.interceptor.MethodFilterInterceptor#doIntercept(com.opensymphony.xwork2.ActionInvocation)
	 * @author ������
	 * @date 2014��6��24��
	 */
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("==========������ִ�У�============");
		UserModel userModel=SessionUtils.getUserSession();
		if(userModel==null){
			return Action.LOGIN;
		}
//		System.out.println(userModel.getLoginName());
		return invocation.invoke();
	}

}
