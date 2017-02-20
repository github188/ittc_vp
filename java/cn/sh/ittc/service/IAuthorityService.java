/**
 * <p>Title: IAuthorityService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年5月30日
 * @version 1.0.0
 */
package cn.sh.ittc.service;

import cn.sh.ittc.model.UserAuthorityModel;

/**
 * <p>Title: IAuthorityService</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年5月30日
 */
public interface IAuthorityService {
	
	/**
	 * 
	 * <p>Title: saveOrUpdateUserAuthority</p>
	 * <p>Description: </p>
	 * @param authorityModel
	 * @param json
	 * @return
	 * @author 焦冬冬
	 * @date 2014年6月4日
	 */
	public boolean saveOrUpdateUserAuthority(UserAuthorityModel authorityModel,String json);
	
	/**
	 * 
	 * <p>Title: getAllAuthority</p>
	 * <p>Description: </p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年6月4日
	 */
	public String getAllAuthority();
	/**
	 * 
	 * <p>Title: getCameraByUserId</p>
	 * <p>Description: </p>
	 * @param userId
	 * @return
	 * @author 焦冬冬
	 * @date 2014年6月5日
	 */
	public String getCameraByUserId(int userId);
	/**
	 * 
	 * <p>Title: copyAuthority</p>
	 * <p>Description: </p>
	 * @param userId
	 * @param copyUserIdstr
	 * @return
	 * @author 焦冬冬
	 * @date 2014年6月6日
	 */
	public String copyAuthority(int userId, String copyUserIdstr);

}
