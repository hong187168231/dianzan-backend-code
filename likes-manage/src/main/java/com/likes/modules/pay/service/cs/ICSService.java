package com.likes.modules.pay.service.cs;

import com.likes.modules.pay.vo.cs.CSCallBackVoPrev;
import com.likes.modules.pay.vo.cs.CSNoticeVo;

public interface ICSService {
    public CSCallBackVoPrev csNotice(CSNoticeVo csNoticeVo)throws Exception;
}
