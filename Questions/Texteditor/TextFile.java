package Texteditor;

import java.util.Date;

public class TextFile extends File implements FileOperation{
    String content;
    public TextFile(Integer id, User createdBy, FileHistory fileHistory, Date lastUpdatedAt, String content) {
        super(id, createdBy, fileHistory, lastUpdatedAt);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void write(Integer fileIndx, String input) {
//        if(fileIndx> content.length()){
//            System.out.println("");
//        }
        String firstPart = this.content.substring(0, fileIndx);
        String lastPart = "";
        if(fileIndx< content.length()) {
            lastPart = this.content.substring(fileIndx, content.length());
        }
        String finalString = firstPart+input+lastPart;
        setContent(finalString);
        updateHistory(finalString);
    }

    @Override
    public void remove(Integer startIndx, Integer endIndx) {
        String firstPart = this.content.substring(0, startIndx);
        String lastPart = this.content.substring(endIndx, content.length());
        String finalString = firstPart+lastPart;
        setContent(finalString);
        updateHistory(finalString);
    }

    @Override
    public void updateHistory(String content) {
        this.fileHistory.history.add(content);
        int currentIndx = this.fileHistory.getCurrentStateIndx();
        this.fileHistory.setCurrentStateIndx(currentIndx+1);
    }

    @Override
    public void redo() {
        int currentIndx = this.fileHistory.getCurrentStateIndx();
        this.fileHistory.setCurrentStateIndx(currentIndx+1);
        setContent(this.fileHistory.getHistory().get(currentIndx));
    }

    @Override
    public void undo() {
        int currentIndx = this.fileHistory.getCurrentStateIndx();
        this.fileHistory.setCurrentStateIndx(currentIndx-1);
        this.setContent(this.fileHistory.getHistory().get(currentIndx-2));
    }
}
