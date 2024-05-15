package week11.j061;

public class Word {
    private String english;
    private String korean;
    private int level;

    public Word(String english, String korean, int level) {
        this.english = english;
        this.korean = korean;
        this.level = level;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getKorean() {
        return korean;
    }

    public void setKorean(String korean) {
        this.korean = korean;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Word [English=" + english + ", Korean=" + korean + ", Level=" + level + "]";
    }
}
