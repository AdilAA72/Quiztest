package notification.android.tutos.com.quiz;

import java.util.List;

/**
 * Created by aadjo on 18/07/2018.
 */

public class Question {

    private String mQuestion;
    private List<String> mChoiceList;
    private int mAnswerIndex;

    public Question(String s, List<String> strings, int i) {
        this.mQuestion = s;
        this.mChoiceList = strings;
        this.mAnswerIndex = i;

    }

    public String getmQuestion() {
        return mQuestion;
    }

    public List<String> getmChoiceList() {
        return mChoiceList;
    }

    public int getmAnswerIndex() {
        return mAnswerIndex;
    }

    public void setmQuestion(String mQuestion) {
        this.mQuestion = mQuestion;
    }

    public void setmChoiceList(List<String> mChoiceList) {
        this.mChoiceList = mChoiceList;
    }

    public void setmAnswerIndex(int mAnswerIndex) {
        this.mAnswerIndex = mAnswerIndex;
    }
}
