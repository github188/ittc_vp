/**
 * <p>Title: IUserServer.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年3月5日
 * @version 1.0.0
 */
package cn.sh.ittc.service;

import java.io.InputStream;
import java.util.List;

import cn.sh.ittc.model.DepartmentModel;
import cn.sh.ittc.model.UserModel;

/**
 * <p>Title: IUserServer</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年3月5日
 */
public interface IUserService {
	
	/**
	 * 
	 * <p>Title: checkLogin</p>
	 * <p>Description:根据登录名和密码验证登陆是否成功 </p>
	 * @param loginName
	 * @param loginPwd
	 * @return
	 * @author 焦冬冬
	 * @date 2014年3月5日
	 */
	public int checkLogin(String loginName,String loginPwd);
	/**
	 * 
	 * <p>Title: addUser</p>
	 * <p>Description: 添加用户</p>
	 * @param userModel
	 * @return
	 * @author 焦冬冬
	 * @date 2014年3月5日
	 */
	public boolean addUser(UserModel userModel);
	
	/**
	 * 
	 * <p>Title: modifyUser</p>
	 * <p>Description: 修改用户信息</p>
	 * @param userModel
	 * @return
	 * @author 焦冬冬
	 * @date 2014年3月5日
	 */
	public boolean modifyUser(UserModel userModel);
	/**
	 * 
	 * <p>Title: getUserByLoginName</p>
	 * <p>Description: </p>
	 * @param loginName
	 * @return
	 * @author 焦冬冬
	 * @date 2014年3月19日
	 */
	public UserModel getUserByLoginName(String loginName);
	
	/**
	 * 
	 * <p>Title: getAllDep</p>
	 * <p>Description: </p>
	 * @return 获取所有的部门
	 * @author 焦冬冬
	 * @date 2014年3月19日
	 */
	public List<DepartmentModel> getAllDep();
	
	/**
	 * 
	 * <p>Title: getUserByDep</p>
	 * <p>Description: </p>
	 * @param userModel
	 * @return
	 * @author 焦冬冬 modify
	 * @date 2014年6月24日
	 */
	public String getUserByDep(UserModel userModel);
	
	/**
	 * 
	 * <p>Title: addDep</p>
	 * <p>Description: 添加用户</p>
	 * @param departmentModel
	 * @return
	 * @author 焦冬冬
	 * @date 2014年3月24日
	 */
	public boolean addDep(DepartmentModel departmentModel);
	
	/**
	 * 
	 * <p>Title: getUserById</p>
	 * <p>Description: </p>
	 * @param userId
	 * @return
	 * @author 焦冬冬
	 * @date 2014年3月24日
	 */
	public UserModel getUserById(int userId);
	/**
	 * 
	 * <p>Title: delDepById</p>
	 * <p>Description: </p>
	 * @param departmentModel
	 * @return
	 * @author 焦冬冬
	 * @date 2014年4月16日
	 */
	public boolean delDepById(DepartmentModel departmentModel);
	
	/**
	 * 
	 * <p>Title: initPwd</p>
	 * <p>Description: </p>
	 * @param userModel
	 * @return
	 * @author 焦冬冬
	 * @date 2014年4月17日
	 */
	public boolean initPwd(UserModel userModel);
	
	public String getDepUser();
	/**
	 * 
	 * <p>Title: exportUserInfo2Excel</p>
	 * <p>Description: </p>
	 * @param userModel
	 * @return
	 * @author 焦冬冬
	 * @throws Exception 
	 * @date 2014年7月11日
	 */
	public InputStream exportUserInfo2Excel(UserModel userModel) throws Exception;
	/**
	 * 
	 * <p>Title: modifyPwd</p>
	 * <p>Description: </p>
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 * @author 焦冬冬
	 * @date 2014年7月11日
	 */
	public String modifyPwd(String oldPwd,String newPwd);
}
