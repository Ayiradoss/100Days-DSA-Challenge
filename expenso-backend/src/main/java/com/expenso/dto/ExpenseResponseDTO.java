package com.expenso.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseResponseDTO {
    private Long id;
    private String title;
    private BigDecimal amount;
    private LocalDate date;
    private Long categoryId;
    private String categoryName;
    private Long userId;
    private String userName;
}
