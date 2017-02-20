/**
 * <p>Title: SysLogModel.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年6月11日
 * @version 1.0.0
 */
package cn.sh.ittc.model;

import java.util.Date;



/**
 * <p>Title: SysLogModel</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年6月11日
 */
public class SysLogModel {
	
	public String tableName;
	public int id;
	public String depName;
	public String userName;
	public Date startTime;
	public Date endTime;
	public Date happenTime;
	public String showTime;
	public String content;
	public int startPage=0;//起始页
	public int showNum=10;//显示多少条
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
	 * @return startTime
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return endTime
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return happenTime
	 */
	public Date getHappenTime() {
		return happenTime;
	}
	/**
	 * @param happenTime the happenTime to set
	 */
	public void setHappenTime(Date happenTime) {
		this.happenTime = happenTime;
	}
	/**
	 * @return content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
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
	 * @return showTime
	 */
	public String getShowTime() {
		return showTime;
	}
	/**
	 * @param showTime the showTime to set
	 */
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	
	
	
	/**
	 * @return tableName
	 */
	public String getTableName() {
		return tableName;
	}
	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String toString(){
		System.out.println(new Date());
		return "id:"+this.id+",depName:"+this.depName+",userName:"+this.userName+",startTime:"+this.startTime+",endTime:"+endTime;
	}

}
