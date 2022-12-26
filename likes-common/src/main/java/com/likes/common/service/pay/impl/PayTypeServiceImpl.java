package com.likes.common.service.pay.impl;

import com.likes.common.model.vo.pay.PayTypeVO;
import com.likes.common.mybatis.entity.PayType;
import com.likes.common.mybatis.mapper.PayTypeMapper;
import com.likes.common.service.pay.PayTypeService;
import com.likes.common.util.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service
public class PayTypeServiceImpl implements PayTypeService {

    @Resource
    private PayTypeMapper payTypeMapper;

    @Override
    public List<PayTypeVO> payTypeList() {
        PayType payType = new PayType();
        payType.setStatus(1);
        List<PayType> payTypeList = payTypeMapper.select(payType);
        List<PayTypeVO> payTypeVOList = new LinkedList<>();
        for (PayType type : payTypeList) {
            PayTypeVO payTypeVO = new PayTypeVO();
            BeanUtils.copyProperties(type,payTypeVO);
            payTypeVOList.add(payTypeVO);
        }
        return payTypeVOList;
    }
}
