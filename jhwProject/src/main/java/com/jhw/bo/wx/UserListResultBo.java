package com.jhw.bo.wx;

import java.util.List;
import java.util.TreeMap;

import com.jhw.bo.BaseBo;

/**
 * @ClassName UserListResultBo
 * @Description TODO(微信接口bean，公众号可通过本接口来获取帐号的关注者列表)
 * @author Administrator
 * @Date 2017年11月8日 下午6:08:23
 * @version 1.0.0
 * @interface https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID
 * @param access_token 调用接口凭证
 * @param next_openid 第一个拉取的OPENID，不填默认从头开始拉取，可用在分页时
 */
public class UserListResultBo extends BaseBo {

    /** 关注该公众账号的总用户数*/
    private Integer total;
    
    /** 拉取的OPENID个数，最大值为10000*/
    private Integer count;
    
    /** 列表数据，OPENID的列表*/
    private TreeMap<String, List<String>> data;
    
 
    public Integer getTotal() {
        return total;
    }
    
    public void setTotal(Integer total) {
        this.total = total;
    }
    
    public Integer getCount() {
        return count;
    }
    
    public void setCount(Integer count) {
        this.count = count;
    }

    public TreeMap<String, List<String>> getData() {
        return data;
    }

    public void setData(TreeMap<String, List<String>> data) {
        this.data = data;
    }

}
