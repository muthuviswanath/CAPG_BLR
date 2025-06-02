public class Photoshop{
    
    void openFile(SystemFiles f){
        if ( f instanceof PngFile){
        f.display();
        PngFile png = (PngFile) f;
        png.check();
        }
        else if (f instanceof JpegFile){
            f.display();
        }
        else if(f instanceof PdfFile){
            f.display();
        }
        else{
            System.out.println("Invalid file type");
        }
    }

    public static void main(String[] args) {
        Photoshop ps = new Photoshop();
        JpegFile jpeg = new JpegFile("MyPic",".jpg",23);
        ps.openFile(jpeg);
        System.out.println();
        PngFile p = new PngFile("MyBio", ".png", 45);
        ps.openFile(p);
        PdfFile pdf = new PdfFile("MyResume",".pdf",456);
        ps.openFile(pdf);
    }
}