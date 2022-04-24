import java.util.ArrayList;
import java.util.List;

public class Hiker {
    List list;

    Hiker () {
        list = new ArrayList();
        list.add("91125426");
        list.add("97625992");
        list.add("911");
        list.add("9762");
    }
    Hiker (List list){
        this.list = new ArrayList();
        this.list.addAll(list);
    }

    public boolean isPrefix(String prefix) {
        if (prefix.trim().equals("")||prefix==null) return false;
        List list = getTempList(this.list, prefix);
        Indicator indicator = new Indicator();
        for(Object number : list){
            String numberStr = (String)number;
            int endInd =prefix.length()>numberStr.length()?numberStr.length():prefix.length();
            boolean signal =numberStr.substring(0,endInd).equals(prefix);
            indicator.alarm(signal);
            printBadPairs(signal,prefix + "---" + numberStr);
        }

        return indicator.getStatus();
    }

    private void printBadPairs(boolean equals,String toBePrint) {
        if(equals) System.out.println(toBePrint);
    }

    public boolean isConsistentList() {
        Indicator indicator = new Indicator();
        for(Object number : list){
            String numberStr = (String)number;
            indicator.alarm(isPrefix(numberStr));
        }
        return !indicator.getStatus();
    }

    private List  getTempList(List source, Object excludingMember){
        List tempList =  new ArrayList();
        tempList.addAll(list);
        tempList.remove(excludingMember);
        return tempList;
    }
}
