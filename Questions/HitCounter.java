import java.util.HashSet;
import java.util.Set;

public class HitCounter {
    public static void main(String [] args){
        Set<String> st =  new HashSet<>();
        st.add("pavan");
        st.add("vimal");
        st.add("navap");
        for(String key : st){
            System.out.println(key);
        }
    }
}
