package com.rest.springrest.controllers;

import com.rest.springrest.model.Question;
import com.rest.springrest.model.Survey;
import com.rest.springrest.services.QuestionService;
import com.rest.springrest.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class SurveyController {

    @Autowired
    private SurveyService surveyService;
    @Autowired
    private QuestionService questionService;

    @RequestMapping("/surveys")
    public List<Survey> getAllSurveys() {
        return surveyService.getAllSurveys();
    }

    @RequestMapping("surveys/{id}")
    public Survey getSurveyById(@PathVariable int id) {
        Survey survey = surveyService.getSurveyById(id);
        if (survey == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return survey;
    }

    @RequestMapping("surveys/{id}/questions")
    public List<Question> getQuestionsBySurveyById(@PathVariable int id) {
        List<Question> questions = questionService.getQuestionsInSurveyById(id);
        if (questions == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return questions;
    }

    @RequestMapping("surveys/{surveyId}/questions/{questionId}")
    public Question getQuestionFromSurveyById(@PathVariable int surveyId, @PathVariable int questionId) {
        Survey survey = surveyService.getSurveyById(surveyId);
        List<Question> questions;
        Question question;

        if (survey != null) {
            questions = survey.getQuestions();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (questions != null) {
            question = questionService.getQuestionById(questions, questionId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (question == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return question;
    }
}
