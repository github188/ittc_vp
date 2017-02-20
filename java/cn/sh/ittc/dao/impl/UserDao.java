/**
 * <p>Title: UserDao.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年3月5日
 * @version 1.0.0
 */
package cn.sh.ittc.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import cn.sh.ittc.dao.IUserDao;
import cn.sh.ittc.model.DepartmentModel;
import cn.sh.ittc.model.UserModel;

/**
 * <p>Title: UserDao</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年3月5日
 */
public class UserDao extends SqlMapClientDaoSupport implements IUserDao {

	/* （no Javadoc）
	 * <p>Title: getPwdByLoginName</p>
	 * <p>Description: </p>
	 * @param loginName
	 * @return
	 * @see cn.sh.ittc.dao.IUserDao#getPwdByLoginName(java.lang.String)
	 * @author 焦冬冬
	 * @date 2014年3月5日
	 */
	@Override
	public UserModel getUserByLoginName(String loginName) {
		try {
			UserModel userModel = (UserModel) getSqlMapClientTemplate()
					.queryForObject("userSql.getUser", loginName);
			return userModel;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	/* （no Javadoc）
	 * <p>Title: addUser</p>
	 * <p>Description: </p>
	 * @param userModel
	 * @return
	 * @see cn.sh.ittc.dao.IUserDao#addUser(cn.sh.ittc.model.UserModel)
	 * @author 焦冬冬
	 * @date 2014年3月5日
	 */
	@Override
	public boolean addUser(UserModel userModel) {
		try {
			getSqlMapClientTemplate().insert("userSql.addUser", userModel);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	/* （no Javadoc）
	 * <p>Title: modifyUser</p>
	 * <p>Description: </p>
	 * @param userModel
	 * @return
	 * @see cn.sh.ittc.dao.IUserDao#modifyUser(cn.sh.ittc.model.UserModel)
	 * @author 焦冬冬
	 * @date 2014年3月5日
	 */
	@Override
	public boolean modifyUser(UserModel userModel) {
		try {
			getSqlMapClientTemplate().update("userSql.modifyUser", userModel);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	/* （no Javadoc）
	 * <p>Title: getAllDep</p>
	 * <p>Description: </p>
	 * @return
	 * @see cn.sh.ittc.dao.IUserDao#getAllDep()
	 * @author 焦冬冬
	 * @date 2014年3月19日
	 */
	@Override
	public List<DepartmentModel> getAllDep() {
		try {
			@SuppressWarnings("unchecked")
			List<DepartmentModel> list=getSqlMapClientTemplate().queryForList("userSql.getAllDep");
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	/* （no Javadoc）
	 * <p>Title: getUserByDep</p>
	 * <p>Description: </p>
	 * @return
	 * @see cn.sh.ittc.dao.IUserDao#getUserByDep()
	 * @author 焦冬冬
	 * @date 2014年3月19日
	 */
	@Override
	public List<UserModel> getUserByDep(UserModel userModel) {
		@SuppressWarnings("unchecked")
		List<UserModel> list=getSqlMapClientTemplate().queryForList("userSql.getUserByDep", userModel);
		return list;
	}
	
	@Override
	public int getUserCountByDep(int depId){
		try {
			int i=(int) getSqlMapClientTemplate().queryForObject("userSql.getUserCountByDep",depId);
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	/* （no Javadoc）
	 * <p>Title: addDep</p>
	 * <p>Description: </p>
	 * @param departmentModel
	 * @return
	 * @see cn.sh.ittc.dao.IUserDao#addDep(cn.sh.ittc.model.DepartmentModel)
	 * @author 焦冬冬
	 * @date 2014年3月24日
	 */
	@Override
	public boolean addDep(DepartmentModel departmentModel) {
		try {
			getSqlMapClientTemplate().insert("userSql.addDep", departmentModel);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	/* （no Javadoc）
	 * <p>Title: getUserById</p>
	 * <p>Description: </p>
	 * @param userId
	 * @return
	 * @see cn.sh.ittc.dao.IUserDao#getUserById(int)
	 * @author 焦冬冬
	 * @date 2014年3月24日
	 */
	@Override
	public UserModel getUserById(int userId) {
		UserModel userModel = (UserModel) getSqlMapClientTemplate()
				.queryForObject("userSql.getUserById", userId);
		return userModel;
	}

	/* （no Javadoc）
	 * <p>Title: delDepById</p>
	 * <p>Description: </p>
	 * @param departmentModel
	 * @return
	 * @see cn.sh.ittc.dao.IUserDao#delDepById(cn.sh.ittc.model.DepartmentModel)
	 * @author 焦冬冬
	 * @date 2014年4月16日
	 */
	@Override
	public boolean delDepById(DepartmentModel departmentModel) {
		try {
			getSqlMapClientTemplate().update("userSql.delUserByDepId", departmentModel);
			getSqlMapClientTemplate().update("userSql.delDepById", departmentModel);
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
	}

	/* （no Javadoc）
	 * <p>Title: initPwd</p>
	 * <p>Description: </p>
	 * @param userModel
	 * @return
	 * @see cn.sh.ittc.dao.IUserDao#initPwd(cn.sh.ittc.model.UserModel)
	 * @author 焦冬冬
	 * @date 2014年4月17日
	 */
	@Override
	public boolean initPwd(UserModel userModel) {
		try {
			getSqlMapClientTemplate().update("userSql.initPwd", userModel);
			return true;
		} catch (Exception e) {
			
			return false;
		}
		
	}

	/* （no Javadoc）
	 * <p>Title: getDepUser</p>
	 * <p>Description: </p>
	 * @return
	 * @see cn.sh.ittc.dao.IUserDao#getDepUser()
	 * @author 焦冬冬
	 * @date 2014年6月4日
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<HashMap> getDepUser() {
		try {
			List<HashMap> list=	getSqlMapClientTemplate().queryForList("userSql.getDepUser_p");
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
