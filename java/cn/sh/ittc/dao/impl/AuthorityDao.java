/**
 * <p>Title: AuthorityDao.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年6月4日
 * @version 1.0.0
 */
package cn.sh.ittc.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import cn.sh.ittc.dao.IAuthorityDao;
import cn.sh.ittc.model.AuthorityModel;
import cn.sh.ittc.model.UserAuthorityModel;

/**
 * <p>Title: AuthorityDao</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年6月4日
 */
public class AuthorityDao extends SqlMapClientDaoSupport implements IAuthorityDao {

	@Override
	public boolean addUserAuthority(UserAuthorityModel userAuthorityModel) {
		try {
			getSqlMapClientTemplate().insert("authority.addUserAuthority", userAuthorityModel);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}


	@Override
	public boolean modifyUserAuthority(UserAuthorityModel userAuthorityModel) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public UserAuthorityModel queryUserAuthority(
			UserAuthorityModel oldUserAuthorityModel) {
		// TODO Auto-generated method stub
		return null;
	}


	
	@SuppressWarnings("unchecked")
	@Override
	public List<AuthorityModel> getAllAuthority() {
		List<AuthorityModel> list=getSqlMapClientTemplate().queryForList("authority.queryAllAuthority");
		return list;
	}



	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Map> getUsedCameraByUserId(int userId, boolean isUsed) {
		try {
			Map mapParam=new HashMap<>();
			mapParam.put("userId_in", userId);
			mapParam.put("isUsed_in", isUsed);
			List<Map> list=getSqlMapClientTemplate().queryForList("authority.getGrpCameraByUserId_p", mapParam);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public String getAuthorityByUserId(int userId){
		String authoritys=(String) getSqlMapClientTemplate().queryForObject("authority.getAuthorityByUserId", userId);
		
		return authoritys;
	}


	@Override
	public boolean deleteUserAuthorityByUserId(int userId) {
		try {
			getSqlMapClientTemplate().delete("authority.deleteUserAuthorityByUserId", userId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}


	@Override
	public boolean copyAuthority(Map<String, Integer> map) {
		try {
			getSqlMapClientTemplate().insert("authority.copyUserAuthority",map);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

}
