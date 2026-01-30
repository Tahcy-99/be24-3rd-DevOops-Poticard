package com.poticard.api.namecard;

import com.poticard.api.namecard.model.NamecardCreateDto;
import com.poticard.api.namecard.model.NamecardSearchDto;

public interface NamecardRepository {

    public NamecardSearchDto.NamecardRes search(String userId);
    public NamecardCreateDto.Response create(NamecardCreateDto.Register dto);
}
