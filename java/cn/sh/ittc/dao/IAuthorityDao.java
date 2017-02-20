/**
 * <p>Title: IAuthorityDao.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author ������
 * @date 2014��6��4��
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
 * @author ������
 * @date 2014��6��4��
 */
public interface IAuthorityDao {
	/**
	 * 
	 * <p>Title: addUserAuthority</p>
	 * <p>Description: �¼��û�Ȩ��</p>
	 * @param userAuthorityModel
	 * @return
	 * @author ������
	 * @date 2014��6��4��
	 */
	public boolean addUserAuthority(UserAuthorityModel userAuthorityModel);
	/**
	 * 
	 * <p>Title: modifyUserAuthority</p>
	 * <p>Description: �޸��û�Ȩ��</p>
	 * @param userAuthorityModel
	 * @return
	 * @author ������
	 * @date 2014��6��4��
	 */
	public boolean modifyUserAuthority(UserAuthorityModel userAuthorityModel);
	/**
	 * 
	 * <p>Title: queryUserAuthority</p>
	 * <p>Description: ��ѯ�Ƿ���ڸ��û�Ȩ��</p>
	 * @param oldUserAuthorityModel
	 * @return
	 * @author ������
	 * @date 2014��6��4��
	 */
	public UserAuthorityModel queryUserAuthority(UserAuthorityModel oldUserAuthorityModel);
	/**
	 * 
	 * <p>Title: getAllAuthority</p>
	 * <p>Description: </p>
	 * @return
	 * @author ������
	 * @date 2014��6��4��
	 */
	public List<AuthorityModel> getAllAuthority();
	/**
	 * 
	 * <p>Title: getUsedCameraByUserId</p>
	 * <p>Description: </p>
	 * @param userId
	 * @param isUsed:true,��ʾ�Լ���Ȩ�����;false,��ʾδ��Ȩ�����
	 * @return
	 * @author ������
	 * @date 2014��6��5��
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> getUsedCameraByUserId(int userId,boolean isUsed);
	
	/**
	 * 
	 * <p>Title: getAuthorityByUserId</p>
	 * <p>Description: �����û���ѯȨ��</p>
	 * @param userId
	 * @return
	 * @author ������
	 * @date 2014��6��5��
	 */
	public String getAuthorityByUserId(int userId);
	
	/**
	 * 
	 * <p>Title: deleteUserAuthorityByUserId</p>
	 * <p>Description: </p>
	 * @param userId
	 * @return
	 * @author ������
	 * @date 2014��6��6��
	 */
	public boolean deleteUserAuthorityByUserId(int userId);
	
	/**
	 * 
	 * <p>Title: copyAuthority</p>
	 * <p>Description: </p>
	 * @param map
	 * @return
	 * @author ������
	 * @date 2014��6��6��
	 */
	public boolean copyAuthority(Map<String, Integer> map);

}
