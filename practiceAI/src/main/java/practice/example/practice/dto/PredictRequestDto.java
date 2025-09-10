package practice.example.practice.dto;


import lombok.Data;

@Data
public class PredictRequestDto {
    public String sex;
    public int age;
    public int goout;
    public int absences;
    public int studytime;
    public int famrel;
    public int walc;
    public int freetime;
}
