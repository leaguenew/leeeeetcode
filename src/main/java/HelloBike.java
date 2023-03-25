import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className: HelloBike
 * @author: Liguo Niu
 * @date: 2023-03-15
 */
public class HelloBike {


    private Map<String, Integer> str2cnt = new HashMap<>();

    /**
     * @description: get the word count
     * @param filename
     * @return
     */
    public Map<String, Integer> fileProcess(String filename) {

        if (null == filename || filename.length() == 0 || fileNotExist(filename)) {
            //logger
            System.out.println("filename is not exist");
            return str2cnt;
        }

        String[] listStr = processFile(filename);

        count(listStr);

        return str2cnt;
    }

    /**
     * @description: check file exist
     * @param fileName
     */
    private boolean fileNotExist(String fileName) {
        File file = new File(fileName);
        return !file.exists();
    }

    /**
     * @description: count the word
     * @param listStr
     */
    private void count(String[] listStr) {

        if (null == listStr || listStr.length == 0) {
            //logger
            return;
        }

        for(String str: listStr) {
            if (str2cnt.containsKey(str)) {
                str2cnt.put(str, str2cnt.get(str) + 1);
            } else {
                str2cnt.put(str, 1);
            }
        }
    }

    /**
     * @description: process file by file name
     * @param filename
     * @return
     */
    private String[] processFile(String filename) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String str = in.readLine();
//            while ((str = in.readLine()) != null) {
//                System.out.println(str);
//            }
            if (null == str) {
                return null;
            }
            return str.split("\\s+"); //split by space
        } catch (IOException e) {
            //logger
        }

        return null;
    }

    public static void main(String[] args) {
        HelloBike helloBike = new HelloBike();
        //case 1:
    }
}
