package com.likes.modules.pay.service;

import com.likes.modules.pay.vo.GetCollectUrlVo;

public interface ICollectService {

    public String getCollectUrl(GetCollectUrlVo getCollectUrlVo)throws Exception;
}
