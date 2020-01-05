package com.xzit.garden.service;

import com.xzit.garden.bean.dto.AttendanceDto;
import com.xzit.garden.bean.model.PageModel;

import java.util.List;

public interface AttendanceService {
    List<AttendanceDto> findAllPage(PageModel<List<AttendanceDto>> pageModel);
}
