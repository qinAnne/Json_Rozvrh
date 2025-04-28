package cz.uhk.jsonrozvrh.network;

import com.google.gson.*;
import cz.uhk.jsonrozvrh.model.Akce;
import java.net.URL;
import java.util.Scanner;

public class StagDataLoader {
    private static String BASE_URL = "https://stag-demo.uhk.cz/ws/services/rest2/rozvrhy/getRozvrhByMistnost?semestr=ZS&budova=%s&mistnost=%s&outputFormat=JSON";

    public static Akce loadSchedule(String budova, String mistnost) {
        Akce schedule = new Akce();
        try {
            String urlStr = String.format(BASE_URL, budova, mistnost);
            URL url = new URL(urlStr);
            String out = new Scanner(url.openStream(), "UTF-8").useDelimiter("\\A").next();
            schedule = new Gson().fromJson(out, Akce.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return schedule;
    }
}
