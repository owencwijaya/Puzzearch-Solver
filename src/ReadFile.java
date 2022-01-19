import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class ReadFile{
    public static void readText(Matrix m, ArrayList<String> keywords, Scanner sc){

        /* input filename */
        String filename = "sample.txt";
        
        // filename = sc.nextLine();
        // while (filename == ""){
        //     System.out.println("Input your filename: ");
        //     filename = sc.nextLine();
        // }
        /* cek baca */

        try{
            File text = new File("test/" + filename);
            Scanner sizeReader = new Scanner(text);
            int rowSize = 0;

            while (sizeReader.hasNextLine() && sizeReader.nextLine() != "\n"){
                rowSize++;
                sizeReader.nextLine();
            }
            
            sizeReader.close();
            m.rows = rowSize - 1;

            Scanner lineReader = new Scanner(text);

            try{
                for(int i = 0; i < m.rows; i++){
                    String line = lineReader.nextLine();
                    String rows[] = line.split(" ");
                    m.cols = rows.length;
                    for(int j = 0; j < m.cols; j++){
                        m.buffer[i][j] = rows[j];
                    }
                }
                lineReader.nextLine();

                while(lineReader.hasNextLine()){
                    String kw = lineReader.nextLine();
                    keywords.add(kw);
                }
            } finally {
                lineReader.close();
            }


        } catch (FileNotFoundException e){
            System.out.println("File not found!");
            e.printStackTrace();
        }
    }
}