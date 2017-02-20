/**
 * <p>Title: AopService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author ������
 * @date 2014��7��7��
 * @version 1.0.0
 */
package cn.sh.ittc.service.impl;

import org.aspectj.lang.ProceedingJoinPoint;

import cn.sh.ittc.dao.ILogSearchDao;
import cn.sh.ittc.model.DepartmentModel;
import cn.sh.ittc.model.SysLogModel;
import cn.sh.ittc.model.UserAuthorityModel;
import cn.sh.ittc.model.UserModel;
import cn.sh.ittc.service.IAopService;
import cn.sh.ittc.uitls.SessionUtils;

/**
 * <p>Title: AopService</p>
 * <p>Description: </p>
 * @author ������
 * @date 2014��7��7��
 */
public class AopService implements IAopService{

	private ILogSearchDao logSearchDao;
	
	@Override
	public Object loginLog(ProceedingJoinPoint pjp) throws Throwable {
		SysLogModel sysLogModel=new SysLogModel();
		Object[] args = pjp.getArgs();
		Object result = pjp.proceed();
		System.err.println(args[0] + "," + args[1]);
		int i=(int) result;
		String s;
		if(i==0){
			s="��½�ɹ�";
			sysLogModel.setUserName((String) args[0]);
		}else if(i==1){
			s="�û�������";
		}else if(i==2){
			s="�������";
		}else {
			s="��½ʧ��";
		}
		
		sysLogModel.setContent(args[0]+","+s);
		logSearchDao.addOperateLog(sysLogModel);
		return pjp.proceed();
	}

	
	@Override
	public Object addUserLog(ProceedingJoinPoint pjp) throws Throwable {
		SysLogModel sysLogModel=new SysLogModel();
		sysLogModel.setUserName(SessionUtils.getUserSession().getUserName());
		UserModel userModel=(UserModel) pjp.getArgs()[0];
		Object obj=pjp.proceed();
		if((boolean) obj){
			sysLogModel.setContent("���'"+userModel.getUserName()+"'�û����ɹ�");
		}else {
			sysLogModel.setContent("���'"+userModel.getUserName()+"'�û���ʧ��");
		}
		sysLogModel.setDepName(SessionUtils.getUserSession().getDepName());
		logSearchDao.addOperateLog(sysLogModel);
		
		return obj;
	}


	@Override
	public Object modfiyUserLog(ProceedingJoinPoint pjp) throws Throwable {
		SysLogModel sysLogModel=new SysLogModel();
		sysLogModel.setUserName(SessionUtils.getUserSession().getUserName());
		UserModel userModel=(UserModel) pjp.getArgs()[0];
		Object obj=pjp.proceed();
		if((boolean) obj){
			if(userModel.getIsDel()==1){
				sysLogModel.setContent("ɾ��'"+userModel.getUserName()+"'�û���Ϣ���ɹ�");
			}else {
				sysLogModel.setContent("�޸�'"+userModel.getUserName()+"'�û���Ϣ���ɹ�");
			}
			
		}else {
			sysLogModel.setContent("ɾ��/�޸�'"+userModel.getUserName()+"'�û���Ϣ��ʧ��");
		}
		sysLogModel.setDepName(SessionUtils.getUserSession().getDepName());
		logSearchDao.addOperateLog(sysLogModel);
		return obj;
	}


	@Override
	public Object addDepLog(ProceedingJoinPoint pjp) throws Throwable {
		SysLogModel sysLogModel=new SysLogModel();
		sysLogModel.setUserName(SessionUtils.getUserSession().getUserName());
		DepartmentModel departmentModel=(DepartmentModel) pjp.getArgs()[0];
		Object obj=pjp.proceed();
		if((boolean) obj){
			sysLogModel.setContent("���'"+departmentModel.getDepName()+"'���ţ��ɹ�");
		}else {
			sysLogModel.setContent("���'"+departmentModel.getDepName()+"'���ţ�ʧ��");
		}
		sysLogModel.setDepName(SessionUtils.getUserSession().getDepName());
		
		logSearchDao.addOperateLog(sysLogModel);
		
		return obj;
	}


	@Override
	public Object delDepByIdLog(ProceedingJoinPoint pjp) throws Throwable {
		SysLogModel sysLogModel=new SysLogModel();
		sysLogModel.setUserName(SessionUtils.getUserSession().getUserName());
		DepartmentModel departmentModel=(DepartmentModel) pjp.getArgs()[0];
		Object obj=pjp.proceed();
		if((boolean) obj){
			sysLogModel.setContent("ɾ��'"+departmentModel.getDepName()+"'���ţ��ɹ�");
		}else {
			sysLogModel.setContent("ɾ��'"+departmentModel.getDepName()+"'���ţ�ʧ��");
		}
		sysLogModel.setDepName(SessionUtils.getUserSession().getDepName());
		logSearchDao.addOperateLog(sysLogModel);
		return obj;
	}


	@Override
	public Object initPwdLog(ProceedingJoinPoint pjp) throws Throwable {
		SysLogModel sysLogModel=new SysLogModel();
		sysLogModel.setUserName(SessionUtils.getUserSession().getUserName());
		UserModel userModel=(UserModel) pjp.getArgs()[0];
		Object obj=pjp.proceed();
		if((boolean) obj){
			sysLogModel.setContent("��ʼ��'"+userModel.getUserName()+"'�û����룬�ɹ�");
		}else {
			sysLogModel.setContent("��ʼ��'"+userModel.getUserName()+"'�û����룬ʧ��");
		}
		sysLogModel.setDepName(SessionUtils.getUserSession().getDepName());
		logSearchDao.addOperateLog(sysLogModel);
		return obj;
	}

	@Override
	public Object authorityLog(ProceedingJoinPoint pjp) throws Throwable {
		Object obj=pjp.proceed();
		SysLogModel sysLogModel=new SysLogModel();
		sysLogModel.setUserName(SessionUtils.getUserSession().getUserName());
		UserAuthorityModel userAuthorityModel=(UserAuthorityModel) pjp.getArgs()[0];
//		String json=(String) pjp.getArgs()[1];
		//System.out.println(userAuthorityModel);
		//System.out.println(json);
		if((boolean) obj){
			sysLogModel.setContent("����'"+userAuthorityModel.getUserName()+"'�û�Ȩ�ޣ��ɹ�");
		}else {
			sysLogModel.setContent("����'"+userAuthorityModel.getUserName()+"'�û�Ȩ�ޣ�ʧ��");
		}
		sysLogModel.setDepName(SessionUtils.getUserSession().getDepName());
		logSearchDao.addOperateLog(sysLogModel);
		return obj;
	}

	/**
	 * @param logSearchDao the logSearchDao to set
	 */
	public void setLogSearchDao(ILogSearchDao logSearchDao) {
		this.logSearchDao = logSearchDao;
	}



	
	
}
