/**
 * <p>Title: LoginLog.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author ������
 * @date 2014��7��7��
 * @version 1.0.0
 */
package cn.sh.ittc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import cn.sh.ittc.service.IAopService;

/**
 * <p>Title: LoginLog</p>
 * <p>Description: </p>
 * @author ������
 * @date 2014��7��7��
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
			// ��½��־
			obj = aopService.loginLog(pjp);
		} else if ("cn.sh.ittc.service.impl.UserService.addUser"
				.equals(methodName)) {
			// ����û���־
			obj = aopService.addUserLog(pjp);
		} else if ("cn.sh.ittc.service.impl.UserService.addDep"
				.equals(methodName)) {
			// ��Ӳ�����־
			obj = aopService.addDepLog(pjp);
		} else if ("cn.sh.ittc.service.impl.UserService.initPwd"
				.equals(methodName)) {
			// ��ʼ��������־
			obj = aopService.initPwdLog(pjp);
		} else if ("cn.sh.ittc.service.impl.UserService.modifyUser"
				.equals(methodName)) {
			// �޸��û���Ϣ��־
			obj = aopService.modfiyUserLog(pjp);
		} else if ("cn.sh.ittc.service.impl.UserService.delDepById"
				.equals(methodName)) {
			// ɾ��������־
			obj = aopService.delDepByIdLog(pjp);
		} else if ("cn.sh.ittc.service.impl.AuthorityService.saveOrUpdateUserAuthority"
				.equals(methodName)) {
			//Ȩ�޲���
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
