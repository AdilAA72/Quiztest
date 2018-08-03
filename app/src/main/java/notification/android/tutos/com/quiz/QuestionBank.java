package notification.android.tutos.com.quiz;

import java.util.List;

/**
 * Created by aadjo on 18/07/2018.
 */

public class QuestionBank<Q> {
    private List<Question> mQuestionList;
    private int mNextQuestionIndex;

    public QuestionBank(List<Question> mQuestionList) {
        this.mQuestionList = mQuestionList;
        this.mNextQuestionIndex = mNextQuestionIndex;
    }


    public List<Question> getmQuestionList() {
        return mQuestionList;
    }

    public void setmQuestionList(List<Question> mQuestionList) {
        this.mQuestionList = mQuestionList;
    }

    public int getmNextQuestionIndex() {
        return mNextQuestionIndex;
    }

    public void setmNextQuestionIndex(int mNextQuestionIndex) {
        this.mNextQuestionIndex = mNextQuestionIndex;
    }


}