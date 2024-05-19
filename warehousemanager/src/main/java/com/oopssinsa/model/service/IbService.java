package com.oopssinsa.model.service;

import com.oopssinsa.model.dto.IbDto;
import com.oopssinsa.model.dto.IbRequestAndLocationDto;
import com.oopssinsa.model.dto.InstructionDto;
import com.oopssinsa.model.dto.LocationDto;
import com.oopssinsa.model.dto.ProductDto;
import com.oopssinsa.model.dto.SectionDto;
import com.oopssinsa.model.dto.WorkerDto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IbService {

    public int updateIbState(IbDto ibDto) {
        return 1;
    }

    public int updateExpectedCapacity(LocationDto locationDto) {
        return 1;
    }

    public int updateExpectedCapacity(SectionDto sectionDto) {
        return 1;
    }


    public LocationDto findLocationByCategoryIdAndSectionId(String categoryId, char sectionId) {
        return new LocationDto("location_id1", sectionId, categoryId,
                3, 0, 13);
    }

    public ProductDto findProductByProductId(String productID) {
        return new ProductDto("product_id1", "brand_id1", "category_id1",
                "name1", "size1", "color1", 2);
    }

    public SectionDto findSectionByBrandId(String brandId) {
        return new SectionDto('A', brandId, 3, 0, 100);
    }

    public List<IbDto> findAllIb() {
        List<IbDto> ibDto = new ArrayList<>();
        ibDto.add(new IbDto("ib_id1", LocalDate.of(2023, 5, 5),
                "product_id1", "brand_id1", 30, LocalDate.now(), null, 'R'));
        ibDto.add(new IbDto("ib_id2", LocalDate.of(2024, 5, 3),
                "product_id2", "brand_id2", 10, LocalDate.now(), null, 'S'));

        return ibDto;
    }

    public List<IbDto> findIbByRequestState() {
        List<IbDto> ibDto = new ArrayList<>();
        ibDto.add(new IbDto("ib_id1", LocalDate.of(2023, 5, 5),
                "product_id1", "brand_id1", 30, LocalDate.now(), null, 'R'));
        ibDto.add(new IbDto("ib_id2", LocalDate.of(2024, 5, 5),
                "product_id2", "brand_id2", 10, LocalDate.now(), null, 'R'));

        return ibDto;
    }

    public List<IbDto> findIbByWaitingState() {
        List<IbDto> ibDto = new ArrayList<>();
        ibDto.add(new IbDto("ib_id1", LocalDate.of(2023, 5, 5),
                "product_id1", "brand_id1", 30, LocalDate.now(), null, 'W'));
        ibDto.add(new IbDto("ib_id2", LocalDate.of(2024, 5, 5),
                "product_id2", "brand_id2", 10, LocalDate.now(), null, 'W'));

        return ibDto;
    }

//    // 진행중 쿼리 테스트중
//    // 입고리스트에서 상품id-> 브랜드 id -> 구역 id ->  + 상품id-> 카테고리 id
//    public List<LocationDto> findLocationsByIbDtos(List<IbDto> ibDtos) {
//        List<LocationDto> locationDtos = new ArrayList<>();
//        locationDtos.add(new LocationDto("location_id1", 'A', "category_id1",
//                3, 0, 10));
//        locationDtos.add(new LocationDto("location_id2", 'B', "category_id1",
//                3, 0, 13));
//        return locationDtos;
//    }

    // findLocationsByIbDtos() -> findIbRequestAndLocation 로변경
    // ibDtos를 받으면 상품id-> 브랜드 id -> 구역 id ->  + 상품id-> 카테고리 id 을통해서 각 입고1개당 구역을 연결시켜줘서 반환해야 함
    // 입고 가능상태도 계산하여 행에 추가해줘야함
    public List<IbRequestAndLocationDto> findIbRequestAndLocation(List<IbDto> ibDtos) {
        List<IbRequestAndLocationDto> ibRequestAndLocationDtos = new ArrayList<>();
        ibRequestAndLocationDtos.add(new IbRequestAndLocationDto("ib_id1", LocalDate.of(2023, 5, 5),
                "product_id1", "brand_id1", 30, LocalDate.now(), 'R', 'F',
                3, 0, 10));
        ibRequestAndLocationDtos.add(new IbRequestAndLocationDto("ib_id2", LocalDate.of(2024, 5, 5),
                "product_id2", "brand_id2", 10, LocalDate.now(), 'R', 'T',
                3, 0, 13));
        return ibRequestAndLocationDtos;
    }
}
