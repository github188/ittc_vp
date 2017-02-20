/**
 * <p>Title: ICameraService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author ������
 * @date 2014��4��3��
 * @version 1.0.0
 */
package cn.sh.ittc.service;

import java.util.List;

import cn.sh.ittc.model.CameraGrpModel;
import cn.sh.ittc.model.CameraModel;

/**
 * <p>Title: ICameraService</p>
 * <p>Description: </p>
 * @author ������
 * @date 2014��4��3��
 */
public interface ICameraService {
	/**
	 * 
	 * <p>Title: getAllCameraGrp</p>
	 * <p>Description:��ѯ���е�������� </p>
	 * @return
	 * @author ������
	 * @date 2014��4��3��
	 */
	public List<CameraGrpModel> getAllCameraGrp();
	/**
	 * 
	 * <p>Title: getCameraByGrp</p>
	 * <p>Description: �����������id��ѯ����������</p>
	 * @param grpId
	 * @return
	 * @author ������
	 * @date 2014��4��3��
	 */
	public List<CameraModel> getCameraByGrp(int grpId);
	/**
	 * 
	 * <p>Title: getCameraInfo</p>
	 * <p>Description: </p>
	 * @return
	 * @author ������
	 * @date 2014��4��3��
	 */
	public String getCameraInfo();
	/**
	 * 
	 * <p>Title: loadCameraGrp</p>
	 * <p>Description: �����������</p>
	 * @return
	 * @author ������
	 * @date 2014��4��17��
	 */
	public String loadCameraGrp();
	/**
	 * 
	 * <p>Title: getCameraByGrp</p>
	 * <p>Description: �������ѯ�����</p>
	 * @param cameraGrpModel
	 * @return
	 * @author ������
	 * @date 2014��4��17��
	 */
	public String getCameraByGrp(CameraGrpModel cameraGrpModel);
	/**
	 * 
	 * <p>Title: delGrpCamera</p>
	 * <p>Description: ����idɾ�������µ�ĳ�����</p>
	 * @param cameraGrpModel
	 * @return
	 * @author ������
	 * @date 2014��4��21��
	 */
	public boolean delGrpCamera(CameraGrpModel cameraGrpModel);
	/**
	 * 
	 * <p>Title: cutCamera2Grp</p>
	 * <p>Description: </p>
	 * @param id
	 * @param grpId
	 * @return
	 * @author ������
	 * @date 2014��4��22��
	 */
	public boolean cutCamera2Grp(int id,int grpId);
	/**
	 * 
	 * <p>Title: copyCameraGrp</p>
	 * <p>Description: </p>
	 * @param cameraId
	 * @param grpIds
	 * @return
	 * @author ������
	 * @date 2014��4��23��
	 */
	public boolean copyCameraGrp(int cameraId, int[] grpIds);
	/**
	 * 
	 * <p>Title: getAllNvrInfo</p>
	 * <p>Description: ��ȡNVR��Ϣ</p>
	 * @return
	 * @author ������
	 * @date 2014��5��28��
	 */
	public String getAllNvrInfo();
	/**
	 * 
	 * <p>Title: getAllCamera</p>
	 * <p>Description: </p>
	 * @return
	 * @author ������
	 * @date 2014��5��28��
	 */
	public String getAllCamera();
	/**
	 * 
	 * <p>Title: addCamera</p>
	 * <p>Description: </p>
	 * @param cameraModel
	 * @return
	 * @author ������
	 * @date 2014��5��28��
	 */
	public boolean addCamera(CameraModel cameraModel);
	/**
	 * 
	 * <p>Title: addCamera2Grp</p>
	 * <p>Description: </p>
	 * @param cameras
	 * @param grpId
	 * @return
	 * @author ������
	 * @date 2014��5��29��
	 */
	public boolean addCamera2Grp(int[] cameras,int grpId );
	/**
	 * 
	 * <p>Title: delCameraGrpByGrpId</p>
	 * <p>Description: ����grpIdɾ�������µ�����������͸���</p>
	 * @param cameraModel
	 * @return
	 * @author ������
	 * @date 2014��5��29��
	 */
	public boolean delCameraGrpByGrpId(CameraModel cameraModel);
	/**
	 * 
	 * <p>Title: addCameraGrp</p>
	 * <p>Description: </p>
	 * @param cameraGrpModel
	 * @return
	 * @author ������
	 * @date 2014��5��29��
	 */
	public boolean addCameraGrp(CameraGrpModel cameraGrpModel);
	/**
	 * 
	 * <p>Title: renameCamera</p>
	 * <p>Description: </p>
	 * @param cameraModel
	 * @return
	 * @author ������
	 * @date 2014��7��11��
	 */
	public boolean renameCamera(CameraModel cameraModel);
}
