package com.poticard.api.namecard;

import com.poticard.api.namecard.model.NamecardDto;
import com.poticard.api.namecard.model.NamecardSearchDto;

public interface NamecardRepository {

    public NamecardSearchDto.NamecardRes search(String userId);

    public NamecardDto.CreateRes create(NamecardDto.CreateReq dto);
}