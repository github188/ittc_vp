/**
 * <p>Title: IAopService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年7月7日
 * @version 1.0.0
 */
package cn.sh.ittc.service;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * <p>Title: IAopService</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年7月7日
 */
public interface IAopService {
	/**
	 * 
	 * <p>Title: addLogLogin</p>
	 * <p>Description: 登陆日志</p>
	 * @param pjp
	 * @return
	 * @author 焦冬冬
	 * @throws Throwable 
	 * @date 2014年7月7日
	 */
	public Object loginLog(ProceedingJoinPoint pjp) throws Throwable;
	/**
	 * 
	 * <p>Title: addUserLog</p>
	 * <p>Description:添加新用户日志 </p>
	 * @param pjp
	 * @return
	 * @author 焦冬冬
	 * @throws Throwable 
	 * @date 2014年7月7日
	 */
	public Object addUserLog(ProceedingJoinPoint pjp) throws Throwable;
	/**
	 * 
	 * <p>Title: modfiyUserLog</p>
	 * <p>Description: 修改用户信息日志</p>
	 * @param pjp
	 * @return
	 * @author 焦冬冬
	 * @throws Throwable 
	 * @date 2014年7月7日
	 */
	public Object modfiyUserLog(ProceedingJoinPoint pjp) throws Throwable;
	/**
	 * 
	 * <p>Title: addDepLog</p>
	 * <p>Description: 添加部门日志</p>
	 * @param pjp
	 * @return
	 * @author 焦冬冬
	 * @throws Throwable 
	 * @date 2014年7月7日
	 */
	public Object addDepLog(ProceedingJoinPoint pjp) throws Throwable;
	/**
	 * 
	 * <p>Title: delDepByIdLog</p>
	 * <p>Description:删除部门日志 </p>
	 * @param pjp
	 * @return
	 * @author 焦冬冬
	 * @throws Throwable 
	 * @date 2014年7月7日
	 */
	public Object delDepByIdLog(ProceedingJoinPoint pjp) throws Throwable;
	/**
	 * 
	 * <p>Title: initPwdLog</p>
	 * <p>Description: 初始化密码日志</p>
	 * @param pjp
	 * @return
	 * @author 焦冬冬
	 * @throws Throwable 
	 * @date 2014年7月7日
	 */
	public Object initPwdLog(ProceedingJoinPoint pjp) throws Throwable;
	
	/**
	 * 
	 * <p>Title: authorityLog</p>
	 * <p>Description:添加权限 </p>
	 * @param pjp
	 * @return
	 * @throws Throwable
	 * @author 焦冬冬
	 * @date 2014年7月7日
	 */
	public Object authorityLog(ProceedingJoinPoint pjp) throws Throwable;

}
