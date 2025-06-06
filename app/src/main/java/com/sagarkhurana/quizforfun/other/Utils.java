package com.sagarkhurana.quizforfun.other;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Patterns;

import com.sagarkhurana.quizforfun.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Utils {

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public static String formatDate(long time) {
        String pattern = Build.VERSION.SDK_INT >= Build.VERSION_CODES.N ?
                Constants.DATE_FORMAT : "dd MMM yyyy hh:mm a";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return formatter.format(calendar.getTime());
    }

    public static Map<String,String> getMathQuestions() {
        HashMap<String,String> questions = new HashMap<>();
        questions.put("What is the square root of 144?","12");
        questions.put("What is the value of π (pi) rounded to 2 decimal places?","3.14");
        questions.put("What is 5² − 3²?","16");
        questions.put("What is the next prime number after 17?","19");
        questions.put("What is 15% of 200?","30");
        questions.put("What is the perimeter of a square with side length 7 cm?","28");
        questions.put("What is 3/4 as a decimal?","0.75");
        questions.put("What is (10 + 2) × 3?","36");
        questions.put("How many sides does a hexagon have?","6");
        questions.put("If x = 3, what is the value of 2x² + 1?","19");
        questions.put("What is 0 divided by any non-zero number?","0");
        questions.put("What is the area of a triangle with base 10 cm and height 6 cm?","30 cm²");
        questions.put("What is the derivative of x²?","2x");
        questions.put("How many degrees are there in a right angle?","90");
        questions.put("If a rectangle has length 10 cm and width 4 cm, what is its area?","40 cm²");
        return questions;
    }

    public static Map<String,String> getRandomMathQuestions(int SIZE) {
        HashMap<String,String> questionsMap = new HashMap<>();
        Map<String,String> originalQuestion = getMathQuestions();
        int originalSize = originalQuestion.size();
        ArrayList<String> keyList = new ArrayList<>(originalQuestion.keySet());

        while (questionsMap.size() < SIZE) {
            Random random = new Random();
            int randomNumber = random.nextInt(originalSize);
            String question = keyList.get(randomNumber);
            if (!questionsMap.containsKey(question)) {
                questionsMap.put(question, originalQuestion.get(question));
            }
        }
        return questionsMap;
    }

    public static Map<String,Map<String,Boolean>> getLiteratureQuestions() {
        HashMap<String,Map<String,Boolean>> questions = new HashMap<>();
        HashMap<String,Boolean> answer1 = new HashMap<>();
        answer1.put("Maya Angelou",true);
        answer1.put("Robert Hass",false);
        answer1.put("Jessica Hagdorn",false);
        answer1.put("Micheal Palmer",false);
        questions.put("Which American writer published ‘A brave and startling truth’ in 1996?",answer1);

        HashMap<String,Boolean> answer2 = new HashMap<>();
        answer2.put("Acrostic",true);
        answer2.put("Haiku",false);
        answer2.put("Epic",false);
        answer2.put("Alliterative",false);
        questions.put("What is a poem called whose first letters of each line spell out a word?",answer2);

        HashMap<String,Boolean> answer3 = new HashMap<>();
        answer3.put("Limerick",true);
        answer3.put("Quartet",false);
        answer3.put("Sextet",false);
        answer3.put("Palindrome",false);
        questions.put("What is a funny poem of five lines called?",answer3);

        HashMap<String,Boolean> answer4 = new HashMap<>();
        answer4.put("Robert Greene",true);
        answer4.put("John Milton",false);
        answer4.put("Philip Sidney",false);
        answer4.put("Christopher Marlowe",false);
        questions.put("Who succeeded Lyly?",answer4);

        HashMap<String,Boolean> answer5 = new HashMap<>();
        answer5.put("Hamlet",true);
        answer5.put("Cymbeline",false);
        answer5.put("Titus Andronicus",false);
        answer5.put("Pericles, Prince of Tyre",false);
        questions.put("Which famous Shakespeare play does the quote, “Neither a borrower nor a lender be” come from?",answer5);

        HashMap<String,Boolean> answer6 = new HashMap<>();
        answer6.put("16th",true);
        answer6.put("17th",false);
        answer6.put("14th",false);
        answer6.put("15th",false);
        questions.put("In which century was Shakespeare born?",answer6);

        HashMap<String,Boolean> answer7 = new HashMap<>();
        answer7.put("A thief",true);
        answer7.put("A clerk",false);
        answer7.put("A teacher",false);
        answer7.put("A dentist",false);
        questions.put("Who is Mr. Tench in The Power and the Glory?",answer7);

        HashMap<String,Boolean> answer8 = new HashMap<>();
        answer8.put("Coleridge",true);
        answer8.put("Wordsworth",false);
        answer8.put("Lamb",false);
        answer8.put("Shelley",false);
        questions.put("Who said ‘Keats was a Greek’?",answer8);

        HashMap<String,Boolean> answer9 = new HashMap<>();
        answer9.put("Gertrude",true);
        answer9.put("Beatrice",false);
        answer9.put("Margaret",false);
        answer9.put("Rosalind",false);
        questions.put("Which of the following is Hamlet’s mother?",answer9);

        HashMap<String,Boolean> answer10 = new HashMap<>();
        answer10.put("Stingy",true);
        answer10.put("Rude",false);
        answer10.put("Unintelligent",false);
        answer10.put("Fanatic",false);
        questions.put("Which of the following was Elizabeth known as?",answer10);

        HashMap<String,Boolean> answer11 = new HashMap<>();
        answer11.put("Keats",true);
        answer11.put("Blake",false);
        answer11.put("Tennyson",false);
        answer11.put("Shelley",false);
        questions.put("For whom is it said: “sensuousness is a paramount bias of his genius”?",answer11);

        HashMap<String,Boolean> answer12 = new HashMap<>();
        answer12.put("Maud",true);
        answer12.put("Ulysses",false);
        answer12.put("Break, Break, Break",false);
        answer12.put("Crossing the Bar",false);
        questions.put("Which of the following poems by Tennyson is a monodrama?",answer12);

        HashMap<String,Boolean> answer13 = new HashMap<>();
        answer13.put("Southey",true);
        answer13.put("Tennyson",false);
        answer13.put("Byron",false);
        answer13.put("Wordsworth",false);
        questions.put("Which one of the following poets was appointed Poet Laureate in the year 1813?",answer13);

        HashMap<String,Boolean> answer14 = new HashMap<>();
        answer14.put("Wordsworth",true);
        answer14.put("Keats",false);
        answer14.put("Byron",false);
        answer14.put("Blake",false);
        questions.put("Who believed that poetry is the spontaneous overflow of emotions?",answer14);

        HashMap<String,Boolean> answer15 = new HashMap<>();
        answer15.put("Dickens",true);
        answer15.put("George Eliot",false);
        answer15.put("Hardy",false);
        answer15.put("None of the above",false);
        questions.put("Moral choice is everything in the works of:",answer15);
        return questions;
    }

    public static Map<String,Map<String,Boolean>> getGeographyQuestions() {
        HashMap<String,Map<String,Boolean>> questions = new HashMap<>();
        HashMap<String,Boolean> answer1 = new HashMap<>();
        answer1.put("Mustard",false);
        answer1.put("Linseed",false);
        answer1.put("Groundnut",true);
        answer1.put("Coconut",false);
        questions.put("Which of the following can cause a serious edible oil crisis in India due to scarcity or crop failure?",answer1);

        HashMap<String,Boolean> answer2 = new HashMap<>();
        answer2.put("Old mountains",true);
        answer2.put("Young mountains",false);
        answer2.put("Fold mountains",false);
        answer2.put("Block mountains",false);
        questions.put("The Pennines (Europe), Appalachians (America), and the Aravallis (India) are examples of?",answer2);

        HashMap<String,Boolean> answer3 = new HashMap<>();
        answer3.put("5",false);
        answer3.put("13",true);
        answer3.put("8",false);
        answer3.put("10",false);
        questions.put("How many major ports are there in India?",answer3);

        HashMap<String,Boolean> answer4 = new HashMap<>();
        answer4.put("Gondak",false);
        answer4.put("Kosi",false);
        answer4.put("Sutlej",false);
        answer4.put("Krishna",true);
        questions.put("Which of the following is a peninsular river of India?",answer4);

        HashMap<String,Boolean> answer5 = new HashMap<>();
        answer5.put("1730 hours",false);
        answer5.put("0630 hours",true);
        answer5.put("Midnight, GMT",false);
        answer5.put("None of the above",false);
        questions.put("When it is noon IST at Allahabad in India, what is the time at Greenwich, London?",answer5);

        HashMap<String,Boolean> answer6 = new HashMap<>();
        answer6.put("USA",false);
        answer6.put("Canada",true);
        answer6.put("Australia",false);
        answer6.put("India",false);
        questions.put("Which country has the largest coastline?",answer6);

        HashMap<String,Boolean> answer7 = new HashMap<>();
        answer7.put("Alluvial soils",true);
        answer7.put("Black soils",false);
        answer7.put("Laterite soils",false);
        answer7.put("Red soils",false);
        questions.put("Which type of soil is mostly confined to river basins and coastal plains of India?",answer7);

        HashMap<String,Boolean> answer8 = new HashMap<>();
        answer8.put("USA",true);
        answer8.put("India",false);
        answer8.put("Australia",false);
        answer8.put("France",false);
        questions.put("Which country leads in the production of aluminium and its products in the world?",answer8);

        HashMap<String,Boolean> answer9 = new HashMap<>();
        answer9.put("Coconut",true);
        answer9.put("Cotton",false);
        answer9.put("Sugarcane",false);
        answer9.put("Rice",false);
        questions.put("Which of the following crops is regarded as a plantation crop?",answer9);

        HashMap<String,Boolean> answer10 = new HashMap<>();
        answer10.put("33.3%",true);
        answer10.put("30.3%",false);
        answer10.put("38.3%",false);
        answer10.put("42.3%",false);
        questions.put("What is the proportion of forest to the total national geographical area of India as envisaged by National Forest Policy?",answer10);

        HashMap<String,Boolean> answer11 = new HashMap<>();
        answer11.put("Gandhi Sagar",true);
        answer11.put("Hirakud",false);
        answer11.put("Periyar",false);
        answer11.put("Tungabhadra",false);
        questions.put("Which of the following dams has power generation as its main purpose over irrigation?",answer11);

        HashMap<String,Boolean> answer12 = new HashMap<>();
        answer12.put("The lesser Himalayas and the Indo-Gangetic plain",true);
        answer12.put("The foothills and the Indo-Gangetic plain",false);
        answer12.put("The greater Himalayas and the lesser Himalayas",false);
        answer12.put("Indo-Gangetic plains and the peninsula",false);
        questions.put("The outer Himalayas lie between?",answer12);

        HashMap<String,Boolean> answer13 = new HashMap<>();
        answer13.put("Aravalis",true);
        answer13.put("Vindhyas",false);
        answer13.put("Satpuras",false);
        answer13.put("Nilgiri hills",false);
        questions.put("Which are the oldest mountains in India?",answer13);

        HashMap<String,Boolean> answer14 = new HashMap<>();
        answer14.put("1/6",true);
        answer14.put("1/3",false);
        answer14.put("1/10",false);
        answer14.put("1/50",false);
        questions.put("Approximately what fraction of the world’s population lives in India?",answer14);

        HashMap<String,Boolean> answer15 = new HashMap<>();
        answer15.put("Second",true);
        answer15.put("Third",false);
        answer15.put("Fourth",false);
        answer15.put("Fifth",false);
        questions.put("India has the ___ largest population on Earth?",answer15);
        return questions;
    }

    public static Map<String,Map<String,Boolean>> getRandomLiteratureAndGeographyQuestions(Context context, String subject, int SIZE) {
        Map<String,Map<String,Boolean>> questionsMap = new HashMap<>();
        Map<String, Map<String, Boolean>> originalQuestion;
        if (subject.equals(context.getString(R.string.geography))) {
            originalQuestion = getGeographyQuestions();
        } else {
            originalQuestion = getLiteratureQuestions();
        }

        int originalSize = originalQuestion.size();
        ArrayList<String> keyList = new ArrayList<>(originalQuestion.keySet());

        while (questionsMap.size() < SIZE) {
            Random random = new Random();
            int randomNumber = random.nextInt(originalSize);
            String question = keyList.get(randomNumber);
            if (!questionsMap.containsKey(question)) {
                questionsMap.put(question, originalQuestion.get(question));
            }
        }
        return questionsMap;
    }
}