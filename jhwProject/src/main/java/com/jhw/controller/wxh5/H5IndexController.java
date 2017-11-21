package com.jhw.controller.wxh5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jhw.controller.base.BaseController;
import com.jhw.pojo.MTableAttentPoJo;
import com.jhw.pojo.TablePoJo;
import com.jhw.service.MTableAttentService;
import com.jhw.service.TableBrowserService;
import com.jhw.service.TableService;
import com.jhw.util.servlet.GaoDeServlet;
import com.jhw.util.sort.SortUtil;
import com.jhw.util.timedate.TimeDateUtil;

/**
 * @ClassName Index
 * @Description TODO(H5页面，首页)
 * @author Administrator
 * @Date 2017年11月13日 下午12:04:01
 * @version 1.0.0
 */
@Controller
@RequestMapping("/h5index")
public class H5IndexController extends BaseController {

	@Autowired
	private MTableAttentService attentService;
	@Autowired
	private TableService tableService;
	@Autowired
	private TableBrowserService tableBrowserService;
	
    @RequestMapping("/toindex")
    @ResponseBody
    public ModelAndView toH5Index(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        logger.info("进入H5首页");
        modelAndView.setViewName("/jsp/wxh5/index");
        return modelAndView;
    }
    
    /**
     * @Description (TODO 
     * 成局剩余人数权重计算策略
     * 1、拼桌、聚会成局人数还剩一个人时它们的权重是一样的
     * 2、拼桌、聚会成局后总权重值将会不再计算成局剩余人数权重值，这样完成了的拼桌、聚会权重将会降低，也就排不到最前了)
     * @return
     */
    @RequestMapping("/sort")
    @ResponseBody
    public String doSortTableAndParty(){
    	String sortResult = "";
    	List<TablePoJo> validTables = tableService.getValidAndNotCompleteTable();
    	if (validTables == null) {
			return null;
		}
    	for(TablePoJo poJo : validTables){
    		//计算时间排序权重
    		String beginDateStr = poJo.getBegainDate();
    		if (beginDateStr != null && beginDateStr.length() > 10) {
				long space = TimeDateUtil.countDateTimeSpace(beginDateStr);
				float dateSortWeight = SortUtil.dateSpaceWeight(space);
				logger.info("拼桌编号"+poJo.getTtid()+", 时间排序权重："+dateSortWeight);
			}
    		
    		Integer total = poJo.getPeopleNumber();		//拼桌总人数
    		List<MTableAttentPoJo> attentUsers = attentService.getValidTakePartIn(poJo.getTtid());	//取实际参与人数
    		if (attentUsers == null || attentUsers.size()==0) {
    			logger.info("拼桌编号"+poJo.getTtid()+"没有人参加拼桌");
				continue;
			}
    		int attentCount = attentUsers.size();
    		float weight = 0.00f;
    		//
    		if (total - attentCount == 1) {
    			weight = 1.0f;
				logger.info("拼桌编号"+poJo.getTtid()+"还差一人，权重设为最大值1");
			}else if (total - attentCount == 0) {
				weight = 0.0f;
				logger.info("拼桌编号"+poJo.getTtid()+"已成局,权重置为0.0");
			}else {
				weight = ((float)attentCount/(float)total)*100*SortUtil.SURPLUS_NUM;
				logger.info("拼桌编号"+poJo.getTtid()+"的权重："+weight+"");
			}
    	}
    	return sortResult;
    }
    
    
    /**
     * @Description (TODO 拼桌浏览量权重计算)
     * @param request
     */
    @RequestMapping("/browserWeight")
    @ResponseBody
    public void doBrowserWeight(HttpServletRequest request){
    	
    	int totalCount = tableBrowserService.totalCount();
    	int tableBrowserCount = tableBrowserService.getBrowserCountByTableId(45);
    	
    	float weight = ((float)tableBrowserCount/(float)totalCount)*100*SortUtil.CHECK_NUM;
    	
    	logger.info("有效拼桌总浏览量："+totalCount+"，拼桌45的浏览量： "+tableBrowserCount+" ,权重是："+weight);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /***
     * @Description (TODO )
     * @param request
     * @return
     */
    @RequestMapping(value="/gaode",produces="text/json;charset=UTF-8")
    @ResponseBody
    public String testGaoDeMap(HttpServletRequest request){
    	Map<String, String> parameters = new HashMap<>();
    	parameters.put("keywords", "中餐厅|江浙菜");
    	parameters.put("city", "310106");
    	parameters.put("page", "2");
    	String result = GaoDeServlet.keyWordSearch(parameters);
    	logger.info(result);
        return result;
    }
}
