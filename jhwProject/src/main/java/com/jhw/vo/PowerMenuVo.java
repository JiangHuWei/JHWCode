package com.jhw.vo;

import java.util.List;

import com.jhw.pojo.PowerMenuPoJo;

/**
 * 
 * @ClassName PowerMenuVo
 * @Description TODO(菜单结构)
 * @author Administrator
 * @Date 2017年10月10日 下午8:05:30
 * @version 1.0.0
 */
public class PowerMenuVo {

    /** 菜单名称*/
    String menuName;
    /** 菜单id*/
    Integer menuId;
    /** 该菜单包含的子菜单 ，*/
    List<PowerMenuPoJo> childrenMenus;
    
    public String getMenuName() {
        return menuName;
    }
    
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    
    public Integer getMenuId() {
        return menuId;
    }
    
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
    
    public List<PowerMenuPoJo> getChildrenMenus() {
        return childrenMenus;
    }
    
    public void setChildrenMenus(List<PowerMenuPoJo> childrenMenus) {
        this.childrenMenus = childrenMenus;
    }
    
}
