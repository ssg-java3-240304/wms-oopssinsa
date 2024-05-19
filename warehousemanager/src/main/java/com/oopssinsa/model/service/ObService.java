package com.oopssinsa.model.service;

import com.oopssinsa.model.dto.IbDto;
import com.oopssinsa.model.dto.ObDto;
import com.oopssinsa.model.dto.ObRequestDto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ObService {
    public List<ObRequestDto> findObByRequestState() {
        List<ObRequestDto> obRequestDto = new ArrayList<>();
        obRequestDto.add(new ObRequestDto("ob_id1", "product_id1", "login_id1", 30,
                "recipient_name1", "address1"));
        obRequestDto.add(new ObRequestDto("ob_id2", "product_id2", "login_id2", 10,
                "recipient_name2", "address2"));

        return obRequestDto;
    }

    // 조인 필요
    public List<ObDto> findAllOb() {
        List<ObDto> obDtos = new ArrayList<>();
        obDtos.add(
                new ObDto(LocalDate.of(2024, 1, 1), "ob_id1", "procuct_id1", "login_id1", "recipient_name1", "address1",
                        10, 'W',null, 1));
        obDtos.add(
                new ObDto(LocalDate.of(2022, 2, 2), "ob_id1", "procuct_id1", "login_id1", "recipient_name1", "address1",
                        120, 'W',null, 1));

        return obDtos;
    }
}
