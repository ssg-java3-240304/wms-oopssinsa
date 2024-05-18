package com.oopssinsa.model.service;

import com.oopssinsa.model.dto.IbDto;
import com.oopssinsa.model.dto.LocationDto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IbService {
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

    public int updateWaitingState(IbDto ibDto) {
        return 1;
    }

    public LocationDto findByCategoryId() {
        return new LocationDto("location_id1", 'A', "category_id1",
                3, 0, 6);
    }


}
