package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.SubLocationDto;

public interface LocationMapper {
    int getProductLocationId();
    int getCurrentCapacity(long targetLocationId);

    int updateCurrentCapacity(SubLocationDto subLocationDto);

    int updateSectionCurrentCapacity(long locationId);
}
