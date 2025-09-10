package practice.example.practice.services;

import practice.example.practice.dto.PredictRequestDto;
import practice.example.practice.dto.PredictResponseDto;

public interface PredictionService {
    PredictResponseDto predict(PredictRequestDto requestDto);
}
