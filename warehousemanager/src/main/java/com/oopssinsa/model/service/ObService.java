package com.oopssinsa.model.service;

import com.oopssinsa.model.dto.ObDto;
import java.util.ArrayList;
import java.util.List;

public class ObService {
    public List<ObDto> findObByRequestState() {
        List<ObDto> obDto = new ArrayList<>();
        obDto.add(new ObDto("ob_id1", "product_id1", "login_id1", 30,
                "recipient_name1", "address1"));
        obDto.add(new ObDto("ob_id2", "product_id2", "login_id2", 10,
                "recipient_name2", "address2"));

        return obDto;
    }

}
