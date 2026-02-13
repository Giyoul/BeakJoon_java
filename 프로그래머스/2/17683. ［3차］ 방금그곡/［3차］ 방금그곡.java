import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String target = replaceSharp(m);

        return Arrays.stream(musicinfos)
                .map(info -> info.split(","))
                .map(details -> new Object() {
                    int playTime = calculateMinutes(details[1]) - calculateMinutes(details[0]);
                    String title = details[2];
                    String melody = replaceSharp(details[3]);
                    String fullMelody = IntStream.range(0, playTime)
                            .mapToObj(i -> String.valueOf(melody.charAt(i % melody.length())))
                            .reduce("", String::concat);
                })
                .filter(obj -> obj.fullMelody.contains(target))
                .sorted((a, b) -> Integer.compare(b.playTime, a.playTime))
                .map(obj -> obj.title)
                .findFirst()
                .orElse("(None)");
    }

    private String replaceSharp(String s) {
        return s.replace("C#", "c").replace("D#", "d").replace("F#", "f")
                .replace("G#", "g").replace("A#", "a").replace("B#", "b");
    }

    private int calculateMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}