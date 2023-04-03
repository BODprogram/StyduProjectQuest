package textquest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class InteractiveEmotion {

    ThreadLocalRandom random = ThreadLocalRandom.current();

    private final String SUCCESS_EMOTION_1 = "Huh! Easiest doorway in my life.";
    private final String SUCCESS_EMOTION_2 = "Looking for a toilet...";
    private final String SUCCESS_EMOTION_3 = "New place - new tools!";
    private final String SUCCESS_EMOTION_4 = "Yeah, this room looks like cavern...";

    private final String FAILURE_EMOTION_1 = "This is a wall.";
    private final String FAILURE_EMOTION_2 = "There is no passage on that side.";
    private final String FAILURE_EMOTION_3 = "I don't think I need to go there...";
    private final String FAILURE_EMOTION_4 = "There doesn't seem to be anything interesting.";

    List<String> successEmotions = Arrays.asList(   SUCCESS_EMOTION_1,
                                                    SUCCESS_EMOTION_2,
                                                    SUCCESS_EMOTION_3,
                                                    SUCCESS_EMOTION_4);

    List<String> failureEmotions = Arrays.asList(   FAILURE_EMOTION_1,
                                                    FAILURE_EMOTION_2,
                                                    FAILURE_EMOTION_3,
                                                    FAILURE_EMOTION_4);

    public String getRandomSuccessEmotion(){

        StringBuilder stringBuilder = new StringBuilder();
        String randomEmotion = successEmotions.get(random.nextInt(successEmotions.size()));
        stringBuilder.append(randomEmotion);
        return stringBuilder.toString();

    }

    public String getRandomFailureEmotion(){

        StringBuilder stringBuilder = new StringBuilder();
        String randomEmotion = failureEmotions.get(random.nextInt(failureEmotions.size()));
        stringBuilder.append(randomEmotion);
        return stringBuilder.toString();

    }

}
