/**
 * <p>Title: WarningTypeModel.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年7月11日
 * @version 1.0.0
 */
package cn.sh.ittc.model;

import java.util.Date;

/**
 * <p>Title: WarningTypeModel</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年7月11日
 */
public class WarningLogModel {
	
	private int id;
	private String warningType;
	private String warningFrom;
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
	 * @return warningType
	 */
	public String getWarningType() {
		return warningType;
	}
	/**
	 * @param warningType the warningType to set
	 */
	public void setWarningType(String warningType) {
		this.warningType = warningType;
	}
	/**
	 * @return warningFrom
	 */
	public String getWarningFrom() {
		return warningFrom;
	}
	/**
	 * @param warningFrom the warningFrom to set
	 */
	public void setWarningFrom(String warningFrom) {
		this.warningFrom = warningFrom;
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
	

}
