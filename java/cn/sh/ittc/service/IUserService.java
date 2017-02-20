/**
 * <p>Title: IUserServer.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author ������
 * @date 2014��3��5��
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
 * @author ������
 * @date 2014��3��5��
 */
public interface IUserService {
	
	/**
	 * 
	 * <p>Title: checkLogin</p>
	 * <p>Description:���ݵ�¼����������֤��½�Ƿ�ɹ� </p>
	 * @param loginName
	 * @param loginPwd
	 * @return
	 * @author ������
	 * @date 2014��3��5��
	 */
	public int checkLogin(String loginName,String loginPwd);
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
	 * <p>Title: getUserByLoginName</p>
	 * <p>Description: </p>
	 * @param loginName
	 * @return
	 * @author ������
	 * @date 2014��3��19��
	 */
	public UserModel getUserByLoginName(String loginName);
	
	/**
	 * 
	 * <p>Title: getAllDep</p>
	 * <p>Description: </p>
	 * @return ��ȡ���еĲ���
	 * @author ������
	 * @date 2014��3��19��
	 */
	public List<DepartmentModel> getAllDep();
	
	/**
	 * 
	 * <p>Title: getUserByDep</p>
	 * <p>Description: </p>
	 * @param userModel
	 * @return
	 * @author ������ modify
	 * @date 2014��6��24��
	 */
	public String getUserByDep(UserModel userModel);
	
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
	 * <p>Description: </p>
	 * @param userId
	 * @return
	 * @author ������
	 * @date 2014��3��24��
	 */
	public UserModel getUserById(int userId);
	/**
	 * 
	 * <p>Title: delDepById</p>
	 * <p>Description: </p>
	 * @param departmentModel
	 * @return
	 * @author ������
	 * @date 2014��4��16��
	 */
	public boolean delDepById(DepartmentModel departmentModel);
	
	/**
	 * 
	 * <p>Title: initPwd</p>
	 * <p>Description: </p>
	 * @param userModel
	 * @return
	 * @author ������
	 * @date 2014��4��17��
	 */
	public boolean initPwd(UserModel userModel);
	
	public String getDepUser();
	/**
	 * 
	 * <p>Title: exportUserInfo2Excel</p>
	 * <p>Description: </p>
	 * @param userModel
	 * @return
	 * @author ������
	 * @throws Exception 
	 * @date 2014��7��11��
	 */
	public InputStream exportUserInfo2Excel(UserModel userModel) throws Exception;
	/**
	 * 
	 * <p>Title: modifyPwd</p>
	 * <p>Description: </p>
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 * @author ������
	 * @date 2014��7��11��
	 */
	public String modifyPwd(String oldPwd,String newPwd);
}
