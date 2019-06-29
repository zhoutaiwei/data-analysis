package com.data.analysis.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.data.analysis.service.HttpService;
import com.data.analysis.utils.HttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.getInteger;

@Slf4j
@Service
public class HttpServiceImpl implements HttpService {

    /**
     * 获取公司案件的URI
     */
    private final String getCompanyCaseUrl = "http://monitor.fahaice.com/request";

    /**
     * 获取涉诉标准数据的URI
     */
    private final String litigationRelatedUrl = "https://api.fahaicc.com/v2/query/sifa?authCode=授权码&rt=1550713588185&sign=f317204d08d48b9ffacc3da";

    /**
     * 获取涉税标准数据的URI
     */
    private final String revenueRelatedUrl = "https://api.fahaicc.com/v2/query/sat?authCode=授权码&rt=1550737462806&sign=c493f220f3a4585f7e8fda9e98f63";

    //成功返回的状态码
    private final String SUCCESS_CODE = "s";


    @Override
    public JSONObject getEnvProtection(final int pageNo) {
       /* //构建参数
        JSONObject json = new JSONObject();
        json.put("dataType", "cpws");
        json.put("keyword", "小米");
        json.put("pageno", pageNo);
        json.put("range", 10);
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("args", json.toJSONString());
        return getDataByHttp(revenueRelatedUrl,paramMap,pageNo);*/
        String resultStr="{\"allList\":[{\"body\":\"{监测项目=化学需氧量（COD...\",\"dataType\":\"epbparty_zxjc\",\"entryId\":\"tl_98434d84b1b65af5147abcaec7255458@cG5hbWU6ZXhpc3Rz\",\"sortTime\":5007801600000,\"sortTimeString\":\"\",\"title\":\"旬邑县城市污水处理厂\"},{\"body\":\"{处罚单位=昌邑市宏宇铸业有限...\",\"dataType\":\"epbparty\",\"entryId\":\"tl_a9c784f6b8e28049984e51839717b6d8@cG5hbWU6ZXhpc3Rz\",\"sortTime\":4340016000000,\"sortTimeString\":\"2107年07月14日\",\"title\":\"监管记录内容\"}],\"code\":\"s\",\"epbpartyCount\":2,\"epbpartyPageNum\":1,\"epbparty_jkqyCount\":2,\"epbparty_jkqyPageNum\":1,\"epbparty_zxjcCount\":2,\"epbparty_zxjcPageNum\":1,\"msg\":\"成功返回\",\"pageNo\":1,\"range\":10,\"searchSeconds\":1.481,\"totalCount\":6,\"totalPageNum\":1}";
        JSONObject object = JSONObject.parseObject(resultStr);
        return object;
    }

    @Override
    public int getEnvProtectionTotalPage() {
        JSONObject result = getEnvProtection(1);
        if (result == null) {
            log.info("获取环保标准数据失败！");
            return 0;
        }
        return result.getInteger("totalPageNum");
    }

    @Override
    public JSONObject getRevenueRelated(final int pageNo) {
       /* //构建参数
        JSONObject json = new JSONObject();
        json.put("dataType", "cpws");
        json.put("keyword", "小米");
        json.put("pageno", pageNo);
        json.put("range", 10);
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("args", json.toJSONString());
        return getDataByHttp(revenueRelatedUrl,paramMap,pageNo);*/
        String resultStr="{\"ajlcCount\":2,\"ajlcPageNum\":1,\"allList\":[{\"body\":\"{限缴日期=,序号=38,...\",\"dataType\":\"satparty_qs\",\"entryId\":\"tl_f8c66096d73ee19044d7d228d9c43237@cG5hbWU6ZXhpc3Rz\",\"sortTime\":214271625600000,\"sortTimeString\":\"2016年01月01日\",\"title\":\"苏州地税局2016年4季度《欠税公告》（200万以上欠税）\"},{\"body\":\"{行政处罚决定书文号=洪国税红...\",\"dataType\":\"satparty_chufa\",\"entryId\":\"tl_ec8dc70035430f93eaea7c3956316225@cG5hbWU6ZXhpc3Rz\",\"sortTime\":1567699200000,\"sortTimeString\":\"2017年09月06日\",\"title\":\"【南昌市】红谷滩新区国家税务局行政处罚事项公示（2017年9月4日-9月8日）\"}],\"code\":\"s\",\"msg\":\"成功返回\",\"pageNo\":1,\"range\":10,\"satparty_chufaCount\":2,\"satparty_chufaPageNum\":1,\"satparty_fzcCount\":2,\"satparty_fzcPageNum\":1,\"satparty_qsCount\":2,\"satparty_qsPageNum\":1,\"satparty_regCount\":2,\"satparty_regPageNum\":1,\"satparty_xinCount\":2,\"satparty_xinPageNum\":1,\"satparty_xukeCount\":2,\"satparty_xukePageNum\":1,\"searchSeconds\":0.362,\"totalCount\":12,\"totalPageNum\":2}";
        JSONObject object = JSONObject.parseObject(resultStr);
        return object;
    }

    /**
     * 获取涉税总页数
     * @return
     */
    @Override
    public int getRevenueRelatedTotalPage() {
        JSONObject result = getRevenueRelated(1);
        if (result == null) {
            log.info("获取涉诉标准数据失败！");
            return 0;
        }
        return result.getInteger("totalPageNum");
    }

    public JSONObject getLitigationRelated(int pageNo) {
        //构建参数
        JSONObject json = new JSONObject();
        json.put("dataType", "cpws");
        json.put("keyword", "小米");
        json.put("pageno", pageNo);
        json.put("range", 10);
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("args", json.toJSONString());
        return getDataByHttp(litigationRelatedUrl,paramMap,pageNo);
        //涉诉模拟数据
       /* String resultStr ="{\"ajlcCount\":2,\"ajlcPageNum\":1,\"allList\":[{\"body\":\"...公司（以下简称XX公司...\",\"dataType\":\"cpws\",\"entryId\":\"c20181102minxiazhong518_t20180628@5YyX5Lqs5YWs5Y%2B4\",\"sortTime\":1530115200000,\"sortTimeString\":\"2018年06月28日\",\"title\":\"陈XX与X有限公司损害公司利益责任纠纷民事裁定书\"},{\"body\":\"...院对XX公司...\",\"dataType\":\"fygg\",\"entryId\":\"zgy6657337@5YyX5Lqs5YWs5Y%2B4\",\"sortTime\":1529510400000,\"sortTimeString\":\"\",\"title\":\"当事人:中国XX北京公司,北京XX有限公司,北京XX有限公司\"}],\"bgtCount\":2,\"bgtPageNum\":1,\"code\":\"s\",\"cpwsCount\":2,\"cpwsPageNum\":1,\"fyggCount\":2,\"fyggPageNum\":1,\"ktggCount\":2,\"ktggPageNum\":1,\"msg\":\"成功返回\",\"pageNo\":1,\"range\":10,\"searchSeconds\":2.162,\"shixinCount\":2,\"shixinPageNum\":1,\"totalCount\":16,\"totalPageNum\":2,\"zxggCount\":2,\"zxggPageNum\":1}";
        JSONObject object = JSONObject.parseObject(resultStr);
        return object;*/
    }




    @Override
    public int getLitigationRelatedTotalPage() {
        JSONObject result = getLitigationRelated(1);
        if (result == null) {
            log.info("获取涉诉标准数据失败！");
            return 0;
        }
        return result.getInteger("totalPageNum");
    }


    /**
     * 调用http接口获取数据
     *
     * @return
     */
    public JSONObject getCompanyCase(int pageNo) {

        //模拟数据进行测试
        String costomValue = "{	\"allList\":[		{			\"anyou\":\"anyou\",\"caseNo\":\"caseNo\",\"court\":\"court\",\"resultAmount\":1234,\"resultDataType\":\"resultDataType\",\"resultEntryId\":\"resultEntryId\",\"resultLevel\":1,\"resultName\":\"resultName\",\"resultSummary\":\"resultSummary\",\"resultYmd\":\"2019-01-02\"			},		{			\"anyou\":\"anyou1\",\"caseNo\":\"caseNo1\",\"court\":\"court1\",\"resultAmount\":1234,\"resultDataType\":\"resultDataType1\",\"resultEntryId\":\"resultEntryId1\",\"resultLevel\":1,\"resultName\":\"resultName1\",\"resultSummary\":\"resultSummary1\",\"resultYmd\":\"2019-01-02\"		}	],	\"code\":\"s\",	\"msg\":\"s\",	\"pageno\":1,	\"range\":\"s\",	\"totalCount\":30,	\"totalPage\":3}";
        JSONObject object = JSONObject.parseObject(costomValue);
        return object;
    }


    /**
     * 第一次先去获取总的页数
     *
     * @return
     */
    public int getCompanyCaseTotalPage() {
        JSONObject result = getCompanyCase(1);
        if (result == null) {
            log.info("获取公司案件数据失败！");
            return 0;
        }
        return result.getInteger("totalPage");
    }


    public JSONObject getDataByHttp(String uri,  Map<String, String> param, int pageNo) {
        //构建请求url
        String url = uri;
        //发送get 请求获取数据
        String resultStr = HttpClientUtils.doGet(url, param);
        JSONObject result = JSONObject.parseObject(resultStr);
        String code = result.getString("code");
        //判断是否返回成功
        if (!SUCCESS_CODE.equals(code)) {
            log.info("获取数据不成功");
            return null;
        }
        return result;
    }

}
