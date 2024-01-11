package Texteditor;


import java.util.ArrayList;

public class Main {
    public static void main(String [] args){
        Editor notePad= new Editor(new ArrayList<>(), new ArrayList<>());
        User pavan = new User();
        FileHistory fileHistory = new FileHistory(new ArrayList<>(), 0);
        TextFile textFile = new TextFile(1,pavan, fileHistory, null, "");

        System.out.println(textFile.getContent());
        textFile.write(0, "i am here");
        System.out.println(textFile.getContent());
        textFile.write(4, " for interview");

        System.out.println(textFile.getContent());
        textFile.remove(4, 7);
        System.out.println(textFile.getContent());

        textFile.undo();
        System.out.println(textFile.getContent());

        textFile.undo();
        System.out.println(textFile.getContent());

        textFile.redo();
        System.out.println(textFile.getContent());

        textFile.redo();
        System.out.println(textFile.getContent());

        notePad.saveFile(textFile);
        System.out.println(textFile.fileHistory.getHistory().size());
    }






}
//    => file<1>
//            => user<1>
//            => fileid => getThfile
//            <File> getFile()
//    file.write(index, content) {
//        file.remove(startindx, endIndx)
//        file.updateHistory()
//                => undo
//    }
