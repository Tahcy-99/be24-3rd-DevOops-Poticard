package com.poticard.api.namecard;

import com.poticard.api.namecard.model.NamecardDto;

public class NamecardService {
    private final NamecardRepository namecardRepository;

    public NamecardService(NamecardRepository namecardRepository) {
        this.namecardRepository = namecardRepository;
    }

    public NamecardDto.NamecardRes search(String userId) {
        return namecardRepository.search(userId);
    }
}
