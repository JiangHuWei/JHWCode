package com.jhw.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Attr;
import com.jhw.dao.TablePoJoMapper;
import com.jhw.pojo.MTableAttentPoJo;
import com.jhw.pojo.TablePoJo;
import com.jhw.service.MTableAttentService;
import com.jhw.service.TableService;
import com.jhw.util.timedate.TimeDateUtil;

/**
 * @ClassName TableServiceImpl
 * @Description TODO(拼桌业务处理层)
 * @author Administrator
 * @Date 2017年10月23日 下午3:54:31
 * @version 1.0.0
 */
@Service("TableService")
public class TableServiceImpl extends BaseServiceImpl implements TableService{

    @Autowired
    private TablePoJoMapper tableDao;
    
    @Autowired
    private MTableAttentService attentService;
    
    
    @Override
    public List<TablePoJo> selectAllTable(int start, int limit) {
        // TODO Auto-generated method stub
        return tableDao.selectAllTable(start, limit);
    }
    /**'
     * @Description (TODO 新建拼桌,根据新建的拼桌记录主键新建)
     * @param record
     * @return
     * @throws ParseException 
     */
    @Override
    @Transactional(propagation=Propagation.REQUIRED)
    public boolean insertSelective(TablePoJo record,List<MTableAttentPoJo> attentUsers) throws ParseException {
        int count = 0;
        if (attentUsers == null || attentUsers.size() == 0) {
            return false;
        }
        //新建拼桌
        int insertResult = tableDao.insertSelective(record);
        if (insertResult == 1) {
            int tableId = record.getTtid();
            if (tableId > 1) {
                for (MTableAttentPoJo item : attentUsers) {
                    item.setTableId(tableId);
                    item.setCreateDate(TimeDateUtil.formatCurrentDate());
                    item.setUserName("");
                    int newAttentResult = attentService.insert(item);
                    if (newAttentResult > 0) {
                        logger.info("拼桌参与人：" + item.getUserId() + "参与成功");
                    }
                    count++;
                }
                if (count>0) {
                    return true;
                }
            }else {
                return false;
            }
        }else {
            return false;
        }
        return false;
    }
    
    @Override
    public int insert(TablePoJo record) {
        // TODO Auto-generated method stub
        return tableDao.insert(record);
    }
    
    /**
     * @Description (TODO 查看拼桌详情)
     * @param ttid
     * @return
     */
    @Override
    public TablePoJo selectByPrimaryKey(Integer ttid){
        return tableDao.selectByPrimaryKey(ttid);
    }
    
    /**
     * @Description (TODO 根据拼桌主键删除拼桌)
     * @param ttid
     * @return
     */
    public int deleteByPrimaryKey(Integer ttid){
        return tableDao.deleteByPrimaryKey(ttid);
    }
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED)
    public int updateByPrimaryKeySelective(TablePoJo record) {
        // TODO Auto-generated method stub
        
        return 0;
    }
    
    /**
     * @Description (TODO 更新拼桌信息, 拼桌参与人更新)
     * @param record 
     * @return
     * @throws ParseException 
     */
    @Override
    @Transactional(propagation=Propagation.REQUIRED)
    public int updateByPrimaryKey(TablePoJo record) throws ParseException {
        //验证参与人是否是大于等于1
        List<MTableAttentPoJo> newAttentUsers = record.getUserAttentPoJo();
        int updateResult = tableDao.updateByPrimaryKey(record);
        if (updateResult == 1) {
            for(MTableAttentPoJo tmp : newAttentUsers){
                MTableAttentPoJo tmpPoJo = attentService.selectByTableAndUser(record.getTtid(), tmp.getUserId());
                if (tmpPoJo == null || tmpPoJo.getTmtaid() == null) {
                    //插入操作
                    tmp.setCreateDate(TimeDateUtil.formatCurrentDate());
                    tmp.setStatus(0);
                    tmp.setTableId(record.getTtid());
                    int insertResult = attentService.insert(tmp);    
                    if (insertResult == HANDLE_SUCCESS) {
                        logger.info("新增参与人："+tmp.getUserId()+"成功");
                    }
                }else if(tmpPoJo.getStatus() == -1){
                    //更新其status为0
                    int updateStatusResult = attentService.updateStatusById(0, tmpPoJo.getTmtaid());
                    if (updateStatusResult == HANDLE_SUCCESS) {
                        logger.info("更新参与人： "+tmpPoJo.getTmtaid()+"成功");
                    }
                }
            }
            return HANDLE_SUCCESS;
        }else {
            return HANDLE_FAILED;
        }
    }
    
    /**
     * @Description (TODO 检索所有有效的、未成局的饭局)
     * @return
     */
	@Override
	public List<TablePoJo> getValidAndNotCompleteTable() {
		// TODO Auto-generated method stub
		return tableDao.getValidAndNotCompleteTable();
	}
    

}
