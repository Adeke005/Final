package sas.finalpo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private Long id;
    private String nameDto;
    private String codeDto;
    private LocalDateTime createdAtDto;
}
