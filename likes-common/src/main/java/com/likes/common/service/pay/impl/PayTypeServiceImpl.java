package com.likes.common.service.pay.impl;

import com.likes.common.model.request.PayTypeRequest;
import com.likes.common.model.vo.pay.PayTypeVO;
import com.likes.common.mybatis.entity.PayType;
import com.likes.common.mybatis.mapper.PayTypeMapper;
import com.likes.common.service.pay.PayTypeService;
import com.likes.common.util.BeanUtils;
import com.likes.common.util.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service
public class PayTypeServiceImpl implements PayTypeService {

    @Resource
    private PayTypeMapper payTypeMapper;

    @Override
    public List<PayTypeVO> payTypeList(String language) {
        PayType payType = new PayType();
        payType.setStatus(1);
        List<PayType> payTypeList = payTypeMapper.select(payType);
        List<PayTypeVO> payTypeVOList = new LinkedList<>();
        for (PayType type : payTypeList) {
            PayTypeVO payTypeVO = new PayTypeVO();
            BeanUtils.copyProperties(type, payTypeVO);
            if (StringUtils.isNotBlank(language)) {
                if (language.equals("zh")) {
                    payTypeVO.setPayTypeName(type.getPayTypeName());
                } else if (language.equals("vn")) {
                    payTypeVO.setPayTypeName(type.getPayTypeNameViet());
                } else {
                    payTypeVO.setPayTypeName(type.getPayTypeNameEn());
                }
                payTypeVOList.add(payTypeVO);
            }

        }
        return payTypeVOList;
    }
}