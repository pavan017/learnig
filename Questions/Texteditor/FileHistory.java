package Texteditor;

import java.util.ArrayList;
import java.util.List;

public class FileHistory {
    public FileHistory(List<String> history, Integer currentStateIndx) {
        this.history = history;
        this.currentStateIndx = currentStateIndx;
    }

    List<String> history;
    Integer currentStateIndx;

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }

    public Integer getCurrentStateIndx() {
        return currentStateIndx;
    }

    public void setCurrentStateIndx(Integer currentStateIndx) {
        this.currentStateIndx = currentStateIndx;
    }


    public void removeHistory(){
        this.history = new ArrayList<>();
        this.currentStateIndx = 0;
    }
}
