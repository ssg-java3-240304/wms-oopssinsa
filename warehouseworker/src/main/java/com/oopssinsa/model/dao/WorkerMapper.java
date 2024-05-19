package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.IbInstructionDto;

public interface WorkerMapper {
    IbInstructionDto findObInstruction(IbInstructionDto ibInstructionDto);
}
