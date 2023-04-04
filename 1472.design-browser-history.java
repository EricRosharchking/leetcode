import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DesignBrowserHistory {

    public static void main(String[] args) {
        String[] arr = {"BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"};
        Object[][] res = {{"leetcode.com"},{"google.com"},{"facebook.com"},{"youtube.com"},{1},{1},{1},{"linkedin.com"},{2},{2},{7}};
        BrowserHistory bh = new BrowserHistory("");
        String curr = null;
        for (int i = 0; i < arr.length; i++) {
            switch(arr[i]) {
                case "visit":
                    bh.visit((String)res[i][0]);
                    System.out.println("null");
                    break;
                case "back":
                    curr = bh.back((int) res[i][0]);
                    System.out.println(curr);
                    break;
                case "forward":
                    curr = bh.forward((int) res[i][0]);
                    System.out.println(curr);
                    break;
                default:
                    bh = new BrowserHistory((String)res[i][0]);
                    System.out.println("null");
            }

        }
        
    }
}

class BrowserHistory {

    private LinkedList<String> history = new LinkedList<>();
    private int index = 0;

    public BrowserHistory(String homepage) {
        history.add(homepage);
        index++;
    }
    
    public void visit(String url) {
        for (int i = history.size(); i > index; i--)
            history.removeLast();
        history.add(url);
        index ++;
    }
    
    public String back(int steps) {
        index -= steps;
        index = index < 1 ? 1 : index;
        return history.get(index - 1);
    }
    
    public String forward(int steps) {
        index += steps;
        index = index > history.size() ? history.size() : index;
        return history.get(index - 1);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */