package basic.jdk8.stream;

import java.util.Date;
import java.util.List;

public class CensProjProcessFileVo {
    @Override
    public String toString() {
        return "CensProjProcessFileVo{" +
                "attaTabId='" + attaTabId + '\'' +
                ", attaName='" + attaName + '\'' +
                ", uploadTime=" + uploadTime +
                ", foundTime=" + foundTime +
                ", appDataId='" + appDataId + '\'' +
                ", timeOrde=" + timeOrde +
                ", appDataFileType='" + appDataFileType + '\'' +
                '}';
    }

    /**
     * 标题（文件首列展示，如“财务上传”、“非财务上传”）
     */
    private String       title;
    /**
     * 文件唯一标识
     */
    private String       attaTabId;
    /**
     * 文件名
     */
    private String       attaName;
    /**
     * 更新时间
     */
    private Date         uploadTime;
    /**
     * 更新时间
     */
    private Date         foundTime;
    /**
     * 用户ID
     */
    private String       userId;
    /**
     * 用户名
     */
    private String       userName;
    /**
     * 备注
     */
    private String       memo;
    /**
     * 文件父类型
     */
    private String       prnClasCdVal;
    /**
     * 文件小类型
     */
    private String       fileCdVal;
    
    /**
     * 发行申请事项标识
     */
    private String       issAppPiecId;
    /**
     * 项目编号
     */
    private String       projectNo;
    /**
     * 流程实例号
     */
    private String       activitiProcInstId;
    /**
     * 任务id
     */
    private String       activitiTaskId;
    /**
     * 流程节点编号
     */
    private String       taskDefKey;
    /**
     * 可否上传附件
     */
    private Boolean      canUpload     = Boolean.FALSE;
    /**
     * 文件状态 文件状态01-待审核02-正式03-废弃04-历史
     */
    private String       fileStat;
    /**
     * 项目过程文件表标识
     */
    private String       proProcessFileId;
    /**
     * 审核文件的材料名称/过程文件：其他通知回复的文件名称
     */
    private String       materialName;
    /**
     * 项目审核文件表标识
     */
    private String       auditFileId;
    private List<String> fileSmallTypeList;
    /**
     * 是否必须上传文件
     */
    private Boolean      necessary     = Boolean.FALSE;
    /**
     * 是否是审核文件
     */
    private Boolean      auditFileFlag = Boolean.FALSE;

    /**
     * 发审委委员决定：无审核意见；无聆讯问题
     */
    private String aprvOperRslt;

    private String meetId;

    private String fileId;

    private String dataBeginSrcCde;

    private String auditFileUpload;

    private String smitTime;
    private String dicNameForFileCdVal;

//    private Integer showOrder;
//    private String  appDataCde;
//    private String  appDataSbmtdCde;
//    private String  supvAppDataCde;
//    private String  appDataLvlCde;
    /**
     * 轮次
     */
    private String  rounds;
    /**
     * 文件格式类型代码:01- text
     * 02- pdf
     * 03- docx
     */
    private String  fileFormTypeCd;

    /**
     * 目录id
     */
    private String       appDataId;

    /**
     * 时间排序
     */
    private Long       timeOrde;

    /**
     * 申请材料文件类型
     */
    private String       appDataFileType;


    public String getAppDataFileType() {
        return appDataFileType;
    }

    public void setAppDataFileType(String appDataFileType) {
        this.appDataFileType = appDataFileType;
    }

    public Long getTimeOrde() {
        return timeOrde;
    }

    public void setTimeOrde(Long timeOrde) {
        this.timeOrde = timeOrde;
    }

    public String getAppDataId() {
        return appDataId;
    }

    public void setAppDataId(String appDataId) {
        this.appDataId = appDataId;
    }

    public Date getFoundTime() {
        return foundTime == null ? null : foundTime;
    }

    public void setFoundTime(Date foundTime) {
        this.foundTime = foundTime == null ? null : foundTime;
    }

    public String getDicNameForFileCdVal() {
        return dicNameForFileCdVal;
    }

    public void setDicNameForFileCdVal(String dicNameForFileCdVal) {
        this.dicNameForFileCdVal = dicNameForFileCdVal;
    }

    public String getFileFormTypeCd() {
        return fileFormTypeCd;
    }

    public void setFileFormTypeCd(String fileFormTypeCd) {
        this.fileFormTypeCd = fileFormTypeCd;
    }

    public String getRounds() {
        return rounds;
    }

    public void setRounds(String rounds) {
        this.rounds = rounds;
    }

    public String getSmitTime() {
        return smitTime;
    }

    public void setSmitTime(String smitTime) {
        this.smitTime = smitTime;
    }

    public Boolean isAuditFileFlag() {
        return auditFileFlag;
    }

    public void setAuditFileFlag(Boolean auditFileFlag) {
        this.auditFileFlag = auditFileFlag;
    }

//    public String getAppDataLvlCde() {
//        return appDataLvlCde;
//    }
//
//    public void setAppDataLvlCde(String appDataLvlCde) {
//        this.appDataLvlCde = appDataLvlCde;
//    }
//
//    public String getSupvAppDataCde() {
//        return supvAppDataCde;
//    }
//
//    public void setSupvAppDataCde(String supvAppDataCde) {
//        this.supvAppDataCde = supvAppDataCde;
//    }
//
//    public String getAppDataSbmtdCde() {
//        return appDataSbmtdCde;
//    }
//
//    public void setAppDataSbmtdCde(String appDataSbmtdCde) {
//        this.appDataSbmtdCde = appDataSbmtdCde;
//    }
//
//    public String getAppDataCde() {
//        return appDataCde;
//    }
//
//    public void setAppDataCde(String appDataCde) {
//        this.appDataCde = appDataCde;
//    }
//
//    public Integer getShowOrder() {
//        return showOrder;
//    }
//
//    public void setShowOrder(Integer showOrder) {
//        this.showOrder = showOrder;
//    }

    public String getDataBeginSrcCde() {
        return dataBeginSrcCde;
    }

    public void setDataBeginSrcCde(String dataBeginSrcCde) {
        this.dataBeginSrcCde = dataBeginSrcCde;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getMeetId() {
        return meetId;
    }

    public void setMeetId(String meetId) {
        this.meetId = meetId;
    }

    public List<String> getFileSmallTypeList() {
        return fileSmallTypeList == null ? null : fileSmallTypeList;
    }

    public void setFileSmallTypeList(List<String> fileSmallTypeList) {
        this.fileSmallTypeList = fileSmallTypeList == null ? null : fileSmallTypeList;
    }

    public Boolean getNecessary() {
        return necessary;
    }

    public void setNecessary(Boolean necessary) {
        this.necessary = necessary;
    }

    public String getAuditFileId() {
        return auditFileId;
    }

    public void setAuditFileId(String auditFileId) {
        this.auditFileId = auditFileId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getIssAppPiecId() {
        return issAppPiecId;
    }

    public void setIssAppPiecId(String issAppPiecId) {
        this.issAppPiecId = issAppPiecId;
    }

    public String getProProcessFileId() {
        return proProcessFileId;
    }

    public void setProProcessFileId(String proProcessFileId) {
        this.proProcessFileId = proProcessFileId;
    }

    public String getFileStat() {
        return fileStat;
    }

    public void setFileStat(String fileStat) {
        this.fileStat = fileStat;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCanUpload() {
        return canUpload;
    }

    public void setCanUpload(Boolean canUpload) {
        this.canUpload = canUpload;
    }

    public String getAttaTabId() {
        return attaTabId;
    }

    public void setAttaTabId(String attaTabId) {
        this.attaTabId = attaTabId;
    }

    public String getAttaName() {
        return attaName;
    }

    public void setAttaName(String attaName) {
        this.attaName = attaName;
    }

    public Date getUploadTime() {
        return uploadTime == null ? null : uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime == null ? null : uploadTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getPrnClasCdVal() {
        return prnClasCdVal;
    }

    public void setPrnClasCdVal(String prnClasCdVal) {
        this.prnClasCdVal = prnClasCdVal;
    }

    public String getFileCdVal() {
        return fileCdVal;
    }

    public void setFileCdVal(String fileCdVal) {
        this.fileCdVal = fileCdVal;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getActivitiProcInstId() {
        return activitiProcInstId;
    }

    public void setActivitiProcInstId(String activitiProcInstId) {
        this.activitiProcInstId = activitiProcInstId;
    }

    public String getActivitiTaskId() {
        return activitiTaskId;
    }

    public void setActivitiTaskId(String activitiTaskId) {
        this.activitiTaskId = activitiTaskId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTaskDefKey() {
        return taskDefKey;
    }

    public void setTaskDefKey(String taskDefKey) {
        this.taskDefKey = taskDefKey;
    }

    public String getAprvOperRslt() {
        return aprvOperRslt;
    }

    public void setAprvOperRslt(String aprvOperRslt) {
        this.aprvOperRslt = aprvOperRslt;
    }

    public String getAuditFileUpload() {
        return auditFileUpload;
    }

    public void setAuditFileUpload(String auditFileUpload) {
        this.auditFileUpload = auditFileUpload;
    }

}
