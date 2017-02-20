/**
 * <p>Title: AuthorityAction.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年5月30日
 * @version 1.0.0
 */
package cn.sh.ittc.action;


import cn.sh.ittc.model.UserAuthorityModel;
import cn.sh.ittc.service.IAuthorityService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>Title: AuthorityAction</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年5月30日
 */
public class AuthorityAction extends ActionSupport{

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	private String jsonData;
	private UserAuthorityModel userAuthorityModel;
	
	private String copyUserIds;//复制的成员id

	
	private IAuthorityService authorityService;
	
	/**
	 * 
	 * <p>Title: modifyUserAuthority</p>
	 * <p>Description: </p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年6月6日
	 */
	public String modifyUserAuthority(){
		authorityService.saveOrUpdateUserAuthority(userAuthorityModel,jsonData);
		return SUCCESS;
	}
	/**
	 * 
	 * <p>Title: getAllAuthority</p>
	 * <p>Description: </p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年6月3日
	 */
	public String getAllAuthority(){
		jsonData=authorityService.getAllAuthority();
		
		return SUCCESS;
	}
	/**
	 * 
	 * <p>Title: getCameraByUserId</p>
	 * <p>Description: </p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年6月5日
	 */
	public String getCameraByUserId() {
		jsonData = authorityService.getCameraByUserId(userAuthorityModel
				.getUserId());
		return SUCCESS;
	}
	/**
	 * 
	 * <p>Title: copyAuthority</p>
	 * <p>Description: </p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年6月6日
	 */
	public String copyAuthority(){
		authorityService.copyAuthority(userAuthorityModel.getUserId(), copyUserIds);
		return SUCCESS;
	}
	
	
	/**
	 * @return jsonData
	 */
	public String getJsonData() {
		return jsonData;
	}

	/**
	 * @param jsonData the jsonData to set
	 */
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}


	/**
	 * @param authorityService the authorityService to set
	 */
	public void setAuthorityService(IAuthorityService authorityService) {
		this.authorityService = authorityService;
	}


	/**
	 * @param userAuthorityModel the userAuthorityModel to set
	 */
	public void setUserAuthorityModel(UserAuthorityModel userAuthorityModel) {
		this.userAuthorityModel = userAuthorityModel;
	}


	/**
	 * @return userAuthorityModel
	 */
	public UserAuthorityModel getUserAuthorityModel() {
		return userAuthorityModel;
	}

	/**
	 * @return copyUserIds
	 */
	public String getCopyUserIds() {
		return copyUserIds;
	}

	/**
	 * @param copyUserIds the copyUserIds to set
	 */
	public void setCopyUserIds(String copyUserIds) {
		this.copyUserIds = copyUserIds;
	}


	
	
	
}
