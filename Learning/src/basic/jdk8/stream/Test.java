package basic.jdk8.stream;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        List<CensProjProcessFileVo> applyFiles = new ArrayList<CensProjProcessFileVo>();
        String postResult = "{\"msg\":\"message has been sent successfully\",\"dataList\":[{\"appDataAtchLinkAddr\":\"ALAPPL_00_558c8223882248658dcc0dacc7f0c8f2.doc\",\"appDataAtchName\":\"731doc正常 .doc\",\"appDataFileType\":\"2\",\"appDataId\":\"0bb35c50178e4b54beae5d9f1ab4b40a\",\"appDataName\":\"2-3 发行人股东大会有关本次发行的决议\",\"appDataRelId\":\"c3739daf66814b19a43a281fe56112b2\",\"dataBeginSrcCde\":\"1\",\"foundTime\":{\"date\":24,\"day\":2,\"hour s\":11,\"minutes\":5,\"month\":10,\"seconds\":52,\"time\":1606187152000,\"timezoneOffset\":-480,\"year\":120}},{\"appDataAtchLinkAddr\":\"ALAPPL_00_d61081f8ebb145c39eb6cb57309ef486.pdf\",\"appDataAtchName\":\"SSLVPNCT客户端配置手册.pdf\",\"appDataFileType\":\" 1\",\"appDataId\":\"0bb35c50178e4b54beae5d9f1ab4b40a\",\"appDataName\":\"2-3 发行人股东大会有关本次发行的决议\",\"appDataRelId\":\"c3739daf66814b19a43a281fe56112b2\",\"dataBeginSrcCde\":\"1\",\"foundTime\":{\"date\":24,\"day\":2,\"hours\":11,\"minutes\":5,\"month\":10,\"seconds\":22,\"time\":1606187122000,\"timezoneOffset\":-480,\"year\":120}},{\"appDataAtchLinkAddr\":\"ALAPPL_00_d61081f8ebb145c39eb6cb57309ef486.pdf\",\"appDataAtchName\":\"SSLVPNCT客户端配置手册AAAAA.pdf\",\"appDataFileType\":\" 1\",\"appDataId\":\"0bb35c50178e4b54beae5d9f1ab4b40a\",\"appDataName\":\"2-3 发行人股东大会有关本次发行的决议\",\"appDataRelId\":\"c3739daf66814b19a43a281fe56112b2\",\"dataBeginSrcCde\":\"1\",\"foundTime\":{\"date\":24,\"day\":2,\"hours\":11,\"minutes\":5,\"month\":10,\"seconds\":35,\"time\":1606187135000,\"timezoneOffset\":-480,\"year\":120}}],\"resultFlag\":\"1\"}";
        Map<?, ?> parseMap = (Map<?, ?>) JSONObject.parse(postResult);
        List<?> datalist = (List<?>) parseMap.get("dataList");
        for (Object item : datalist) {
            Map<?, ?> map = (Map<?, ?>) item;
            if (map.get("appDataAtchLinkAddr") != null && map.get("appDataAtchName") != null) {
                String attaTabId = map.get("appDataAtchLinkAddr").toString();
                String attaName = map.get("appDataAtchName").toString();
                CensProjProcessFileVo vo = new CensProjProcessFileVo();
                vo.setAttaTabId(attaTabId);
                vo.setAttaName(attaName);
                if (map.get("dataBeginSrcCde") != null) {
                    String dataBeginSrcCde = map.get("dataBeginSrcCde").toString();
                    vo.setDataBeginSrcCde(dataBeginSrcCde);
                }
                if (map.get("tmbkPsnName") != null) {
                    String tmbkPsnName = map.get("tmbkPsnName").toString();
                    vo.setUserName(tmbkPsnName);
                }
                if (map.get("lastAlterTime") != null) {
                    String lastAlterTime = map.get("lastAlterTime").toString();
                    long time = JSON.parseObject(lastAlterTime).getLong("time");
                    vo.setUploadTime(new Date(time));
                }
                if (map.get("foundTime") != null) {
                    String foundTime = map.get("foundTime").toString();
                    long time = JSON.parseObject(foundTime).getLong("time");
                    vo.setFoundTime(new Date(time));
                }
                if (map.get("appDataName") != null) {
                    String appDataName = map.get("appDataName").toString();
                    vo.setMaterialName(appDataName);
                }
                if (map.get("appDataId") != null) {
                    String appDataId = map.get("appDataId").toString();
                    vo.setAppDataId(appDataId);
                }
                if (map.get("appDataFileType") != null) {
                    String appDataFileType = map.get("appDataFileType").toString();
                    vo.setAppDataFileType(appDataFileType);
                }
                applyFiles.add(vo);
            }
        }


        Map<String, Map<String, CensProjProcessFileVo>> collect =
                applyFiles.stream().collect(Collectors.groupingBy(CensProjProcessFileVo::getAppDataId,
                        Collectors.groupingBy(CensProjProcessFileVo::getAppDataFileType,
                                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(CensProjProcessFileVo::getFoundTime)),
                                        Optional::get))));


        List<CensProjProcessFileVo> resultFiles = new ArrayList<CensProjProcessFileVo>();
        for (Map.Entry<String, Map<String, CensProjProcessFileVo>> entry : collect.entrySet()) {
            Collection<CensProjProcessFileVo> values = entry.getValue().values();
            if (CollectionUtils.isNotEmpty(values))
                resultFiles.addAll(values);
        }
        System.out.println(resultFiles);
    }
}
