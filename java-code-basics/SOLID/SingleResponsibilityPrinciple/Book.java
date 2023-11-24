package SingleResponsibilityPrinciple;

public class Book {
    private String name;
    private String author;
    private String text;

    // the below method working well as they belongs to book properties
    public void replaceWordInText(String word, String replacementWord){
         text.replaceAll(word, replacementWord);
    }
    public boolean isWordPresentInText(String word){
        return text.contains(word);
    }
// Suppose we add a new a new Method which is responsible for printing book text to console as mentioned below
    public void printTextToConsole(){
        System.out.println(text);
    }
    //As this violate the single responsibility Principle.
    // To fix this mess we should implement a seperate class that deal with only printing the text
    // As we create a seperate BookPrinting class that relieves the book of its printing duties but also it we can use this class to
    //print book text in different media whether its email , logging  or anything else

}

class BookPrinter {
    void printTextToConsole(String text){
        System.out.println(text);
    }
    void printToLogFile(String text){
        //code to print text to log file
    }
}


