package com.data.analysis.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.data.analysis.constant.DataTypeConstant;
import com.data.analysis.entity.env_protection.Epbparty;
import com.data.analysis.entity.env_protection.Epbparty_jkqy;
import com.data.analysis.entity.env_protection.Epbparty_zxjc;
import com.data.analysis.entity.litigation_related.*;
import com.data.analysis.entity.revenue_related.*;
import com.data.analysis.mapper.CSVMapper;
import com.data.analysis.service.CompanyQueryService;
import com.data.analysis.service.DetailsQueryService;
import com.data.analysis.utils.Object2ArrayUtils;
import com.data.analysis.utils.SignUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class DetailsQueryServiceImpl implements DetailsQueryService {
    @Autowired
    CompanyQueryService companyQueryService;
    @Autowired
    CSVMapper csvMapper;

    /**
     * baseURI
     */
    private String baseUrl = "http://monitor.fahaicc.com/request";
    @Value("${csv.file.epbparty-path}")
    String epbpartyPath;
    @Value("${csv.file.epbparty-jkqy-path}")
    String epbpartyJkqyPath;
    @Value("${csv.file.epbparty-zxjc-path}")
    String epbpartyZxjcPath;
    @Value("${csv.file.satparty-qs-path}")
    String satpartyQsPath;
    @Value("${csv.file.satparty-chufa-path}")
    String satpartyChufaPath;
    @Value("${csv.file.satparty-xin-path}")
    String satpartyXinPath;
    @Value("${csv.file.satparty-reg-path}")
    String satpartyRegPath;
    @Value("${csv.file.satparty-xuke-path}")
    String satpartyXukePath;
    @Value("${csv.file.satparty-fzc-path}")
    String satpartyFzcPath;
    @Value("${csv.file.cpws-path}")
    String cpwsPath;
    @Value("${csv.file.ktgg-path}")
    String ktggPath;
    @Value("${csv.file.zxgg-path}")
    String zxggPath;
    @Value("${csv.file.shixin-path}")
    String shixinPath;
    @Value("${csv.file.fygg-path}")
    String fyggPath;
    @Value("${csv.file.ajlc-path}")
    String ajlcPath;
    @Value("${csv.file.bgt-path}")
    String bgtPath;
    @Value("${csv.file.sifacdk-path}")
    String sifacdkPath;
    @Value("${csv.file.partys-dictionary-path}")
    String partysDictionaryPath;

    @Value("${csv.file.epbparty-title}")
    String epbpartyTitle;
    @Value("${csv.file.epbparty-jkqy-title}")
    String epbpartyJkqyTitle;
    @Value("${csv.file.epbparty-zxjc-title}")
    String epbpartyZxjcTitle;
    @Value("${csv.file.satparty-qs-title}")
    String satpartyQsTitle;
    @Value("${csv.file.satparty-chufa-title}")
    String satpartyChufaTitle;
    @Value("${csv.file.satparty-xin-title}")
    String satpartyXinTitle;
    @Value("${csv.file.satparty-reg-title}")
    String satpartyRegTitle;
    @Value("${csv.file.satparty-xuke-title}")
    String satpartyXukeTitle;
    @Value("${csv.file.satparty-fzc-title}")
    String satpartyFzcTitle;
    @Value("${csv.file.cpws-title}")
    String cpwsTitle;
    @Value("${csv.file.ktgg-title}")
    String ktggTitle;
    @Value("${csv.file.zxgg-title}")
    String zxggTitle;
    @Value("${csv.file.shixin-title}")
    String shixinTitle;
    @Value("${csv.file.fygg-title}")
    String fyggTitle;
    @Value("${csv.file.ajlc-title}")
    String ajlcTitle;
    @Value("${csv.file.bgt-title}")
    String bgtTitle;
    @Value("${csv.file.sifacdk-title}")
    String sifacdkTitle;
    @Value("${csv.file.partys-dictionary-title}")
    String partysDictionaryTitle;
    //各数据类型，用于补全路径
    private final String ENV_PROTECTION="env_protection";
    private final String LITIGATION_RELATED="litigation_related";
    private final String REVENUE_RELATED="revenue_related";
    @Override
    public void getEPDetailsQueryData(String entityId, String dataType) {

        //构建参数
        Map<String, String> paramMap = new HashMap<>();
        String rt = String.valueOf(System.currentTimeMillis());
        paramMap.put("rt", rt);//指定当前时间戳
        String uid = DataTypeConstant.uid;
        paramMap.put("uid", uid);//指定固定的uid
        String sign = SignUtil.getSign(DataTypeConstant.uid, DataTypeConstant.authCOde, rt);
        paramMap.put("sign", sign);//指定签名
        paramMap.put("api", "detail");
       // paramMap.put("action", "detail");
        JSONObject args = new JSONObject();
        args.put("resultDataType", dataType);//指定数据类型
        args.put("resultEntryId",entityId);//指定数据ID
       // args.put("range", "10");
       // args.put("pageno", "1");
        paramMap.put("args", args.toJSONString());
        JSONObject result = companyQueryService.getDataByHttp(baseUrl, paramMap);
        if (result != null) {
            JSONArray resultJSONArray = result.getJSONArray(dataType);
            //将数据写入文件
            writeFile(dataType, resultJSONArray);
        }
    }

    /**
     * 根据数据类型写入文件中
     *
     * @param dataType
     * @param results
     */
    @Async
    @Override
    public void writeFile(String dataType, JSONArray results) {
        if(results==null||results.size()<=0){
            log.info("结果集为空，不能写入文件");
            return;
        }
        for (int i = 0; i < results.size(); i++) {
            JSONObject result = results.getJSONObject(i);

            switch (dataType) {
                case DataTypeConstant.EPBPARTY://环保处罚
                    Epbparty epbparty = JSONObject.parseObject(result.toJSONString(),Epbparty.class);
                    String [] epbpartyArr = Object2ArrayUtils.epbpartyObject2Array(epbparty);
                    //根据不同的数据补全存储的路径
                    epbpartyPath=epbpartyPath.replace("#type",ENV_PROTECTION);
                    csvMapper.writeCSVFile(epbpartyPath,epbpartyTitle,epbpartyArr);
                    break;
                case DataTypeConstant.EPBPARTY_JKQY://重点监控企业名单
                    Epbparty_jkqy epbparty_jkqy = JSONObject.parseObject(result.toJSONString(),Epbparty_jkqy.class);
                    String [] epbparty_jkqyArr = Object2ArrayUtils.epbparty_jkqyObject2Array(epbparty_jkqy);
                    //根据不同的数据补全存储的路径
                    epbpartyJkqyPath=epbpartyJkqyPath.replace("#type",ENV_PROTECTION);
                    csvMapper.writeCSVFile(epbpartyJkqyPath,epbpartyJkqyTitle,epbparty_jkqyArr);
                    break;
                case DataTypeConstant.EPBPARTY_ZXJC://环保企业自行监测结果
                    Epbparty_zxjc epbparty_zxjc = JSONObject.parseObject(result.toJSONString(),Epbparty_zxjc.class);
                    String [] epbparty_zxjcArr =  Object2ArrayUtils.epbparty_zxjcObject2Array(epbparty_zxjc);
                    //根据不同的数据补全存储的路径
                    epbpartyZxjcPath=epbpartyZxjcPath.replace("#type",ENV_PROTECTION);
                    csvMapper.writeCSVFile(epbpartyZxjcPath,epbpartyZxjcTitle,epbparty_zxjcArr);
                    break;
                case DataTypeConstant.SATPARTY_QS://欠税公告
                    Satparty_qs satparty_qs = JSONObject.parseObject(result.toJSONString(),Satparty_qs.class);
                    String [] satparty_qsArr = Object2ArrayUtils.satparty_qsObject2Array(satparty_qs);
                    //根据不同的数据补全存储的路径
                    satpartyQsPath=satpartyQsPath.replace("#type",REVENUE_RELATED);
                    csvMapper.writeCSVFile(satpartyQsPath,satpartyQsTitle,satparty_qsArr);
                    break;
                case DataTypeConstant.SATPARTY_CHUFA://欠税处罚公告
                    Satparty_chufa satparty_chufa = JSONObject.parseObject(result.toJSONString(),Satparty_chufa.class);
                    String [] satparty_chufaArr = Object2ArrayUtils.satparty_chufaObject2Array(satparty_chufa);
                    //根据不同的数据补全存储的路径
                    satpartyChufaPath=satpartyChufaPath.replace("#type",REVENUE_RELATED);
                    csvMapper.writeCSVFile(satpartyChufaPath,satpartyChufaTitle,satparty_chufaArr);
                    break;
                case DataTypeConstant.SATPARTY_FZC://税务非正常户
                    Satparty_fzc satparty_fzc = JSONObject.parseObject(result.toJSONString(),Satparty_fzc.class);
                    String [] satparty_fzcArr =  Object2ArrayUtils.satparty_fzcObject2Array(satparty_fzc);
                    //根据不同的数据补全存储的路径
                    satpartyFzcPath=satpartyFzcPath.replace("#type",REVENUE_RELATED);
                    csvMapper.writeCSVFile(satpartyFzcPath,satpartyFzcTitle,satparty_fzcArr);
                    break;
                case DataTypeConstant.SATPARTY_XIN://纳税信用等级
                    Satparty_xin satparty_xin = JSONObject.parseObject(result.toJSONString(),Satparty_xin.class);
                    String [] satparty_xinArr = Object2ArrayUtils.satparty_xinObject2Array(satparty_xin);
                    //根据不同的数据补全存储的路径
                    satpartyXinPath=satpartyXinPath.replace("#type",REVENUE_RELATED);
                    csvMapper.writeCSVFile(satpartyXinPath,satpartyXinTitle,satparty_xinArr);
                    break;
                case DataTypeConstant.SATPARTY_REG://税务登记
                    Satparty_reg satparty_reg = JSONObject.parseObject(result.toJSONString(),Satparty_reg.class);
                    String [] satparty_regArr = Object2ArrayUtils.satparty_regObject2Array(satparty_reg);
                    //根据不同的数据补全存储的路径
                    satpartyRegPath=satpartyRegPath.replace("#type",REVENUE_RELATED);
                    csvMapper.writeCSVFile(satpartyRegPath,satpartyRegTitle,satparty_regArr);
                    break;
                case DataTypeConstant.SATPARTY_XUKE://税务许可
                    Satparty_xuke satparty_xuke = JSONObject.parseObject(result.toJSONString(),Satparty_xuke.class);
                    String [] satparty_xukeArr = Object2ArrayUtils.satparty_xukeObject2Array(satparty_xuke);
                    //根据不同的数据补全存储的路径
                    satpartyXukePath=satpartyXukePath.replace("#type",REVENUE_RELATED);
                    csvMapper.writeCSVFile(satpartyXukePath,satpartyXukeTitle,satparty_xukeArr);
                    break;
                case DataTypeConstant.CPWS://裁判文书
                    Cpws cpws = JSONObject.parseObject(result.toJSONString(),Cpws.class);
                    String [] cpwsArr = Object2ArrayUtils.cpwsObject2Array(cpws);
                    //根据不同的数据补全存储的路径
                    cpwsPath=cpwsPath.replace("#type",LITIGATION_RELATED);
                    csvMapper.writeCSVFile(cpwsPath,cpwsTitle,cpwsArr);
                    //将当事人字典写入另一个文件
                    JSONArray partys = result.getJSONArray("partys");
                    if(partys!=null&&partys.size()>0){
                        //获取判决文书id
                        String cpwsId= result.getString("cpwsId");
                        for(int j=0;j<partys.size();j++){
                            JSONObject partyJson = partys.getJSONObject(j);
                            partyJson.put("cpwsId",cpwsId);
                            PartyDictionary partyDictionary = JSONObject.parseObject(partyJson.toJSONString(), PartyDictionary.class);
                            String[] partsArr = Object2ArrayUtils.partyDictionaryObject2Array(partyDictionary);
                            //根据不同的数据补全存储的路径
                            partysDictionaryPath=partysDictionaryPath.replace("#type",LITIGATION_RELATED);
                            csvMapper.writeCSVFile(partysDictionaryPath,partysDictionaryTitle,partsArr);
                        }
                    }
                    break;
                case DataTypeConstant.KTGG://开庭公告
                    Ktgg ktgg = JSONObject.parseObject(result.toJSONString(),Ktgg.class);
                    String [] ktggArr = Object2ArrayUtils.ktggObject2Array(ktgg);
                    //根据不同的数据补全存储的路径
                    ktggPath=ktggPath.replace("#type",LITIGATION_RELATED);
                    csvMapper.writeCSVFile(ktggPath,ktggTitle,ktggArr);
                    break;
                case DataTypeConstant.ZXGG://执行公告
                    Zxgg zxgg = JSONObject.parseObject(result.toJSONString(),Zxgg.class);
                    String [] zxggArr = Object2ArrayUtils.zxggObject2Array(zxgg);
                    //根据不同的数据补全存储的路径
                    zxggPath=zxggPath.replace("#type",LITIGATION_RELATED);
                    csvMapper.writeCSVFile(zxggPath,zxggTitle,zxggArr);
                    break;
                case DataTypeConstant.SHIXIN://失信公告
                    Shixin shixin = JSONObject.parseObject(result.toJSONString(),Shixin.class);
                    String [] shixinArr = Object2ArrayUtils.shixinObject2Array(shixin);
                    //根据不同的数据补全存储的路径
                    shixinPath=shixinPath.replace("#type",LITIGATION_RELATED);
                    csvMapper.writeCSVFile(shixinPath,shixinTitle,shixinArr);
                    break;
                case DataTypeConstant.FYGG://法院公告
                    Fygg fygg = JSONObject.parseObject(result.toJSONString(),Fygg.class);
                    String [] fyggArr = Object2ArrayUtils.fyggObject2Array(fygg);
                    //根据不同的数据补全存储的路径
                    fyggPath=fyggPath.replace("#type",LITIGATION_RELATED);
                    csvMapper.writeCSVFile(fyggPath,fyggTitle,fyggArr);
                    break;
                case DataTypeConstant.AJLC://案件流程
                    Ajlc ajlc = JSONObject.parseObject(result.toJSONString(),Ajlc.class);
                    String [] ajlcArr = Object2ArrayUtils.ajlcObject2Array(ajlc);
                    //根据不同的数据补全存储的路径
                    ajlcPath=ajlcPath.replace("#type",LITIGATION_RELATED);
                    csvMapper.writeCSVFile(ajlcPath,ajlcTitle,ajlcArr);
                    break;
                case DataTypeConstant.BGT://曝光台
                    Bgt bgt = JSONObject.parseObject(result.toJSONString(),Bgt.class);
                    String [] bgtArr = Object2ArrayUtils.bgtObject2Array(bgt);
                    //根据不同的数据补全存储的路径
                    bgtPath=bgtPath.replace("#type",LITIGATION_RELATED);
                    csvMapper.writeCSVFile(bgtPath,bgtTitle,bgtArr);
                    break;
                case DataTypeConstant.SIFACDK://司法查冻扣
                    Sifacdk sifacdk = JSONObject.parseObject(result.toJSONString(),Sifacdk.class);
                    String [] sifacdkArr = Object2ArrayUtils.sifacdkObject2Array(sifacdk);
                    //根据不同的数据补全存储的路径
                    sifacdkPath=sifacdkPath.replace("#type",LITIGATION_RELATED);
                    csvMapper.writeCSVFile(sifacdkPath,sifacdkTitle,sifacdkArr);
                    break;
                default:
                    break;
            }
        }
    }


}
