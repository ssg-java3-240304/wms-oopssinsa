package com.oopssinsa.model.service;

import com.oopssinsa.model.dto.InstructionDto;
import com.oopssinsa.model.dto.ob.ObDetailDto;
import com.oopssinsa.model.dto.ob.ObDto;
import com.oopssinsa.model.dto.ob.ObRequestAndStockDto;
import com.oopssinsa.model.dto.ob.ObRequestDto;
import com.oopssinsa.model.dto.StockDto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ObService {
    public List<ObRequestDto> findObByRequestState() {
        List<ObRequestDto> obRequestDto = new ArrayList<>();
        obRequestDto.add(new ObRequestDto("ob_id1", "product_id1", "login_id1", 30,
                "recipient_name1", "address1", LocalDate.now()));
        obRequestDto.add(new ObRequestDto("ob_id2", "product_id2", "login_id2", 10,
                "recipient_name2", "address2",LocalDate.now()));

        return obRequestDto;
    }

    // 조인 필요
    public List<ObDto> findAllOb() {
        List<ObDto> obDtos = new ArrayList<>();
        obDtos.add(
                new ObDto(LocalDate.of(2024, 1, 1), "ob_id1", "procuct_id1", "login_id1", "recipient_name1", "address1",
                        10, 'W', LocalDate.now() ,null, 1));
        obDtos.add(
                new ObDto(LocalDate.of(2022, 2, 2), "ob_id1", "procuct_id1", "login_id1", "recipient_name1", "address1",
                        120, 'W', LocalDate.now(),null, 1));

        return obDtos;
    }

    public List<StockDto> findAllStock() {
        List<StockDto> stockDtos = new ArrayList<>();
        stockDtos.add(
                new StockDto(LocalDate.of(2024, 1, 1), "product_id1", "sub_location_id1", 10, 0)
        );
        stockDtos.add(
                new StockDto(LocalDate.of(2022, 2, 2), "product_id1", "sub_location_id1", 20, 0)
        );

        return stockDtos;
    }

    // 제조일자 오름차순으로 가져오기
    public List<StockDto> findStockOrderableByProductId(String productId) {
        List<StockDto> stockDtos = new ArrayList<>();
        stockDtos.add(
                new StockDto(LocalDate.of(2022, 1, 1), productId, "sub_location_id1", 10, 0)
        );
        stockDtos.add(
                new StockDto(LocalDate.of(2024, 2, 2), productId, "sub_location_id1", 20, 0)
        );

        return stockDtos;
    }

    public List<ObRequestAndStockDto> findObRequestAndStock() {
        List<ObRequestAndStockDto> obRequestAndStockDto = new ArrayList<>();
        obRequestAndStockDto.add(
                new ObRequestAndStockDto("ob_id1", "product_id1", "login_id1", 30,
                        "recipient_name1", "address1", LocalDate.now(),'T',
                         "sub_locationid1", 30, 0)
        );
        obRequestAndStockDto.add(
                new ObRequestAndStockDto("ob_id2", "product_id2", "login_id1", 20,
                        "recipient_name1", "address1", LocalDate.now(),'F',
                        "sub_locationid2", 10, 0)
        );

        return obRequestAndStockDto;
    }


    // 예정수량 업데이트
    public int updateStock(StockDto stockDto) {
        return 1;
    }

    public int insertObDetails(List<ObDetailDto> obDetailDtos) {
        return 1;
    }

    public int updateObState(ObDetailDto obDetailDto) {
        return 1;
    }


    public List<ObDetailDto> findObDetailByWaitingState() {
        List<ObDetailDto> obDetailDto = new ArrayList<>();
        obDetailDto.add(new ObDetailDto(LocalDate.of(2022, 1, 1), "ob_id1", "product_id1", 10,
                'W', LocalDate.now(),null, null));
        obDetailDto.add(new ObDetailDto(LocalDate.of(2024, 2, 2), "ob_id1", "product_id1", 20,
                'W',LocalDate.now(), null, null));

        return obDetailDto;
    }

    public int insertObWorker(InstructionDto instructionDto) {
        return 1;
    }
}
