/**
 * <p>Title: LoginLog.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年7月7日
 * @version 1.0.0
 */
package cn.sh.ittc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import cn.sh.ittc.service.IAopService;

/**
 * <p>Title: LoginLog</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年7月7日
 */
public class LoginLog {
	private IAopService aopService;

	public void doBefore(JoinPoint jp) {
		
//		System.err.println("log Begining method: "
//				+ jp.getTarget().getClass().getName() + "."
//				+ jp.getSignature().getName());
//		Object[] args=jp.getArgs();
//		System.err.println(args[0]+","+args[1]);
	}

	public void doAfter(JoinPoint jp) {
//		System.err.println("log Ending method: "
//				+ jp.getTarget().getClass().getName() + "."
//				+ jp.getSignature().getName());
//		Object[] args=jp.getArgs();
//		System.err.println(args[0]+","+args[1]);
	}
	
	 public void doThrowing(JoinPoint jp, Throwable ex) {  
	        System.out.println("method " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName() + " throw exception");  
	        System.out.println(ex.getMessage());  
	    }
	
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getTarget().getClass().getName() + "."
				+ pjp.getSignature().getName();
		System.err.println(methodName);
		Object obj = null;
		if ("cn.sh.ittc.service.impl.UserService.checkLogin".equals(methodName)) {
			// 登陆日志
			obj = aopService.loginLog(pjp);
		} else if ("cn.sh.ittc.service.impl.UserService.addUser"
				.equals(methodName)) {
			// 添加用户日志
			obj = aopService.addUserLog(pjp);
		} else if ("cn.sh.ittc.service.impl.UserService.addDep"
				.equals(methodName)) {
			// 添加部门日志
			obj = aopService.addDepLog(pjp);
		} else if ("cn.sh.ittc.service.impl.UserService.initPwd"
				.equals(methodName)) {
			// 初始化密码日志
			obj = aopService.initPwdLog(pjp);
		} else if ("cn.sh.ittc.service.impl.UserService.modifyUser"
				.equals(methodName)) {
			// 修改用户信息日志
			obj = aopService.modfiyUserLog(pjp);
		} else if ("cn.sh.ittc.service.impl.UserService.delDepById"
				.equals(methodName)) {
			// 删除部门日志
			obj = aopService.delDepByIdLog(pjp);
		} else if ("cn.sh.ittc.service.impl.AuthorityService.saveOrUpdateUserAuthority"
				.equals(methodName)) {
			//权限操作
			obj=aopService.authorityLog(pjp);
		}

		if (obj == null) {
			return pjp.proceed();
		}
		return obj;
	}

	/**
	 * @param aopService the aopService to set
	 */
	public void setAopService(IAopService aopService) {
		this.aopService = aopService;
	}
	
	
}
