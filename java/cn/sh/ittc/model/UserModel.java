/**
 * <p>Title: UserModel.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年2月18日
 * @version 1.0.0
 */
package cn.sh.ittc.model;

/**
 * <p>Title: UserModel</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年2月18日
 */
public class UserModel {

	private int rownum;
	private int userId;
	private String loginName;
	private String loginPwd;
	private String userName;
	private int userType;
	private int depId;
	private String depName;
	private int isDel;//0:正常，1：删除，2：冻结
	
	private int startPage=0;//起始页码
	private int showNum=10;//一页显示的条数
	
	
	/**
	 * @return rownum
	 */
	public int getRownum() {
		return rownum;
	}
	/**
	 * @param rownum the rownum to set
	 */
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	/**
	 * @return userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return loginName
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * @return loginPwd
	 */
	public String getLoginPwd() {
		return loginPwd;
	}
	/**
	 * @param loginPwd the loginPwd to set
	 */
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return userType
	 */
	public int getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(int userType) {
		this.userType = userType;
	}
	/**
	 * @return depId
	 */
	public int getDepId() {
		return depId;
	}
	/**
	 * @param depId the depId to set
	 */
	public void setDepId(int depId) {
		this.depId = depId;
	}
	/**
	 * @return isDel
	 */
	public int getIsDel() {
		return isDel;
	}
	/**
	 * @param isDel the isDel to set
	 */
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	/**
	 * @return startPage
	 */
	public int getStartPage() {
		return startPage;
	}
	/**
	 * @param startPage the startPage to set
	 */
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	/**
	 * @return showNum
	 */
	public int getShowNum() {
		return showNum;
	}
	/**
	 * @param showNum the showNum to set
	 */
	public void setShowNum(int showNum) {
		this.showNum = showNum;
	}
	/**
	 * @return depName
	 */
	public String getDepName() {
		return depName;
	}
	/**
	 * @param depName the depName to set
	 */
	public void setDepName(String depName) {
		this.depName = depName;
	}

	

	
	
	
}
