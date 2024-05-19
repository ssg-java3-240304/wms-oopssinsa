package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.ObDto;
import com.oopssinsa.model.dto.ObInstructionDto;

import java.util.List;

public interface ObMapper {
    List<ObInstructionDto> getObIntructionToDo(String workerId);

    void updateObStatus(ObDto updateOb);

    ObDto findOb(ObDto targetOb);

}
