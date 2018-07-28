package task1710;
import task1710.Constants.Strings;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class CheckData {
    private static CheckData sInstance;
    private List<String> errorInputlist = new ArrayList<>();
    static {
        if (sInstance == null)
            sInstance = new CheckData();
    }

    public static CheckData getInstance(){
        return sInstance;
    }

    public synchronized boolean checkInputParam(String[] args){
        String command = args[0];
        boolean result = false;
        errorInputlist.clear();
        switch (command) {
        case "-c":
            result = (args.length == 4 && checkSex(args[2]) && checkInputDate(args[3]));
            break;
        case "-u":
            result = (args.length == 4 && checkSex(args[2]) && checkInputDate(args[3]) && checkInputId(args[1]));
            break;
        case "-d":
            result = (args.length == 2 && checkInputId(args[1]));
            break;
        case "-i":
            result = (args.length == 2 && checkInputId(args[1]));
            break;
        case "help":
            System.out.println(Strings.HELP);
            result = true;
            break;
        default:
            System.out.println(Strings.ERR_UNCMD);
            result = true;
            break;
        }
        return result;
    }

    /**
     * Check sex format
     * @param sex
     *
     * @return
     *        true/false
     */
    private boolean checkSex(String sex){

        if (sex.equals("м") ||sex.equals("ж"))
            return true;
        else{
            errorInputlist.add(Strings.ERR_SX +sex);
            return false;
        }

    }

    /**
     * Check input date
     * @param date
     *          date should be format - dd/MM/yyyy
     * @return
     */
    private boolean checkInputDate(String date){
        Date _date = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
            _date = sdf.parse(date);
            if (!date.equals(sdf.format(_date))) {
                date = null;
                errorInputlist.add(Strings.ERR_BT+date);
            }
        } catch (ParseException ex) {
            errorInputlist.add(Strings.ERR_BT+date);
        }

        return (_date != null);
    }
    private boolean checkInputId(String id){
        boolean result = false;
        try {
            Integer.parseInt(id);
            result = true;
        }catch (NumberFormatException ex)
        {
            errorInputlist.add(Strings.ERR_ID);
        }
        return result;
    }


    public void getErrorList(){
        if (errorInputlist.isEmpty())
            System.out.println(Strings.ERR_CNT);
        else for (String error : errorInputlist){
                System.out.println(error);
            }
    }

}
