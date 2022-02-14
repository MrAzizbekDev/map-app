package uz.pdp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private String massage;
    private boolean success;
    private Object object;

    public ResponseDto(String massage, boolean success) {
        this.massage = massage;
        this.success = success;
    }
}
