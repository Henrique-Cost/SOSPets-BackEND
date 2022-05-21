package com.tcc.sospets.business.models.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PageAnimalDomesticoResponse {
    int totalPages;
    List<AnimalDomesticoResponse> animais;
}
