package com.poticard.api.namecard;

import com.poticard.api.namecard.model.NamecardDto;

public interface NamecardRepository {

    public NamecardDto.NamecardRes search(String userId);
}
