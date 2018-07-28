package task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderThread extends Thread{
    private String readString = "";
    BufferedReader reader
            = new BufferedReader(new InputStreamReader(System.in));
    @Override
    public void run() {

        while (!isInterrupted()){
            try {
                readString = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (readString.equals("exit"))
                interrupt();
            else if (!CheckData.getInstance().checkInputParam(getReadedString()))
                    {
                        System.out.println("Error of input:");
                        CheckData.getInstance().getErrorList();
                    }
        }

    }
    public String[] getReadedString(){
        return readString.split(" ");
    }
}
