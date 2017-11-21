package com.jhw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhw.dao.TableBrowserPoJoMapper;
import com.jhw.service.TableBrowserService;

/**
 * @ClassName TableBrowserServiceImpl
 * @Description TODO(拼桌浏览量统计业务层)
 * @author Jce
 * @Date 2017年11月20日 下午7:26:00
 * @version 1.0.0
 */
@Service("TableBrowserService")
public class TableBrowserServiceImpl implements TableBrowserService {
	
	@Autowired
	private TableBrowserPoJoMapper tableBrowserDao;
	
	/**
     * @Description (TODO 计算正在凑人数的拼桌的总浏览量)
     * @return
     */
	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		return tableBrowserDao.totalCount();
	}

	/**
     * @Description (TODO 根据拼桌id检索该拼桌的浏览量)
     * @param tableId
     * @return
     */
	@Override
	public int getBrowserCountByTableId(Integer tableId) {
		// TODO Auto-generated method stub
		return tableBrowserDao.getBrowserCountByTableId(tableId);
	}

	
}
