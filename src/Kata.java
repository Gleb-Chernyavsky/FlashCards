import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.*;


public class Kata {
    public static void main(String[] args) {
        Map<String, String> sr = new LinkedHashMap<>();
        sr.put("benzin", "oil");
        sr.put("benzin", "oilianists");
        sr.put("Moscow", "hachi");
        sr.put("Russia", "Moscow");
        List<String> list = new ArrayList<>();
        for (Map.Entry entry : sr.entrySet()) {
            list.add(entry.getKey().toString());
        }
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

    }
}