package com.data.analysis.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.data.analysis.service.HttpService;
import com.data.analysis.utils.HttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import static java.lang.Integer.getInteger;

@Slf4j
@Service
public class HttpServiceImpl implements HttpService{

    /**
     * 获取公司案件的URI
     */
    private final String getCompanyCaseUrl ="http://monitor.fahaice.com/request";

    /**
     * 获取涉诉标准数据的URI
     */
    private final String litigationRelatedUrl = "https://api.fahaicc.com/v2/query/sifa?authCode=授权码&rt=1550713588185&sign=f317204d08d48b9ffacc3da";
    //成功返回的状态码
    private final String  SUCCESS_CODE = "s";


    @Override
    public JSONObject getLitigationRelated(int pageNo) {
        /*//构建json参数
        JSONObject json = new JSONObject();
        json.put("dataType","cpws");
        json.put("keyword","小米");
        json.put("pageno",pageNo);
        json.put("range",10);
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("args",json.toJSONString());
        //构建请求url
        String url= litigationRelatedUrl;
        //发送get 请求获取数据
        String resultStr = HttpClientUtils.doGet(url, paramMap);
        JSONObject result = JSONObject.parseObject(resultStr);
        String code = result.getString("code");
        //判断是否返回成功
        if(!SUCCESS_CODE.equals(code)){
            log.info("获取涉诉标准数据不成功");
            return null;
        }
        return result;*/
        String resultStr ="{\"ajlcCount\":2,\"ajlcPageNum\":1,\"allList\":[{\"body\":\"...公司（以下简称XX公司...\",\"dataType\":\"cpws\",\"entryId\":\"c20181102minxiazhong518_t20180628@5YyX5Lqs5YWs5Y%2B4\",\"sortTime\":1530115200000,\"sortTimeString\":\"2018年06月28日\",\"title\":\"陈XX与X有限公司损害公司利益责任纠纷民事裁定书\"},{\"body\":\"...院对XX公司...\",\"dataType\":\"fygg\",\"entryId\":\"zgy6657337@5YyX5Lqs5YWs5Y%2B4\",\"sortTime\":1529510400000,\"sortTimeString\":\"\",\"title\":\"当事人:中国XX北京公司,北京XX有限公司,北京XX有限公司\"}],\"bgtCount\":2,\"bgtPageNum\":1,\"code\":\"s\",\"cpwsCount\":2,\"cpwsPageNum\":1,\"fyggCount\":2,\"fyggPageNum\":1,\"ktggCount\":2,\"ktggPageNum\":1,\"msg\":\"成功返回\",\"pageNo\":1,\"range\":10,\"searchSeconds\":2.162,\"shixinCount\":2,\"shixinPageNum\":1,\"totalCount\":16,\"totalPageNum\":2,\"zxggCount\":2,\"zxggPageNum\":1}";
        JSONObject object = JSONObject.parseObject(resultStr);
        return object;
    }


    @Override
    public int  getLitigationRelatedTotalPage() {
        JSONObject result = getLitigationRelated(1);
        if(result==null){
            log.info("获取涉诉标准数据数据失败！");
            return 0;
        }
        return  result.getInteger("totalPageNum");
    }



    /**
     * 调用http接口获取数据
     * @return
     */
    public JSONObject getCompanyCase(int pageNo){
       /* //构建请求参数
        JSONObject json = new JSONObject();
       if (pageNo<1){
           json.put("pageno",1);
       }else {
           json.put("pageno",pageNo);
       }
        json.put("range", 10);
        json.put("resultLevel", 1);
        json.put("pname","阿里巴巴集团" );
        json.put("resultDataType", "cpws");
        json.put("costomGroupId",1 );
        json.put("createDate", "20170505-20190505");

        log.info("开始调用 接口获取数据,当前获取第【{}】数据,总页数为【{}】",pageNo);
        JSONObject result = HttpClientUtils.httpPost(getCompanyCaseUrl+ "?uid=${uid}&api=result&rt=${rt}&args=${args}&sign=${sign}",
                json.toJSONString());
        String code = result.getString("code");
        //判断是否返回成功
        if(!SUCCESS_CODE.equals(code)){
            return null;
        }
        return result;*/
       //模拟数据进行测试
       String costomValue= "{	\"allList\":[		{			\"anyou\":\"anyou\",\"caseNo\":\"caseNo\",\"court\":\"court\",\"resultAmount\":1234,\"resultDataType\":\"resultDataType\",\"resultEntryId\":\"resultEntryId\",\"resultLevel\":1,\"resultName\":\"resultName\",\"resultSummary\":\"resultSummary\",\"resultYmd\":\"2019-01-02\"			},		{			\"anyou\":\"anyou1\",\"caseNo\":\"caseNo1\",\"court\":\"court1\",\"resultAmount\":1234,\"resultDataType\":\"resultDataType1\",\"resultEntryId\":\"resultEntryId1\",\"resultLevel\":1,\"resultName\":\"resultName1\",\"resultSummary\":\"resultSummary1\",\"resultYmd\":\"2019-01-02\"		}	],	\"code\":\"s\",	\"msg\":\"s\",	\"pageno\":1,	\"range\":\"s\",	\"totalCount\":30,	\"totalPage\":3}";
        JSONObject object = JSONObject.parseObject(costomValue);
        return object;
    }




    /**
     * 第一次先去获取总的页数
     * @return
     */
   public int getCompanyCaseTotalPage(){
       JSONObject result = getCompanyCase(1);
       if(result==null){
           log.info("获取公司案件数据失败！");
           return 0;
       }
       return  result.getInteger("totalPage");
   }
}
