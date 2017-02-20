/**
 * <p>Title: IUserDao.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author ������
 * @date 2014��3��5��
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
 * @author ������
 * @date 2014��3��5��
 */
public interface IUserDao {

	/**
	 * 
	 * <p>Title: getUserByLoginName</p>
	 * <p>Description: ���ݵ�¼����ѯ�û���Ϣ</p>
	 * @param loginName
	 * @return
	 * @author ������
	 * @date 2014��3��5��
	 */
	public UserModel getUserByLoginName(String loginName);
	/**
	 * 
	 * <p>Title: addUser</p>
	 * <p>Description: ����û�</p>
	 * @param userModel
	 * @return
	 * @author ������
	 * @date 2014��3��5��
	 */
	public boolean addUser(UserModel userModel);
	
	/**
	 * 
	 * <p>Title: modifyUser</p>
	 * <p>Description: �޸��û���Ϣ</p>
	 * @param userModel
	 * @return
	 * @author ������
	 * @date 2014��3��5��
	 */
	public boolean modifyUser(UserModel userModel);
	
	/**
	 * 
	 * <p>Title: getAllDep</p>
	 * <p>Description: ��ȡ</p>
	 * @return
	 * @author ������
	 * @date 2014��3��19��
	 */
	public List<DepartmentModel> getAllDep();
	
	/**
	 * 
	 * <p>Title: getUserByDep</p>
	 * <p>Description: </p>
	 * @return
	 * @author ������
	 * @date 2014��3��19��
	 */
	public List<UserModel> getUserByDep(UserModel userModel);
	/**
	 * 
	 * <p>Title: getUserCountByDep</p>
	 * <p>Description: </p>
	 * @param depId
	 * @return
	 * @author ������
	 * @date 2014��6��24��
	 */
	public int getUserCountByDep(int depId);
	
	
	/**
	 * 
	 * <p>Title: addDep</p>
	 * <p>Description: ����û�</p>
	 * @param departmentModel
	 * @return
	 * @author ������
	 * @date 2014��3��24��
	 */
	public boolean addDep(DepartmentModel departmentModel);
	
	/**
	 * 
	 * <p>Title: getUserById</p>
	 * <p>Description:����������Ų�ѯ�û� </p>
	 * @param userId
	 * @return
	 * @author ������
	 * @date 2014��3��24��
	 */
	public UserModel getUserById(int userId);
	/**
	 * 
	 * <p>Title: delDepById</p>
	 * <p>Description: ������ɾ������</p>
	 * @param departmentModel
	 * @return
	 * @author ������
	 * @date 2014��4��16��
	 */
	public boolean delDepById(DepartmentModel departmentModel);
	/**
	 * 
	 * <p>Title: initPwd</p>
	 * <p>Description: ��ʼ������</p>
	 * @param userModel
	 * @return
	 * @author ������
	 * @date 2014��4��17��
	 */
	public boolean initPwd(UserModel userModel);
	
	@SuppressWarnings("rawtypes")
	public List<HashMap> getDepUser();
}
