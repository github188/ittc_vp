/**
 * <p>Title: DepartmentModel.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年3月19日
 * @version 1.0.0
 */
package cn.sh.ittc.model;

/**
 * <p>Title: DepartmentModel</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年3月19日
 */
public class DepartmentModel {
	private int rownum;
	private int depId;
	private String depName;
	private String depDesc;
	
	
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
	/**
	 * @return depDesc
	 */
	public String getDepDesc() {
		return depDesc;
	}
	/**
	 * @param depDesc the depDesc to set
	 */
	public void setDepDesc(String depDesc) {
		this.depDesc = depDesc;
	}
	
	

}
