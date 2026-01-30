package com.poticard.api.namecard;

import com.poticard.api.namecard.model.NamecardCreateDto;
import com.poticard.api.namecard.model.NamecardSearchDto;

public class NamecardService {
    private final NamecardRepository namecardRepository;

    public NamecardService(NamecardRepository namecardRepository) {
        this.namecardRepository = namecardRepository;
    }

    public NamecardSearchDto.NamecardRes search(String userId) {
        return namecardRepository.search(userId);
    }

    public NamecardCreateDto.Response create(NamecardCreateDto.Register dto) {
        return namecardRepository.create(dto);
    }
}
