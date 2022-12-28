package com.likes.common.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.likes.common.enums.task.TaskOrderTypeEnum;
import lombok.Data;

import java.util.Date;

@Data
public class PayTypeRequest extends  BaseRequest {


    private String language;


}