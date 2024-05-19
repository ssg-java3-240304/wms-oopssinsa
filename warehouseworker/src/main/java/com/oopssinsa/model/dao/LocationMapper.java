package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.SubLocationDto;

public interface LocationMapper {
    int getCurrentCapacity(long targetLocationId);

    void updateCurrentCapacity(SubLocationDto subLocationDto);
}
