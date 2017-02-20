/**
 * <p>Title: UserAuthorityModel.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author ������
 * @date 2014��5��30��
 * @version 1.0.0
 */
package cn.sh.ittc.model;

/**
 * <p>Title: UserAuthorityModel</p>
 * <p>Description: </p>
 * @author ������
 * @date 2014��5��30��
 */
public class UserAuthorityModel {
	
	private int id;
	private int userId;
	private String userName;
	private String authorityIds;//��������ݿ⣬��","�ֿ�
	private String cameraId;//��������ݿ⣬��","�ֿ�
	private String grpName;

	public UserAuthorityModel(){
		
	}
	public UserAuthorityModel(int userId,String authorityIds){
		this.userId=userId;
		this.authorityIds=authorityIds;
	}
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return authorityIds
	 */
	public String getAuthorityIds() {
		return authorityIds;
	}
	/**
	 * @param authorityIds the authorityIds to set
	 */
	public void setAuthorityIds(String authorityIds) {
		this.authorityIds = authorityIds;
	}
	/**
	 * @return cameraId
	 */
	public String getCameraId() {
		return cameraId;
	}
	/**
	 * @param cameraId the cameraId to set
	 */
	public void setCameraId(String cameraId) {
		this.cameraId = cameraId;
	}
	/**
	 * @return grpName
	 */
	public String getGrpName() {
		return grpName;
	}
	/**
	 * @param grpName the grpName to set
	 */
	public void setGrpName(String grpName) {
		this.grpName = grpName;
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
	public String toString(){
		
		return "userId:" + this.userId +",userName:"+this.userName+ ",authorityIds:" + this.authorityIds
				+ ",cameraId:" + this.cameraId + ",grpName:" + this.grpName;
	}

}
