package com.oopssinsa.model.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Error {
    NON_EXISTENT_NUMBER_ERROR("없는 번호 입니다.");

    private final String msg;
}
