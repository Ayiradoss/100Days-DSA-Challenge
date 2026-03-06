package com.expenso.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseDTO {

    private Long id;

    @NotBlank
    private String description;

    @NotNull
    @PositiveOrZero
    private BigDecimal amount;

    @NotNull
    private LocalDate date;
}
