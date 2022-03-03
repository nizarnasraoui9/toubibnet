package com.toubibnet.toubibnet.dto;

import com.toubibnet.toubibnet.model.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionPerPageDto {
    private Long total;
    List<Question> question;
}
