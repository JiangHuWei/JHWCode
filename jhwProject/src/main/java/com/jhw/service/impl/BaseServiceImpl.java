package com.jhw.service.impl;

import org.apache.log4j.Logger;

public class BaseServiceImpl {

    /** 1：处理成功 */
    protected final int HANDLE_SUCCESS = 1;
    /** 0：处理失败*/
    protected final int HANDLE_FAILED = 0;
    
    protected Logger logger = Logger.getLogger(BaseServiceImpl.class);
    
    
}
