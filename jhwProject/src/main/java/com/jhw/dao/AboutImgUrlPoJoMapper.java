package com.jhw.dao;

import com.jhw.pojo.AboutImgUrlPoJo;

public interface AboutImgUrlPoJoMapper {
    int deleteByPrimaryKey(Integer tauid);

    int insert(AboutImgUrlPoJo record);

    int insertSelective(AboutImgUrlPoJo record);

    AboutImgUrlPoJo selectByPrimaryKey(Integer tauid);

    int updateByPrimaryKeySelective(AboutImgUrlPoJo record);

    int updateByPrimaryKey(AboutImgUrlPoJo record);
}