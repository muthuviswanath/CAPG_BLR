public class SystemFiles{
    String extension, filename;
    int fileSize;
    
    SystemFiles(String filename, String extension, int fileSize){
        this.filename = filename;
        this.extension = extension;
        this.fileSize = fileSize;
    }

    void display(){
        System.out.println(this.filename + this.extension);
        System.out.println(this.fileSize + " KBs");
    }

}