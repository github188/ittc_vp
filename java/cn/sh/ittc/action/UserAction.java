/**
 * <p>Title: UserAction.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年2月18日
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
 * @author 焦冬冬
 * @date 2014年2月18日
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
		
		System.out.println("===============登陆，不拦截=============");
		
		int i = userService.checkLogin(userModel.getLoginName(),
				userModel.getLoginPwd());
		if (i == 0) {
			userModel=userService.getUserByLoginName(userModel.getLoginName());
			SessionUtils.putUserSession(userModel);
			return SUCCESS;
		} else {
			if(i==1){
				errorMsg="该用户无权限操作！";
			}else if(i==2){
				errorMsg="用户密码错误！";
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
	 * <p>Description: 获取所有的部门</p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年3月19日
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
	 * <p>Description: 根据部门查询该部门下的成员</p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年3月20日
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
	 * @author 焦冬冬
	 * @date 2014年3月24日
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
	 * <p>Description: 批量删除</p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年3月20日
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
	 * <p>Description: 非物理删除部门</p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年4月16日
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
	 * <p>Description: 添加部门</p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年3月24日
	 */
	public String addDepartment(){
		userService.addDep(departmentModel);
		return SUCCESS;
	}
	
	/**
	 * 
	 * <p>Title: addUser</p>
	 * <p>Description:添加用户 </p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年3月24日
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
	 * @author 焦冬冬
	 * @date 2014年3月24日
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
	 * @author 焦冬冬
	 * @date 2014年4月17日
	 */
	public String modifyUser(){
		userService.modifyUser(userModel);
		return SUCCESS;
	}
	
	/**
	 * 
	 * <p>Title: initPwd</p>
	 * <p>Description: 初始化密码</p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年4月17日
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
	 * <p>Description: 获取所有的部门及成员</p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年6月4日
	 */
	public String getDepUser(){
		jsonData=userService.getDepUser();
		return SUCCESS;
	}
	
	/**
	 * 
	 * <p>Title: modifyPwd</p>
	 * <p>Description:修改密码 </p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年7月11日
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
