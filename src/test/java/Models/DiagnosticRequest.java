package Models;
import java.util.List;

public class DiagnosticRequest
{
    private List<QuestionAnswer> questions;

    public DiagnosticRequest(List<QuestionAnswer> questions)
    {
        this.questions = questions;
    }

    public List<QuestionAnswer> getQuestions()
    {
        return questions;
    }

    public void setQuestions(List<QuestionAnswer> questions)
    {
        this.questions = questions;
    }

    public static class QuestionAnswer
    {
        private int question;
        private String answer;

        public QuestionAnswer(int question, String answer)
        {
            this.question = question;
            this.answer = answer;
        }

        public int getQuestion()
        {
            return question;
        }

        public void setQuestion(int question)
        {
            this.question = question;
        }

        public String getAnswer()
        {
            return answer;
        }

        public void setAnswer(String answer)
        {
            this.answer = answer;
        }
    }
}

