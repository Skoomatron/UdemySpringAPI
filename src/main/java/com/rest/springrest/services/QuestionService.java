package com.rest.springrest.services;

import com.rest.springrest.model.Question;
import com.rest.springrest.model.Survey;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class QuestionService {

    SurveyService surveyService = new SurveyService();

    public List<Question> getQuestionsInSurveyById(int id) {
        Survey survey = surveyService.getSurveyById(id);
        if (survey == null) {
            return null;
        }
        return survey.getQuestions();
    }

    public Question getQuestionById(List<Question> questions, int id) {
        Predicate<? super Question> predicate = question -> question.getId() == id;
        Optional<Question> optionalQuestion = questions.stream().filter(predicate).findFirst();
        if (optionalQuestion.isEmpty()) {
            return null;
        }

        return optionalQuestion.get();
    }
}
