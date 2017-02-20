/**
 * <p>Title: IUserDao.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年3月5日
 * @version 1.0.0
 */
package cn.sh.ittc.dao;

import java.util.HashMap;
import java.util.List;

import cn.sh.ittc.model.DepartmentModel;
import cn.sh.ittc.model.UserModel;

/**
 * <p>Title: IUserDao</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年3月5日
 */
public interface IUserDao {

	/**
	 * 
	 * <p>Title: getUserByLoginName</p>
	 * <p>Description: 根据登录名查询用户信息</p>
	 * @param loginName
	 * @return
	 * @author 焦冬冬
	 * @date 2014年3月5日
	 */
	public UserModel getUserByLoginName(String loginName);
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
	 * <p>Title: getAllDep</p>
	 * <p>Description: 获取</p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年3月19日
	 */
	public List<DepartmentModel> getAllDep();
	
	/**
	 * 
	 * <p>Title: getUserByDep</p>
	 * <p>Description: </p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年3月19日
	 */
	public List<UserModel> getUserByDep(UserModel userModel);
	/**
	 * 
	 * <p>Title: getUserCountByDep</p>
	 * <p>Description: </p>
	 * @param depId
	 * @return
	 * @author 焦冬冬
	 * @date 2014年6月24日
	 */
	public int getUserCountByDep(int depId);
	
	
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
	 * <p>Description:根据主键编号查询用户 </p>
	 * @param userId
	 * @return
	 * @author 焦冬冬
	 * @date 2014年3月24日
	 */
	public UserModel getUserById(int userId);
	/**
	 * 
	 * <p>Title: delDepById</p>
	 * <p>Description: 非物理删除部门</p>
	 * @param departmentModel
	 * @return
	 * @author 焦冬冬
	 * @date 2014年4月16日
	 */
	public boolean delDepById(DepartmentModel departmentModel);
	/**
	 * 
	 * <p>Title: initPwd</p>
	 * <p>Description: 初始化密码</p>
	 * @param userModel
	 * @return
	 * @author 焦冬冬
	 * @date 2014年4月17日
	 */
	public boolean initPwd(UserModel userModel);
	
	@SuppressWarnings("rawtypes")
	public List<HashMap> getDepUser();
}
