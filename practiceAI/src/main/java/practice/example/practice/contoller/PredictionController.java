package practice.example.practice.contoller;

import practice.example.practice.dto.PredictRequestDto;
import practice.example.practice.dto.PredictResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import practice.example.practice.services.PredictionService;

@RestController
public class PredictionController {
    private final PredictionService predictionService;

    @Autowired
    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }
    @PostMapping("/predict")
    public PredictResponseDto getPrediction(@RequestBody PredictRequestDto requestDto) {
        return predictionService.predict(requestDto);
    }
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
