package ru.netology;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result;

        source.stream().forEach(x -> {
            if (x <= treshold) {
                logger.log("Элемент " + x + " не проходит");
            } else {
                logger.log("Элемент " + x + " проходит");
            }
        });
        result = source.stream().filter(r -> r > treshold).collect(Collectors.toList());
        return result;
    }
}