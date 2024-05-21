package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.IbDto;
import com.oopssinsa.model.dto.IbInstructionDto;

import java.util.List;

public interface IbMapper {
    IbDto findIb(IbDto targetIb);

    List<IbInstructionDto> getIbInstructionToDo(String workerId);

    int updateIbStatus(IbDto updateIb);

    IbInstructionDto findIbInstruction(IbInstructionDto ibInstructionDto);

    int findProductVolume(String productId);

    long findProductLocation(String productId);
}
