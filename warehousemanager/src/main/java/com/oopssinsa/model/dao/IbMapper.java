package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.*;
import com.oopssinsa.model.dto.ib.IbDto;
import com.oopssinsa.model.dto.ib.IbRequestAndLocationDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IbMapper {
    List<IbDto> findAllIb();
    int updateIbState(IbDto ibDto);
    int updateExpectedCapacityLocation(LocationDto locationDto);
    int updateExpectedCapacitySection(SectionDto sectionDto);
    LocationDto findLocationByCategoryIdAndSectionId(@Param("categoryId")String categoryId, @Param("sectionId") char sectionId);
    ProductDto findProductByProductId(String productId);
    SectionDto findSectionByBrandId(String brandId);

    List<IbDto> findIbByRequestState();

    List<IbDto> findIbByWaitingState();

//    List<IbRequestAndLocationDto> findIbRequestAndLocation();

    List<IbRequestAndLocationDto> findIbRequestAndLocation(List<IbDto> ibDtos);
}
