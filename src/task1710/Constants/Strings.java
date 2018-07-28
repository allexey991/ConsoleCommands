package task1710.Constants;

public class Strings {
    public final static String ERR_ID = "Wrong id format, it should be only number!";
    public final static String ERR_BT = "Wrong parameter birthday: ";
    public final static String ERR_SX = "Wrong parameter sex: ";
    public final static String ERR_CNT = "Wrong parameter's count";
    public final static String ERR_UNCMD = "Unknown command. Type Help for more information.";

    public final static String HELP = "\t=========HELP=========\n" +
            "   description |input_param\n" +
            "-------------------------------------\n" +
            "-c create\n" +
            "\tadd person\t|name\n" +
            "\t\t\t\t|sex (м/ж)\n" +
            "\t\t\t\t|birthday (dd/mm/yyyy)\n" +
            "-------------------------------------\n" +
            "-i  return\t\t\n" +
            "\tperson\t\t|id\n" +
            "\t\t\t\t|name\n" +
            "\t\t\t\t|sex (м/ж)\n" +
            "\t\t\t\t|birthday (dd/mm/yyyy)\n" +
            "-------------------------------------\n" +
            "-d  delete\n" +
            "\tperson\t\t|id\n" +
            "-------------------------------------\n" +
            "-u  update\n" +
            "\tperson\t\t|id";

    private static Strings sInstance;
    static {
        if (sInstance == null)
            sInstance = new Strings();
    }
    public static Strings getInstance(){
        return sInstance;
    }


}
