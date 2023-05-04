package com.rest.springrest.controllers;

import com.rest.springrest.model.Survey;
import com.rest.springrest.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @RequestMapping("/getSurveys")
    public List<Survey> getSurveys() {
        return surveyService.getAllSurveys();
    }
}
