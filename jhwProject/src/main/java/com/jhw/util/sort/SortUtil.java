/******************************************************************
 *    Copyright (c) 2001-2018 江湖味
 *    http://www.jianghuwei.net/
 *
 *    Package:     com.jhw.util.sort
 *    Filename:    SortConfig.java
 *    Description: TODO( )
 *
 *    Copyright:   Copyright (c) 2001-2014
 *    Company:     江湖味
 *    @author:     Jce
 *    @version:    1.0.0
 *    Create at:   2017年11月18日 下午4:56:31
 *    Revision:
 *    2017年11月18日 下午4:56:31
 *        - first revision
 *****************************************************************/
package com.jhw.util.sort;

/**
 * @ClassName SortConfig
 * @Description TODO(聚会、拼桌排序相关参数配置及部分共用算法)
 * @author Jce
 * @Date 2017年11月18日 下午4:56:31
 * @version 1.0.0
 */
public class SortUtil {

	/** 剩余成局人数基数 -- 0.9f*/
	public static float SURPLUS_NUM = 0.9f;
	/** 总浏览量基数 -- 0.7f*/
	public static float CHECK_NUM = 0.7f;
	/** 时间排序基数 -- 0.5f*/
	public static float DATE_NUM = 0.5f;
	/** 评论基数 -- 0.4f*/
	public static float COMMENT_NUM = 0.4f;
	/** 收藏基数 -- 0.2f*/
	public static float COLLECTION_NUM = 0.2f;
	/** 信用基数 -- 0.1f*/
	public static float CREDIT_NUM = 0.1f;
	
	/**=========================饭局开始时间排序权重===============================*/
	/** 1天以内*/
	public static final float withinOneDayWeight = 70;
	/** 2天以内*/
	public static final float withinTwoDayWeight = 60;
	/** 3天以内*/
	public static final float withinThreeDayWeight = 50;
	/** 5天以内*/
	public static final float withinFiveDayWeight = 30;
	/** 7天以内*/
	public static final float withinSevenDayWeight = 15;
	/** 大于7天*/
	public static final float moreThanSevenDayWeight = 5;
	
	
	public void workSurplusNum(){
		
	}
	
	/**
	 * @Description (TODO 根据时间间隔和开始时间排序权重计算)
	 * @param spaceVal
	 * @return
	 */
	public static float dateSpaceWeight(long spaceVal){
		float weight = 0;
		if (spaceVal > 0 && spaceVal <=1) {			//1天以内
			weight = withinOneDayWeight * DATE_NUM;
		} else if (spaceVal>1 && spaceVal<=2) {		//2天以内
			weight = withinTwoDayWeight * DATE_NUM;
		} else if (spaceVal>2 && spaceVal<=3) {		//3天以内
			weight = withinThreeDayWeight * DATE_NUM;
		}else if (spaceVal>3 && spaceVal<=5) {		//5天以内
			weight = withinFiveDayWeight * DATE_NUM;
		}else if (spaceVal>5 && spaceVal<=7) {		//7天以内
			weight = withinSevenDayWeight * DATE_NUM;
		}else if (spaceVal > 7) {					//大于7天
			weight = moreThanSevenDayWeight * DATE_NUM;
		}else {					//0天
			weight = 0 ;
		}
		return weight;
	}
	
	
}
