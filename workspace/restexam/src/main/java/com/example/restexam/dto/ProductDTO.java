package com.example.restexam.dto;

import com.example.restexam.entity.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private Long id;

    @NotBlank(message = "상품명은 반드시 입력해야 합니다. ")
    private String name;
    @Min(value = 1, message = "가격은 1 이상 이어야 합니다.")
    private double price;

    //Entity->DTO 변환하는 메서드
    public static ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

}
