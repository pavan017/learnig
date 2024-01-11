package Texteditor;

import java.util.List;

public class Editor {
    List<File> files;
    List<User> users;

    public Editor(List<File> files, List<User> users) {
        this.files = files;
        this.users = users;
    }

    public void addFile(File file){
        this.files.add(file);
    }

    public void addUser(User user){
        this.users.add(user);
    }
    public void saveFile(File file){
        file.fileHistory.removeHistory();
//        file.lastUpdatedAt()


    }
    //    saveFile()
}
