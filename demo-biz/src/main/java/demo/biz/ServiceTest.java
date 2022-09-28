package demo.biz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ServiceTest {
    public static void main(String args[]) {
//        execShell("ps u");
        printInfo();
    }


    public static void execShell(String cmd){
        Process process = null;
        List<String> processList = new ArrayList<String>();
        try {
            process = Runtime.getRuntime().exec(cmd);
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = input.readLine()) != null) {
                processList.add(line);
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String line : processList) {
            System.out.println(line);
        }
    }

    public static void printInfo(){
        Map m = System.getenv();
        for (Iterator it = m.keySet().iterator(); it.hasNext(); )
        {
            String key = (String ) it.next();
            String value = (String ) m.get(key);
            System.out.println(key +":" +value);
        }
        System.out.println( "--------------------------------------" );
        Properties p = System.getProperties();

        for ( Iterator it = p.keySet().iterator(); it.hasNext(); )
        {
            String key = (String ) it.next();
            String value = (String ) p.get(key);
            System.out.println(key +":" +value);
        }
    }
}


