/**
 * <p>Title: AuthorityModel.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年6月4日
 * @version 1.0.0
 */
package cn.sh.ittc.model;

/**
 * <p>Title: AuthorityModel</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年6月4日
 */
public class AuthorityModel {
	
	private int authorityId;//权限编号
	private String authorityName;//权限名称
	private String authorityDesc;//权限描述
	private int authorityLevel;//权限等级
	private String checked;//是否有默认权限

	/**
	 * @return authorityId
	 */
	public int getAuthorityId() {
		return authorityId;
	}

	/**
	 * @param authorityId the authorityId to set
	 */
	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
	}

	/**
	 * @return authorityName
	 */
	public String getAuthorityName() {
		return authorityName;
	}

	/**
	 * @param authorityName the authorityName to set
	 */
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	/**
	 * @return authorityDesc
	 */
	public String getAuthorityDesc() {
		return authorityDesc;
	}

	/**
	 * @param authorityDesc the authorityDesc to set
	 */
	public void setAuthorityDesc(String authorityDesc) {
		this.authorityDesc = authorityDesc;
	}

	/**
	 * @return authorityLevel
	 */
	public int getAuthorityLevel() {
		return authorityLevel;
	}

	/**
	 * @param authorityLevel the authorityLevel to set
	 */
	public void setAuthorityLevel(int authorityLevel) {
		this.authorityLevel = authorityLevel;
	}

	/**
	 * @return checked
	 */
	public String getChecked() {
		return checked;
	}

	/**
	 * @param checked the checked to set
	 */
	public void setChecked(String checked) {
		this.checked = checked;
	}




	
	
	

}
