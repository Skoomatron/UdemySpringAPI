package com.rest.springrest.services;

import com.rest.springrest.model.Question;
import com.rest.springrest.model.Survey;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class SurveyService {

    private static List<Survey> surveys = new ArrayList<>();
    static {
        Question question1 = new Question(1, "Who is the main character of FF7?", Arrays.asList("Barret", "Cloud", "Tifa"), "Cloud");
        Question question2 = new Question(2, "Who is the black mage from FF9?", Arrays.asList("Vivi", "Zidane", "Steiner"), "Vivi");
        Question question3 = new Question(3, "What is the long running holy element summon?", Arrays.asList("Carbuncle", "Doom Train", "Alexander"), "Alexander");
        List<Question> questions = new ArrayList<>(Arrays.asList(question1, question2, question3));
        List<Question> questions2 = new ArrayList<>(Arrays.asList(question1));
        Survey survey = new Survey(101, "FF Survey", "A series of FF questions.", questions);
        Survey survey2 = new Survey(102, "FF One Question", "Just One FF Question", questions2);
        surveys.add(survey);
        surveys.add(survey2);
    }

    public List<Survey> getAllSurveys() {
        return surveys;
    }

    public Survey getSurveyById(int id) {
        Predicate<? super Survey> predicate = survey -> survey.getId() == id;
        Optional<Survey> optionalSurvey = surveys.stream().filter(predicate).findFirst();

        if (optionalSurvey.isEmpty()) {
            return null;
        }

        return optionalSurvey.get();
    }
}
