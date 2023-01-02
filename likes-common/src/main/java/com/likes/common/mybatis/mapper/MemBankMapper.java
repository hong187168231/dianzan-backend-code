package com.likes.common.mybatis.mapper;

import com.github.pagehelper.Page;
import com.likes.common.model.bank.MemBankPageReq;
import com.likes.common.model.bank.MemBankVO;
import com.likes.common.model.bank.OrderDTO;
import com.likes.common.model.dto.member.MemFamilyReq;
import com.likes.common.model.dto.member.MemFamilyResponse;
import com.likes.common.mybatis.entity.MemBank;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author puff
 * @since 2021-08-31
 */
@Mapper
public interface MemBankMapper extends BaseMapper<MemBank> {
    /**
     * 分页查询用户银行卡信息
     *
     * @param page
     * @param req
     * @return
     */
    Page<MemBankVO> queryList(@Param("req") MemBankPageReq req, RowBounds rowBounds);

//    PayTakeCash existCashOrder(OrderDTO orderDTO);


    /**
     * 查询会员报表
     * @param page
     * @param memReportDTO
     * @return
     */
//    Page<MemReportVo> findMemberReport(@Param("page")Page<MemReportVo> page, @Param("dto")MemReportDTO memReportDTO);
}
