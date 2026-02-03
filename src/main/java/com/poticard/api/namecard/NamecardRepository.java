package com.poticard.api.namecard;

import com.poticard.api.namecard.model.NamecardDto;

public interface NamecardRepository {

    public NamecardDto.SearchRes search(String userId);

    public NamecardDto.CreateRes create(NamecardDto.CreateReq dto);
}