/**
 * <p>Title: IAopService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author ������
 * @date 2014��7��7��
 * @version 1.0.0
 */
package cn.sh.ittc.service;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * <p>Title: IAopService</p>
 * <p>Description: </p>
 * @author ������
 * @date 2014��7��7��
 */
public interface IAopService {
	/**
	 * 
	 * <p>Title: addLogLogin</p>
	 * <p>Description: ��½��־</p>
	 * @param pjp
	 * @return
	 * @author ������
	 * @throws Throwable 
	 * @date 2014��7��7��
	 */
	public Object loginLog(ProceedingJoinPoint pjp) throws Throwable;
	/**
	 * 
	 * <p>Title: addUserLog</p>
	 * <p>Description:������û���־ </p>
	 * @param pjp
	 * @return
	 * @author ������
	 * @throws Throwable 
	 * @date 2014��7��7��
	 */
	public Object addUserLog(ProceedingJoinPoint pjp) throws Throwable;
	/**
	 * 
	 * <p>Title: modfiyUserLog</p>
	 * <p>Description: �޸��û���Ϣ��־</p>
	 * @param pjp
	 * @return
	 * @author ������
	 * @throws Throwable 
	 * @date 2014��7��7��
	 */
	public Object modfiyUserLog(ProceedingJoinPoint pjp) throws Throwable;
	/**
	 * 
	 * <p>Title: addDepLog</p>
	 * <p>Description: ��Ӳ�����־</p>
	 * @param pjp
	 * @return
	 * @author ������
	 * @throws Throwable 
	 * @date 2014��7��7��
	 */
	public Object addDepLog(ProceedingJoinPoint pjp) throws Throwable;
	/**
	 * 
	 * <p>Title: delDepByIdLog</p>
	 * <p>Description:ɾ��������־ </p>
	 * @param pjp
	 * @return
	 * @author ������
	 * @throws Throwable 
	 * @date 2014��7��7��
	 */
	public Object delDepByIdLog(ProceedingJoinPoint pjp) throws Throwable;
	/**
	 * 
	 * <p>Title: initPwdLog</p>
	 * <p>Description: ��ʼ��������־</p>
	 * @param pjp
	 * @return
	 * @author ������
	 * @throws Throwable 
	 * @date 2014��7��7��
	 */
	public Object initPwdLog(ProceedingJoinPoint pjp) throws Throwable;
	
	/**
	 * 
	 * <p>Title: authorityLog</p>
	 * <p>Description:���Ȩ�� </p>
	 * @param pjp
	 * @return
	 * @throws Throwable
	 * @author ������
	 * @date 2014��7��7��
	 */
	public Object authorityLog(ProceedingJoinPoint pjp) throws Throwable;

}
