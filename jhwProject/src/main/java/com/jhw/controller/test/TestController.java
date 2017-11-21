package com.jhw.controller.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhw.pojo.TestPoJo;
import com.jhw.pojo.UserPoJo;
import com.jhw.service.TestService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


/**
 * 框架搭建测试
 * @author Jce666
 *
 */
@Api(value="test")
@Controller
@RequestMapping("/test")
public class TestController {
	
	private Logger logger = org.apache.log4j.Logger.getLogger(getClass());
	
	@Autowired
	TestService service;

	@RequestMapping("/doSwagger")
	@ResponseBody
	@ApiOperation(value="Swagger测试",notes="主要测试Swagger",response=UserPoJo.class)
	public UserPoJo doTestSwagger(){
		UserPoJo userPoJo = new UserPoJo();
		userPoJo.setNickname("Jce");
		userPoJo.setAge(29);
		userPoJo.setAddress("东源名都");
		return userPoJo;
	}
	
	@RequestMapping("/dotest")
	public String doTestZiXun(HttpServletRequest request, ModelMap map,String name,String pwd){
		logger.info("进入测试"+name+" --- "+pwd);
		String mHeader = request.getHeader("Referer");
		logger.info("Refer header: "+mHeader);
		
		List<TestPoJo> results = service.queryAll();
		if (results == null) {
			logger.info("没有结果");
		}else{
			logger.info("结果总数："+results.size());
		}
		
		return "page/website/testSuccess";
	}
	
	/**
	 * 导出Excel报表
	 * @param savePath
	 * @param request
	 */
	@SuppressWarnings("resource")
	@RequestMapping("/exportExcel")
	public void doExportToExcel(ModelMap map,String savePath,HttpServletResponse response){
		logger.info("================================准备导出报表==================================");
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("用户信息报表");
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell0 = row.createCell(0);
		cell0.setCellValue("用户名:");
		HSSFCell cell1 = row.createCell(1);
		cell1.setCellValue("Jce666");
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=userInfoTable.xls");
			OutputStream outputStream = response.getOutputStream();
			workbook.write(outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (FileNotFoundException e) {
			logger.error("导出报表异常："+e.getMessage());
			e.printStackTrace();
			map.put("result", "导出报表异常:"+e.getMessage());
			return ;
		} catch (IOException e) {
			logger.error("导出报表异常："+e.getMessage());
			e.printStackTrace();
			map.put("result", "导出报表异常:"+e.getMessage());
		}
		map.put("result", "导出报表成功");
	}
	
	
}
