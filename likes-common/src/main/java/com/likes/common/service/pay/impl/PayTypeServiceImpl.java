package com.likes.common.service.pay.impl;

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
    public List<PayTypeVO> payTypeList() {
        PayType payType = new PayType();
        payType.setStatus(1);
        List<PayType> payTypeList = payTypeMapper.select(payType);
        List<PayTypeVO> payTypeVOList = new LinkedList<>();
        for (PayType type : payTypeList) {
            PayTypeVO payTypeVO = new PayTypeVO();


//            if (StringUtils.isNotBlank(request.getLanguage())) {
//                if (request.getLanguage().equals("en")) {
//                    taskCategory.setName(taskCategory.getEnName());
//                    taskCategory.setDescription(taskCategory.getEnDescription());
//                } else if (request.getLanguage().equals("sp")) {
//                    taskCategory.setName(taskCategory.getSpName());
//                    taskCategory.setDescription(taskCategory.getSpDescription());
//                } else if (request.getLanguage().equals("ab")) {
//                    taskCategory.setName(taskCategory.getAbName());
//                    taskCategory.setDescription(taskCategory.getAbDescription());
//                } else if (request.getLanguage().equals("fn")) {
//                    taskCategory.setName(taskCategory.getFnName());
//                    taskCategory.setDescription(taskCategory.getFnDescription());
//                } else if (request.getLanguage().equals("in")) {
//                    taskCategory.setName(taskCategory.getInName());
//                    taskCategory.setDescription(taskCategory.getInDescription());
//                }
//            }


            BeanUtils.copyProperties(type,payTypeVO);
            payTypeVOList.add(payTypeVO);
        }
        return payTypeVOList;
    }
}