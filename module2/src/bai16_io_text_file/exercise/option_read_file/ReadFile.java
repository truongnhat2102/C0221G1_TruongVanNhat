package bai16_io_text_file.exercise.option_read_file;

import java.io.*;
import java.nio.Buffer;

public class ReadFile {
    public static void main(String[] args) throws IOException {
      try{
          FileReader source= new FileReader("D:\\C0221G1_TruongVanNhat\\module_2\\src\\bai16_io_text_file\\exercise\\option_read_file\\test.csv");
          BufferedReader reader = new BufferedReader(source);
          String line=null;
          while((line=reader.readLine())!=null){
              String[] split = line.split(",");
              System.out.println(split[5]);
          }
          source.close();
      } catch(IOException e){
          System.err.println("error");
      }
    }
}
