package practice.example.practice.dto;

import lombok.Data;

@Data
public class PredictResponseDto {
    public PredictResponseDto(double predictionValue) {
        this.predictionValue = predictionValue;
    }
    public double predictionValue;
}
