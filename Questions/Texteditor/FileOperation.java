package Texteditor;

public interface FileOperation {
    public void write(Integer fileIndx, String content);
    public void remove(Integer startIndx, Integer endIndx);
    public void updateHistory(String content);
    public void redo();
    public void undo();
}
