/**
 * <p>Title: FileDownloadAction.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年7月11日
 * @version 1.0.0
 */
package cn.sh.ittc.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import cn.sh.ittc.model.UserModel;
import cn.sh.ittc.service.IUserService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>Title: FileDownloadAction</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年7月11日
 */
public class FileDownloadAction extends ActionSupport{

	/** serialVersionUID */
	private static final long serialVersionUID = 3651266828489635825L;

	private IUserService userService;
	
	private UserModel userModel;
	private String fileName;
	
	
	public InputStream getFileStream() throws Exception{
		
		return userService.exportUserInfo2Excel(userModel);
	}
	
	
	/**
	 * 
	 * <p>Title: userInfo</p>
	 * <p>Description: </p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年7月11日
	 */
	public String userInfo(){
		
		return SUCCESS;
	}
	
	
	
	/**
	 * @return userModel
	 */
	public UserModel getUserModel() {
		return userModel;
	}
	/**
	 * @param userModel the userModel to set
	 */
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	/**
	 * @return fileName
	 */
	public String getFileName() {
		try {   
            return new String(this.fileName.getBytes(), "ISO8859-1");   
        } catch (UnsupportedEncodingException e) {   
            e.printStackTrace();   
        }   
        return fileName; 
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	/**
	 * @param userService the userService to set
	 */
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}



	
	
	
	
}
