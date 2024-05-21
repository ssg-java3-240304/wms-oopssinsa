package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.IbInstructionDto;
import com.oopssinsa.model.dto.ObDto;
import com.oopssinsa.model.dto.ObInstructionDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ObMapper {
    List<ObInstructionDto> getObInstructionToDo(String workerId);

    int updateObStatus(ObDto updateOb);

    ObDto findOb(ObDto targetOb);

    ObInstructionDto findObInstruction(ObInstructionDto obInstructionDto);

    // 예진 작업 시작
    int findProductVolume(String productId);

    int insertTrackingNumber(@Param("obId") long obId, @Param("trackingNumber") long trackingNumber);
    Integer findTrackingNumber(@Param("obId") long obId);
    // 예진 작업 끝

}
