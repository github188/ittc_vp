/**
 * <p>Title: CameraAction.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年4月3日
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
 * @author 焦冬冬
 * @date 2014年4月3日
 */
public class CameraAction extends ActionSupport{

	private ICameraService cameraService ;
	private CameraGrpModel cameraGrpModel;
	
	private CameraModel cameraModel;
	private int grpId;//摄像机组的ID
	private int[] grpIds;//复制是摄像机组集合
	private int cameraId;//摄像机ID
	private int[] cameraIds;//添加已有摄像机IDs
	private int id;//camera_grp中的ID
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
	 * <p>Description: 获取摄像机组以及摄像机</p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年4月3日
	 */
	public String getAllCameraGrp(){
		jsonData=cameraService.getCameraInfo();
		return SUCCESS;
	}
	
	/**
	 * 
	 * <p>Title: loadCameraGrp</p>
	 * <p>Description: 加载摄像机组</p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年4月17日
	 */
	public String loadCameraGrp(){
		jsonData=cameraService.loadCameraGrp();
		return SUCCESS;
	}
	
	/**
	 * 
	 * <p>Title: getCameraByGrp</p>
	 * <p>Description: 根据组查询该组设备</p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年4月21日
	 */
	public String getCameraByGrp(){
		jsonData=cameraService.getCameraByGrp(cameraGrpModel);
		return SUCCESS;
	}
	/**
	 * 
	 * <p>Title: delGrpCamera</p>
	 * <p>Description: 删除某组的设备</p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年4月21日
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
	 * <p>Description:剪切某组的摄像机 </p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年4月22日
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
	 * @author 焦冬冬
	 * @date 2014年4月23日
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
	 * @author 焦冬冬
	 * @date 2014年5月28日
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
	 * @author 焦冬冬
	 * @date 2014年5月28日
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
	 * @author 焦冬冬
	 * @date 2014年5月28日
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
	 * @author 焦冬冬
	 * @date 2014年5月29日
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
	 * @author 焦冬冬
	 * @date 2014年5月29日
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
	 * @author 焦冬冬
	 * @date 2014年7月8日
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
	 * @author 焦冬冬
	 * @date 2014年7月11日
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
