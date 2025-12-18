package sas.finalpo.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDto {
    private Long id;
    private String nameDto;
    private String descriptionDto;
    private int priceDto;
    private String codeDto;
}
