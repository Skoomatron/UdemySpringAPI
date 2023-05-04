package com.rest.springrest.services;

import com.rest.springrest.model.Question;
import com.rest.springrest.model.Survey;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SurveyService {

    private static List<Survey> surveys = new ArrayList<>();
    static {
        Question question1 = new Question(1, "Who is the main character of FF7?", Arrays.asList("Barret", "Cloud", "Tifa"), "Cloud");
        Question question2 = new Question(2, "Who is the black mage from FF9?", Arrays.asList("Vivi", "Zidane", "Steiner"), "Vivi");
        Question question3 = new Question(3, "What is the long running holy element summon?", Arrays.asList("Carbuncle", "Doom Train", "Alexander"), "Alexander");
        List<Question> questions = new ArrayList<>(Arrays.asList(question1, question2, question3));
        Survey survey = new Survey(101, "FF Survey", "A series of FF questions.", questions);
        surveys.add(survey);
    }

    public List<Survey> getAllSurveys() {
        return surveys;
    }
}
