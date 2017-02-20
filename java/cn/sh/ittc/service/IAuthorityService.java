/**
 * <p>Title: IAuthorityService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author ������
 * @date 2014��5��30��
 * @version 1.0.0
 */
package cn.sh.ittc.service;

import cn.sh.ittc.model.UserAuthorityModel;

/**
 * <p>Title: IAuthorityService</p>
 * <p>Description: </p>
 * @author ������
 * @date 2014��5��30��
 */
public interface IAuthorityService {
	
	/**
	 * 
	 * <p>Title: saveOrUpdateUserAuthority</p>
	 * <p>Description: </p>
	 * @param authorityModel
	 * @param json
	 * @return
	 * @author ������
	 * @date 2014��6��4��
	 */
	public boolean saveOrUpdateUserAuthority(UserAuthorityModel authorityModel,String json);
	
	/**
	 * 
	 * <p>Title: getAllAuthority</p>
	 * <p>Description: </p>
	 * @return
	 * @author ������
	 * @date 2014��6��4��
	 */
	public String getAllAuthority();
	/**
	 * 
	 * <p>Title: getCameraByUserId</p>
	 * <p>Description: </p>
	 * @param userId
	 * @return
	 * @author ������
	 * @date 2014��6��5��
	 */
	public String getCameraByUserId(int userId);
	/**
	 * 
	 * <p>Title: copyAuthority</p>
	 * <p>Description: </p>
	 * @param userId
	 * @param copyUserIdstr
	 * @return
	 * @author ������
	 * @date 2014��6��6��
	 */
	public String copyAuthority(int userId, String copyUserIdstr);

}
