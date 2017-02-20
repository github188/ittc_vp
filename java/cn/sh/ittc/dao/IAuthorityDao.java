/**
 * <p>Title: IAuthorityDao.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年6月4日
 * @version 1.0.0
 */
package cn.sh.ittc.dao;


import java.util.List;
import java.util.Map;

import cn.sh.ittc.model.AuthorityModel;
import cn.sh.ittc.model.UserAuthorityModel;

/**
 * <p>Title: IAuthorityDao</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年6月4日
 */
public interface IAuthorityDao {
	/**
	 * 
	 * <p>Title: addUserAuthority</p>
	 * <p>Description: 新加用户权限</p>
	 * @param userAuthorityModel
	 * @return
	 * @author 焦冬冬
	 * @date 2014年6月4日
	 */
	public boolean addUserAuthority(UserAuthorityModel userAuthorityModel);
	/**
	 * 
	 * <p>Title: modifyUserAuthority</p>
	 * <p>Description: 修改用户权限</p>
	 * @param userAuthorityModel
	 * @return
	 * @author 焦冬冬
	 * @date 2014年6月4日
	 */
	public boolean modifyUserAuthority(UserAuthorityModel userAuthorityModel);
	/**
	 * 
	 * <p>Title: queryUserAuthority</p>
	 * <p>Description: 查询是否存在该用户权限</p>
	 * @param oldUserAuthorityModel
	 * @return
	 * @author 焦冬冬
	 * @date 2014年6月4日
	 */
	public UserAuthorityModel queryUserAuthority(UserAuthorityModel oldUserAuthorityModel);
	/**
	 * 
	 * <p>Title: getAllAuthority</p>
	 * <p>Description: </p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年6月4日
	 */
	public List<AuthorityModel> getAllAuthority();
	/**
	 * 
	 * <p>Title: getUsedCameraByUserId</p>
	 * <p>Description: </p>
	 * @param userId
	 * @param isUsed:true,表示以及授权摄像机;false,表示未授权摄像机
	 * @return
	 * @author 焦冬冬
	 * @date 2014年6月5日
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> getUsedCameraByUserId(int userId,boolean isUsed);
	
	/**
	 * 
	 * <p>Title: getAuthorityByUserId</p>
	 * <p>Description: 根据用户查询权限</p>
	 * @param userId
	 * @return
	 * @author 焦冬冬
	 * @date 2014年6月5日
	 */
	public String getAuthorityByUserId(int userId);
	
	/**
	 * 
	 * <p>Title: deleteUserAuthorityByUserId</p>
	 * <p>Description: </p>
	 * @param userId
	 * @return
	 * @author 焦冬冬
	 * @date 2014年6月6日
	 */
	public boolean deleteUserAuthorityByUserId(int userId);
	
	/**
	 * 
	 * <p>Title: copyAuthority</p>
	 * <p>Description: </p>
	 * @param map
	 * @return
	 * @author 焦冬冬
	 * @date 2014年6月6日
	 */
	public boolean copyAuthority(Map<String, Integer> map);

}
