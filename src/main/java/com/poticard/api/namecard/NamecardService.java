package com.poticard.api.namecard;

import com.poticard.api.namecard.model.NamecardDto;

public class NamecardService {
    private final NamecardRepository namecardRepository;

    public NamecardService(NamecardRepository namecardRepository) {
        this.namecardRepository = namecardRepository;
    }

    public NamecardDto.SearchRes search(String userId) {
        return namecardRepository.search(userId);
    }

    public NamecardDto.CreateRes create(NamecardDto.CreateReq dto) {
        return namecardRepository.create(dto);
    }
}
