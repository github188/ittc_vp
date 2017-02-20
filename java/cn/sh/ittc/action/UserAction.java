/**
 * <p>Title: UserAction.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author ������
 * @date 2014��2��18��
 * @version 1.0.0
 */
package cn.sh.ittc.action;

import java.util.List;

import net.sf.json.JSONObject;
import cn.sh.ittc.model.DepartmentModel;
import cn.sh.ittc.model.UserModel;
import cn.sh.ittc.service.IUserService;
import cn.sh.ittc.uitls.SessionUtils;

import com.opensymphony.xwork2.ActionSupport;


/**
 * <p>Title: UserAction</p>
 * <p>Description: </p>
 * @author ������
 * @date 2014��2��18��
 */
public class UserAction extends ActionSupport{

	/** serialVersionUID */
	private static final long serialVersionUID = 6186772137583035177L;
	private String errorMsg;
	private String jsonData;
	private UserModel userModel;
	private DepartmentModel departmentModel;
	private int[] userIds;
	private String oldPwd;
	private String newPwd;
	
	private IUserService userService;
	public String login() {
		
		System.out.println("===============��½��������=============");
		
		int i = userService.checkLogin(userModel.getLoginName(),
				userModel.getLoginPwd());
		if (i == 0) {
			userModel=userService.getUserByLoginName(userModel.getLoginName());
			SessionUtils.putUserSession(userModel);
			return SUCCESS;
		} else {
			if(i==1){
				errorMsg="���û���Ȩ�޲�����";
			}else if(i==2){
				errorMsg="�û��������";
			}
			return ERROR;
		}
	}

	public String getNameByLogin(){
		jsonData="123456";
		return SUCCESS;
	}
	
	
	/**
	 * 
	 * <p>Title: getAllDep</p>
	 * <p>Description: ��ȡ���еĲ���</p>
	 * @return
	 * @author ������
	 * @date 2014��3��19��
	 */
	public String getAllDep() {
		List<DepartmentModel> list=userService.getAllDep();
		JSONObject jsonObject=new JSONObject();
		jsonObject.element("data", list);
		jsonData=jsonObject.toString();
		System.out.println(jsonData);
		return SUCCESS;
	}
	
	/**
	 * 
	 * <p>Title: getUserByDep</p>
	 * <p>Description: ���ݲ��Ų�ѯ�ò����µĳ�Ա</p>
	 * @return
	 * @author ������
	 * @date 2014��3��20��
	 */
	public  String getUserByDep(){
		jsonData=userService.getUserByDep(userModel);
		
		return SUCCESS;
	}
	
	/**
	 * 
	 * <p>Title: delUserById</p>
	 * <p>Description: </p>
	 * @return
	 * @author ������
	 * @date 2014��3��24��
	 */
	public String delUserById(){
		JSONObject jsonObject=new JSONObject();
		if(userService.modifyUser(userModel)){
			jsonObject.element("date", "success");
		}else {
			jsonObject.element("data", "error");
		}
		jsonData=jsonObject.toString();
		return SUCCESS;
	}
	
	/**
	 * 
	 * <p>Title: delUsers</p>
	 * <p>Description: ����ɾ��</p>
	 * @return
	 * @author ������
	 * @date 2014��3��20��
	 */
	public String delUsers(){
		JSONObject jsonObject=new JSONObject();
		for (int i : userIds) {
			UserModel userModelTemp=new UserModel();
			userModelTemp.setIsDel(1);
			userModelTemp.setUserId(i);
			if(userService.modifyUser(userModelTemp)){
			}else {
				jsonObject.element("data", "error");
				jsonData=jsonObject.toString();
				return SUCCESS;
			}
		}
		jsonObject.element("date", "success");
		jsonData=jsonObject.toString();
		
	
		return SUCCESS;
	}
	/**
	 * 
	 * <p>Title: delDepById</p>
	 * <p>Description: ������ɾ������</p>
	 * @return
	 * @author ������
	 * @date 2014��4��16��
	 */
	public String delDepById(){
		//System.out.println(departmentModel.getDepId());
		boolean b=userService.delDepById(departmentModel);
		JSONObject jsonObject=new JSONObject();
		jsonObject.element("success", b);
		jsonData=jsonObject.toString();
		System.out.println(jsonData);
		return SUCCESS;
	}
	/**
	 * 
	 * <p>Title: addDepartment</p>
	 * <p>Description: ��Ӳ���</p>
	 * @return
	 * @author ������
	 * @date 2014��3��24��
	 */
	public String addDepartment(){
		userService.addDep(departmentModel);
		return SUCCESS;
	}
	
	/**
	 * 
	 * <p>Title: addUser</p>
	 * <p>Description:����û� </p>
	 * @return
	 * @author ������
	 * @date 2014��3��24��
	 */
	public String addUser(){
		userService.addUser(userModel);
		return SUCCESS;
	}
	/**
	 * 
	 * <p>Title: getUserById</p>
	 * <p>Description: </p>
	 * @return
	 * @author ������
	 * @date 2014��3��24��
	 */
	public String getUserById(){
		JSONObject jsonObject=new JSONObject();
		jsonObject.element("data", userService.getUserById(userModel.getUserId()));
		jsonData=jsonObject.toString();
		return SUCCESS;
	}
	/**
	 * 
	 * <p>Title: modifyUser</p>
	 * <p>Description: </p>
	 * @return
	 * @author ������
	 * @date 2014��4��17��
	 */
	public String modifyUser(){
		userService.modifyUser(userModel);
		return SUCCESS;
	}
	
	/**
	 * 
	 * <p>Title: initPwd</p>
	 * <p>Description: ��ʼ������</p>
	 * @return
	 * @author ������
	 * @date 2014��4��17��
	 */
	public String initPwd(){
		boolean b=userService.initPwd(userModel);
		JSONObject jsonObject=new JSONObject();
		jsonObject.element("success", b);
		jsonData=jsonObject.toString();
		return SUCCESS;
	}
	/**
	 * 
	 * <p>Title: getDepUser</p>
	 * <p>Description: ��ȡ���еĲ��ż���Ա</p>
	 * @return
	 * @author ������
	 * @date 2014��6��4��
	 */
	public String getDepUser(){
		jsonData=userService.getDepUser();
		return SUCCESS;
	}
	
	/**
	 * 
	 * <p>Title: modifyPwd</p>
	 * <p>Description:�޸����� </p>
	 * @return
	 * @author ������
	 * @date 2014��7��11��
	 */
	public String modifyPwd(){
		jsonData=userService.modifyPwd(oldPwd, newPwd);
		return SUCCESS;
	}
	
	
	
	
	
	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public String getJsonData() {
		return jsonData;
	}

	
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	/**
	 * @return departmentModel
	 */
	public DepartmentModel getDepartmentModel() {
		return departmentModel;
	}

	/**
	 * @param departmentModel the departmentModel to set
	 */
	public void setDepartmentModel(DepartmentModel departmentModel) {
		this.departmentModel = departmentModel;
	}

	/**
	 * @return userIds
	 */
	public int[] getUserIds() {
		return userIds;
	}

	/**
	 * @param userIds the userIds to set
	 */
	public void setUserIds(int[] userIds) {
		this.userIds = userIds;
	}

	/**
	 * @return oldPwd
	 */
	public String getOldPwd() {
		return oldPwd;
	}

	/**
	 * @param oldPwd the oldPwd to set
	 */
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	/**
	 * @return newPwd
	 */
	public String getNewPwd() {
		return newPwd;
	}

	/**
	 * @param newPwd the newPwd to set
	 */
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}


	
}
