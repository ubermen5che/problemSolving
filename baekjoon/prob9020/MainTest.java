package prob9020;

import org.junit.Test;

import java.io.*;
import java.nio.Buffer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MainTest {

    @Test
    public void mainTest(){
        try{
            //파일 객체 생성
            File correct = new File("/Users/yong/github/PS/baekjoon/prob9020/correct.txt");
            File fail = new File("/Users/yong/github/PS/baekjoon/prob9020/fail.txt");
            //입력 스트림 생성
            FileReader file_reader_correct = new FileReader(correct);
            FileReader file_reader_fail = new FileReader(fail);

            BufferedReader bufferedReader_correct = new BufferedReader(file_reader_correct);
            BufferedReader bufferedReader_fail = new BufferedReader(file_reader_fail);

            String line_correct = "";
            String line_fail = "";

            while(((line_correct = bufferedReader_correct.readLine()) != null)){
                line_fail = bufferedReader_fail.readLine();

                System.out.println("line_fail = " + line_fail);
                System.out.println("line_correct = " + line_correct);
                assertThat(line_fail, is(line_correct));
            }
            file_reader_correct.close();
            file_reader_fail.close();
        }catch (FileNotFoundException e) {
            e.getStackTrace();
        }catch(IOException e){
            e.getStackTrace();
        }
    }
}
