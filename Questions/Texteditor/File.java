package Texteditor;

import java.util.Date;

public class File {
    Integer id;
    User createdBy;
    FileHistory fileHistory;
    Date lastUpdatedAt;

    public File(Integer id, User createdBy, FileHistory fileHistory, Date lastUpdatedAt) {
        this.id = id;
        this.createdBy = createdBy;
        this.fileHistory = fileHistory;
        this.lastUpdatedAt = lastUpdatedAt;
    }

}
