package bai16_io_text_file.exercise.copy_file_text;

import bai16_io_text_file.practice.option_read_file_example.ReadFileExample;
import sun.reflect.misc.FieldUtil;

import java.io.*;
import java.nio.file.Files;

public class CopyFileText {
//    public void copyFileText(String filePath) throws IOException {
//        try {
//            File file = new File(filePath);
//            if (!file.exists()) {
//                throw new FileNotFoundException();
//            }
//            BufferedReader br = new BufferedReader(new FileReader(file));
//            String line = "";
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
//            br.close();
//        } catch (Exception e) {
//            System.err.println("Fie không tồn tại or nội dung có lỗi!");
//        }
//    }

    public static void main(String[] args) throws IOException {
        File source = new File("D:\\C0221G1_TruongVanNhat\\module_2\\src\\bai16_io_text_file\\exercise\\copy_file_text\\test1.txt");
        File dest = new File("D:\\C0221G1_TruongVanNhat\\module_2\\src\\bai16_io_text_file\\exercise\\copy_file_text\\test2.txt");

        try {
            FileInputStream src = new FileInputStream(source);
            FileOutputStream de = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;

            while ((length = src.read(buffer)) > 0) {
                de.write(buffer, 0, length);
            }
            System.out.println("done");
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
    }
}
