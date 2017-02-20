/**
 * <p>Title: ICameraDao.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author ������
 * @date 2014��4��3��
 * @version 1.0.0
 */
package cn.sh.ittc.dao;

import java.util.List;

import cn.sh.ittc.model.CameraGrpModel;
import cn.sh.ittc.model.CameraModel;
import cn.sh.ittc.model.NvrModel;

/**
 * <p>Title: ICameraDao</p>
 * <p>Description: </p>
 * @author ������
 * @date 2014��4��3��
 */
public interface ICameraDao {
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
	 * <p>Title: delGrpCamera</p>
	 * <p>Description:���� </p>
	 * @param id
	 * @return
	 * @author ������
	 * @date 2014��4��21��
	 */
	public boolean delGrpCameraById(int id);
	/**
	 * 
	 * <p>Title: cutCameraGrp</p>
	 * <p>Description: ���������</p>
	 * @param id
	 * @param grpId
	 * @return
	 * @author ������
	 * @date 2014��4��22��
	 */
	public boolean cutCameraGrp(int id,int grpId);
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
	public boolean copyCameraGrp(int cameraId,int[] grpIds);
	/**
	 * 
	 * <p>Title: getAllNvrInfo</p>
	 * <p>Description: ��ȡnvr��Ϣ</p>
	 * @return
	 * @author ������
	 * @date 2014��5��28��
	 */
	public List<NvrModel> getAllNvrInfo();
	/**
	 * 
	 * <p>Title: getAllCamera</p>
	 * <p>Description: ��ȡ���е������</p>
	 * @return
	 * @author ������
	 * @date 2014��5��28��
	 */
	public List<CameraModel> getAllCamera();
	/**
	 * 
	 * <p>Title: addCamera</p>
	 * <p>Description: </p>
	 * @param cameraModel
	 * @return
	 * @author ������
	 * @date 2014��5��28��
	 */
	public int addCamera(CameraModel cameraModel);
	/**
	 * 
	 * <p>Title: addCamera_grp</p>
	 * <p>Description: </p>
	 * @param cameraMode
	 * @return
	 * @author ������
	 * @date 2014��5��28��
	 */
	public boolean addCamera_grp(CameraModel cameraMode);
	/**
	 * 
	 * <p>Title: addCamera2Nvr</p>
	 * <p>Description: </p>
	 * @param cameraModel
	 * @return
	 * @author ������
	 * @date 2014��5��29��
	 */
	public boolean addCamera2Nvr(CameraModel cameraModel);
	/**
	 * 
	 * <p>Title: queryCamera_Grp</p>
	 * <p>Description: </p>
	 * @param cameraModel
	 * @return
	 * @author ������
	 * @date 2014��5��29��
	 */
	public boolean queryCamera_Grp(CameraModel cameraModel);
	
	/**
	 * 
	 * <p>Title: delCamera_GrpByGrpId</p>
	 * <p>Description: ������IDɾ�������µ����������</p>
	 * @param cameraModel
	 * @return
	 * @author ������
	 * @date 2014��5��29��
	 */
	public boolean delCamera_GrpByGrpId(CameraModel cameraModel);
	/**
	 * 
	 * <p>Title: delCameraGrpByGrpId</p>
	 * <p>Description:������IDɾ������ </p>
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
