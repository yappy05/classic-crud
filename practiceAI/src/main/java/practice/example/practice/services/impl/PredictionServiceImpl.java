package practice.example.practice.services.impl;

import ai.catboost.CatBoostError;
import ai.catboost.CatBoostModel;
import ai.catboost.CatBoostPredictions;
// PredictionType недоступен в используемой версии библиотеки
import practice.example.practice.dto.PredictRequestDto;
import practice.example.practice.dto.PredictResponseDto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import practice.example.practice.services.PredictionService;

import java.io.IOException;
import java.util.Arrays;

@Service
public class PredictionServiceImpl implements PredictionService {
    private CatBoostModel model;
    private final String modelPath = "/catboost.cbm";

    @PostConstruct
    public void init() {
        try {
            model = CatBoostModel.loadModel(getClass().getResourceAsStream(modelPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CatBoostError e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PredictResponseDto predict(PredictRequestDto requestDto) {
        String[] catFeatures = new String[]{
                requestDto.sex
        };
        float[] numericFeatures = new float[]{
                (float) requestDto.age,
                (float) requestDto.goout,
                (float) requestDto.absences,
                (float) requestDto.studytime,
                (float) requestDto.famrel,
                (float) requestDto.walc,
                (float) requestDto.freetime
        };
        try {
            CatBoostPredictions prediction = model.predict(numericFeatures, catFeatures);

            // В этой задаче известно: 5 классов (метки 1..5)
            final int numClasses = 5;
            int bestIdx = 0;
            double bestVal = prediction.get(0, 0);
            for (int i = 1; i < numClasses; i++) {
                double val = prediction.get(0, i);
                if (val > bestVal) {
                    bestVal = val;
                    bestIdx = i;
                }
            }
            double predictedClass = bestIdx + 1; // вернуть метку 1..5

            System.out.println("Predicted: " + predictedClass);
            System.out.println("Numeric features: " + Arrays.toString(numericFeatures));
            System.out.println("Categorical features: " + Arrays.toString(catFeatures));
            return new PredictResponseDto(predictedClass);
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
}
