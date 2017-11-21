package com.jhw.bo;

/***
 * 
 * ClassName:BaseBo
 * Function: TODO 
 *
 * @author  lil
 * @version 
 * @since   lil Ver 1.0
 * @Date	2017年11月14日	下午4:55:09
 *
 * @see
 */
public class BaseBo {

    /**是否被选中，用在编辑页面中，例如发起人是小明,那么小明在编辑页面应该是默认被选中的*/
    private boolean isSelected;

    public boolean isSelected() {
        return isSelected;
    }

    /***
     * 
     * setSelected:
     * TODO
     * @param  @param isSelected
     * @return void  
     * @throws 
     * @since  lil Ver 1.0
     */
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
    
}
