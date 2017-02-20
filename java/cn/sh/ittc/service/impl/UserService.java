/**
 * <p>Title: UserServer.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author ������
 * @date 2014��3��5��
 * @version 1.0.0
 */
package cn.sh.ittc.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.sh.ittc.dao.IUserDao;
import cn.sh.ittc.model.DepartmentModel;
import cn.sh.ittc.model.UserModel;
import cn.sh.ittc.service.IUserService;
import cn.sh.ittc.uitls.PropertyUitls;
import cn.sh.ittc.uitls.SessionUtils;

/**
 * <p>Title: UserServer</p>
 * <p>Description: </p>
 * @author ������
 * @date 2014��3��5��
 */
public class UserService implements IUserService {

	private IUserDao userDao;
	
	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int checkLogin(String loginName, String loginPwd) {
		UserModel userModel = userDao.getUserByLoginName(loginName);
		//System.out.println(userModel.getLoginPwd());
		if (userModel == null) {
			return 1;// �û������ڣ�
		} else if (userModel != null
				&& userModel.getLoginPwd().equals(loginPwd)) {
			if(userModel.getUserType()==2){//���Ա
				return 3;//û��Ȩ��
			}
			return 0;//��½�ɹ�
		}else {
			return 2;//�������
		}
		
	}

	@Override
	public boolean addUser(UserModel userModel) {
		//��ӳ�ʼ����
		userModel.setLoginPwd(PropertyUitls.getInitPwd());
		return	userDao.addUser(userModel);
	}

	@Override
	public boolean modifyUser(UserModel userModel) {
		return userDao.modifyUser(userModel);

	}

	@Override
	public UserModel getUserByLoginName(String loginName) {
		UserModel userModel=userDao.getUserByLoginName(loginName);
		return userModel;
	}

	@Override
	public List<DepartmentModel> getAllDep() {
		
		return userDao.getAllDep();
	}

	@Override
	public String getUserByDep(UserModel userModel) {
		
		List<UserModel> list= userDao.getUserByDep(userModel);
		int count=userDao.getUserCountByDep(userModel.getDepId());
//		System.out.println(count);
		JSONObject jsonObject=new JSONObject();
		jsonObject.element("data", list);
		jsonObject.element("count", ((count-1)/userModel.getShowNum())+1);
		return jsonObject.toString();
	}

	@Override
	public boolean addDep(DepartmentModel departmentModel) {
		return userDao.addDep(departmentModel);
	}

	@Override
	public UserModel getUserById(int userId) {
		
		return userDao.getUserById(userId);
	}

	@Override
	public boolean delDepById(DepartmentModel departmentModel) {
		return userDao.delDepById(departmentModel);
	}


	@Override
	public boolean initPwd(UserModel userModel) {
		userModel.setLoginPwd(PropertyUitls.getInitPwd());
		return userDao.initPwd(userModel);
		//return false;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String getDepUser() {
		List<HashMap> list=userDao.getDepUser();
		JSONObject jsonObject=new JSONObject();
		jsonObject.element("data", list);
		return jsonObject.toString();
	}


	@Override
	public InputStream exportUserInfo2Excel(UserModel userModel) throws Exception {
		XSSFWorkbook book = new XSSFWorkbook();// ����һ��excel
		XSSFSheet sheet = book.createSheet("�û���Ϣ");// ����һ��sheetҳ
		Row row = sheet.createRow(0);// ����һ��
		sheet.setColumnWidth(0, 10* 256);
		row.createCell(0).setCellValue("���");
		sheet.setColumnWidth(1, 20 * 256);
		row.createCell(1).setCellValue("�û���");
		sheet.setColumnWidth(2, 20 * 256);
		row.createCell(2).setCellValue("����");
		sheet.setColumnWidth(3, 20 * 256);
		row.createCell(3).setCellValue("����");
		
		List<UserModel> list=userDao.getUserByDep(userModel);
		for (UserModel user : list) {
			Row rowLog = sheet.createRow(user.getRownum());// ����һ��
			rowLog.createCell(0).setCellValue(user.getRownum());
			rowLog.createCell(1).setCellValue(user.getLoginName().toString());
			rowLog.createCell(2).setCellValue(user.getUserName().toString());
			rowLog.createCell(3).setCellValue("��ͨ�û�");
		}


		File file = new File("temp.xlsx");
		OutputStream os = new FileOutputStream(file);
		book.write(os);
		os.close();
		InputStream is = null;
		is = new FileInputStream(file);
		return is;
	}

	@Override
	public String modifyPwd(String oldPwd, String newPwd) {
		JSONObject jsonObject=new JSONObject();
		UserModel userModel=SessionUtils.getUserSession();
		if(userModel.getLoginPwd().equals(oldPwd)){
			userModel.setLoginPwd(newPwd);
			jsonObject.element("success", userDao.modifyUser(userModel));
		}else {
			jsonObject.element("success", false);
		}
		return jsonObject.toString();
	}

	

}
