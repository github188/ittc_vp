/**
 * <p>Title: AopService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年7月7日
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
 * @author 焦冬冬
 * @date 2014年7月7日
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
			s="登陆成功";
			sysLogModel.setUserName((String) args[0]);
		}else if(i==1){
			s="用户不存在";
		}else if(i==2){
			s="密码错误";
		}else {
			s="登陆失败";
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
			sysLogModel.setContent("添加'"+userModel.getUserName()+"'用户，成功");
		}else {
			sysLogModel.setContent("添加'"+userModel.getUserName()+"'用户，失败");
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
				sysLogModel.setContent("删除'"+userModel.getUserName()+"'用户信息，成功");
			}else {
				sysLogModel.setContent("修改'"+userModel.getUserName()+"'用户信息，成功");
			}
			
		}else {
			sysLogModel.setContent("删除/修改'"+userModel.getUserName()+"'用户信息，失败");
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
			sysLogModel.setContent("添加'"+departmentModel.getDepName()+"'部门，成功");
		}else {
			sysLogModel.setContent("添加'"+departmentModel.getDepName()+"'部门，失败");
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
			sysLogModel.setContent("删除'"+departmentModel.getDepName()+"'部门，成功");
		}else {
			sysLogModel.setContent("删除'"+departmentModel.getDepName()+"'部门，失败");
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
			sysLogModel.setContent("初始化'"+userModel.getUserName()+"'用户密码，成功");
		}else {
			sysLogModel.setContent("初始化'"+userModel.getUserName()+"'用户密码，失败");
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
			sysLogModel.setContent("配置'"+userAuthorityModel.getUserName()+"'用户权限，成功");
		}else {
			sysLogModel.setContent("配置'"+userAuthorityModel.getUserName()+"'用户权限，失败");
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
