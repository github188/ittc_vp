/**
 * <p>Title: CameraAction.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author ������
 * @date 2014��4��3��
 * @version 1.0.0
 */
package cn.sh.ittc.action;

import net.sf.json.JSONObject;
import cn.sh.ittc.model.CameraGrpModel;
import cn.sh.ittc.model.CameraModel;
import cn.sh.ittc.sdk.HCNetSDK;
import cn.sh.ittc.service.ICameraService;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.jna.NativeLong;

/**
 * <p>Title: CameraAction</p>
 * <p>Description: </p>
 * @author ������
 * @date 2014��4��3��
 */
public class CameraAction extends ActionSupport{

	private ICameraService cameraService ;
	private CameraGrpModel cameraGrpModel;
	
	private CameraModel cameraModel;
	private int grpId;//��������ID
	private int[] grpIds;//������������鼯��
	private int cameraId;//�����ID
	private int[] cameraIds;//������������IDs
	private int id;//camera_grp�е�ID
	private String errorMsg;
	private String jsonData;

	public void setCameraService(ICameraService cameraService) {
		this.cameraService = cameraService;
	}

	/** serialVersionUID */
	private static final long serialVersionUID = 3534138714766647874L;

	/**
	 * 
	 * <p>Title: getAllCameraGrp</p>
	 * <p>Description: ��ȡ��������Լ������</p>
	 * @return
	 * @author ������
	 * @date 2014��4��3��
	 */
	public String getAllCameraGrp(){
		jsonData=cameraService.getCameraInfo();
		return SUCCESS;
	}
	
	/**
	 * 
	 * <p>Title: loadCameraGrp</p>
	 * <p>Description: �����������</p>
	 * @return
	 * @author ������
	 * @date 2014��4��17��
	 */
	public String loadCameraGrp(){
		jsonData=cameraService.loadCameraGrp();
		return SUCCESS;
	}
	
	/**
	 * 
	 * <p>Title: getCameraByGrp</p>
	 * <p>Description: �������ѯ�����豸</p>
	 * @return
	 * @author ������
	 * @date 2014��4��21��
	 */
	public String getCameraByGrp(){
		jsonData=cameraService.getCameraByGrp(cameraGrpModel);
		return SUCCESS;
	}
	/**
	 * 
	 * <p>Title: delGrpCamera</p>
	 * <p>Description: ɾ��ĳ����豸</p>
	 * @return
	 * @author ������
	 * @date 2014��4��21��
	 */
	public String delGrpCamera(){
		boolean b=cameraService.delGrpCamera(cameraGrpModel);
		JSONObject jsonObject=new JSONObject();
		jsonObject.element("success", b);
		jsonData=jsonObject.toString();
		return SUCCESS;
	}
	
	/**
	 * 
	 * <p>Title: cutGrpCamera</p>
	 * <p>Description:����ĳ�������� </p>
	 * @return
	 * @author ������
	 * @date 2014��4��22��
	 */
	public String cutGrpCamera(){
		//System.out.println(id+","+grpId);
		cameraService.cutCamera2Grp(id, grpId);
		return SUCCESS;
	}
	
	/**
	 * 
	 * <p>Title: copyGrpCamera</p>
	 * <p>Description: </p>
	 * @return
	 * @author ������
	 * @date 2014��4��23��
	 */
	public String copyGrpCamera(){
		cameraService.copyCameraGrp(cameraId, grpIds);
		return SUCCESS;
	}
	
	
	public String checkCameraLogin() {
		HCNetSDK hcNetSDK = HCNetSDK.INSTANCE;
		hcNetSDK.NET_DVR_Init();
		NativeLong luserID = hcNetSDK.NET_DVR_Login_V30(
				cameraModel.getCameraIp(), (short) cameraModel.getCameraPort(),
				cameraModel.getCameraLoginName(), cameraModel.getCameraPwd(),
				new HCNetSDK.NET_DVR_DEVICEINFO_V30());
		System.out.println(luserID.longValue());
		JSONObject jsonObject = new JSONObject();
		if (luserID.longValue() > -1) {
			jsonObject.element("data", "success");

			hcNetSDK.NET_DVR_Logout_V30(luserID);
			hcNetSDK.NET_DVR_Cleanup();
		} else {
			jsonObject.element("data", "error");
		}

		return SUCCESS;
	}
	/**
	 * 
	 * <p>Title: getAllNvrInfo</p>
	 * <p>Description: </p>
	 * @return
	 * @author ������
	 * @date 2014��5��28��
	 */
	public String getAllNvrInfo(){
		jsonData=cameraService.getAllNvrInfo();
		return SUCCESS;
	}
	/**
	 * 
	 * <p>Title: getAllCamera</p>
	 * <p>Description: </p>
	 * @return
	 * @author ������
	 * @date 2014��5��28��
	 */
	public String getAllCamera(){
		jsonData=cameraService.getAllCamera();
		return SUCCESS;
	}
	/**
	 * 
	 * <p>Title: addCamera</p>
	 * <p>Description: </p>
	 * @return
	 * @author ������
	 * @date 2014��5��28��
	 */
	public String addCamera(){
		cameraService.addCamera(cameraModel);
		return SUCCESS;
	}
	/**
	 * 
	 * <p>Title: addCamera2Grp</p>
	 * <p>Description: </p>
	 * @return
	 * @author ������
	 * @date 2014��5��29��
	 */
	public String addCamera2Grp(){
		cameraService.addCamera2Grp(cameraIds, grpId);
		return SUCCESS;
	}
	
	/**
	 * 
	 * <p>Title: delCameraGrpById</p>
	 * <p>Description: </p>
	 * @return
	 * @author ������
	 * @date 2014��5��29��
	 */
	public String delCameraGrpById(){
		//System.out.println(cameraModel.getGrpId());
		cameraService.delCameraGrpByGrpId(cameraModel);
		return SUCCESS;
	}
	
	public String addCameraGrp(){
		cameraService.addCameraGrp(cameraGrpModel);
		return SUCCESS;
	}
	/**
	 * 
	 * <p>Title: delCheckedCamear</p>
	 * <p>Description: </p>
	 * @return
	 * @author ������
	 * @date 2014��7��8��
	 */
	public String delCheckedCamear(){
		JSONObject jsonObject=new JSONObject();
		for (int i  : cameraIds) {
			CameraGrpModel cameraGrpModel=new CameraGrpModel();
			cameraGrpModel.setId(i);
			boolean b=cameraService.delGrpCamera(cameraGrpModel);
			
			jsonObject.element("success", b);
			
		}
		jsonData=jsonObject.toString();
		return SUCCESS;
	}
	
	/**
	 * 
	 * <p>Title: renameCamera</p>
	 * <p>Description: </p>
	 * @return
	 * @author ������
	 * @date 2014��7��11��
	 */
	public String renameCamera(){
		cameraService.renameCamera(cameraModel);
		return SUCCESS;
	}
	
	
	
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	public CameraGrpModel getCameraGrpModel() {
		return cameraGrpModel;
	}


	public void setCameraGrpModel(CameraGrpModel cameraGrpModel) {
		this.cameraGrpModel = cameraGrpModel;
	}

	public int getGrpId() {
		return grpId;
	}

	public void setGrpId(int grpId) {
		this.grpId = grpId;
	}

	public int[] getGrpIds() {
		return grpIds;
	}

	public void setGrpIds(int[] grpIds) {
		this.grpIds = grpIds;
	}

	public int getCameraId() {
		return cameraId;
	}

	public void setCameraId(int cameraId) {
		this.cameraId = cameraId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return cameraModel
	 */
	public CameraModel getCameraModel() {
		return cameraModel;
	}

	/**
	 * @param cameraModel the cameraModel to set
	 */
	public void setCameraModel(CameraModel cameraModel) {
		this.cameraModel = cameraModel;
	}

	/**
	 * @return cameraIds
	 */
	public int[] getCameraIds() {
		return cameraIds;
	}

	/**
	 * @param cameraIds the cameraIds to set
	 */
	public void setCameraIds(int[] cameraIds) {
		this.cameraIds = cameraIds;
	}
	
	
	
	
	
}
