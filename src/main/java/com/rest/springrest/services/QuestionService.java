package com.rest.springrest.services;

import com.rest.springrest.model.Question;
import com.rest.springrest.model.Survey;
import com.rest.springrest.utils.RestUtilities;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class QuestionService {

    SurveyService surveyService = new SurveyService();
    RestUtilities restUtilities = new RestUtilities();

    public List<Question> getQuestionsInSurveyById(String id) {
        Survey survey = surveyService.getSurveyById(id);
        if (survey == null) {
            return null;
        }
        return survey.getQuestions();
    }

    public Question getQuestionById(List<Question> questions, String id) {
        Predicate<? super Question> predicate = question -> question.getId().equalsIgnoreCase(id);
        Optional<Question> optionalQuestion = questions.stream().filter(predicate).findFirst();
        if (optionalQuestion.isEmpty()) {
            return null;
        }

        return optionalQuestion.get();
    }

    public String addQuestionToSurvey(String surveyId, Question question) {
        Survey survey = surveyService.getSurveyById(surveyId);
        List<Question> questions = survey.getQuestions();
        question.setId(restUtilities.randomId());
        questions.add(question);
        return question.getId();
    }
}
