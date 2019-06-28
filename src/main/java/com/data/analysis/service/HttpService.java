package com.data.analysis.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.data.analysis.utils.HttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static java.lang.Integer.getInteger;

@Slf4j
@Component
public class HttpService {


    private final String requestUrl ="http://monitor.fahaice.com/request";
    //成功返回的状态码
    private final String  SUCCESS_CODE = "s";
    /**
     * 调用http接口获取数据
     * @return
     */
    public JSONObject GetDataByHttp(int pageNo){
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
        JSONObject result = HttpClientUtils.httpPost(requestUrl + "?uid=${uid}&api=result&rt=${rt}&args=${args}&sign=${sign}",
                json.toJSONString());
        String code = result.getString("code");
        //判断是否返回成功
        if(!SUCCESS_CODE.equals(code)){
            return null;
        }
        return result;*/
       //是有模拟数据进行测试
       String costomValue= "{	\"allList\":[		{			\"anyou\":\"anyou\",\"caseNo\":\"caseNo\",\"court\":\"court\",\"resultAmount\":1234,\"resultDataType\":\"resultDataType\",\"resultEntryId\":\"resultEntryId\",\"resultLevel\":1,\"resultName\":\"resultName\",\"resultSummary\":\"resultSummary\",\"resultYmd\":\"2019-01-02\"			},		{			\"anyou\":\"anyou1\",\"caseNo\":\"caseNo1\",\"court\":\"court1\",\"resultAmount\":1234,\"resultDataType\":\"resultDataType1\",\"resultEntryId\":\"resultEntryId1\",\"resultLevel\":1,\"resultName\":\"resultName1\",\"resultSummary\":\"resultSummary1\",\"resultYmd\":\"2019-01-02\"		}	],	\"code\":\"s\",	\"msg\":\"s\",	\"pageno\":1,	\"range\":\"s\",	\"totalCount\":30,	\"totalPage\":3}";
        JSONObject object = JSONObject.parseObject(costomValue);
        return object;
    }


    /**
     * 第一次先去获取总的页数
     * @return
     */
   public Integer getTotalCount(){
       JSONObject result = GetDataByHttp(1);
       if(result==null){
           log.info("获取数据失败！");
           return 0;
       }
       return  result.getInteger("totalPage");
   }
}
