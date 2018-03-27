package id.wiryawan.jwttokenlogin.model;

public class ChoiceVoteCount {
    private Integer choiceId;
    private Integer voteCount;

    public ChoiceVoteCount(Integer choiceId, Integer voteCount) {
        this.choiceId = choiceId;
        this.voteCount = voteCount;
    }

    public Integer getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(Integer choiceId) {
        this.choiceId = choiceId;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }
}
