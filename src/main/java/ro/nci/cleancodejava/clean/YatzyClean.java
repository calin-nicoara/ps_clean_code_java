package ro.nci.cleancodejava.clean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class YatzyClean {

    private final List<Integer> dice;

    public YatzyClean(Integer... dices)
    {
        dice = Arrays.asList(dices);
    }

    public int ones() {
        return getSumOfSameKind(1);
    }

    public int twos() {
        return getSumOfSameKind(2);
    }

    public int threes() {
        return getSumOfSameKind(3);
    }

    public int fours()
    {
        return getSumOfSameKind(4);
    }

    public int fives()
    {
        return getSumOfSameKind(5);
    }

    public int sixes()
    {
        return getSumOfSameKind(6);
    }

    private int getSumOfSameKind(final int rollNumber) {
        return (int) dice.stream().filter(number -> number == rollNumber).count() * rollNumber;
    }

    public int getOnePairScore()
    {
        return getIntStreamWithNumberOfRollsSums(2).max().orElse(0);
    }

    public int getTwoPairsScore()
    {
        return getIntStreamWithNumberOfRollsSums(2).sum();
    }

    public int getThreeOfAKindScore()
    {
        return getIntStreamWithNumberOfRollsSums(3).sum();
    }

    public int getFourOfAKindScore()
    {
        return getIntStreamWithNumberOfRollsSums(4).sum();
    }

    private IntStream getIntStreamWithNumberOfRollsSums(final int numberOfRolls) {
        Map<Integer, Long> pairScoreMap = getPairScoreMap();
        return pairScoreMap.entrySet().stream().filter(entrySet -> entrySet.getValue() >= numberOfRolls)
                .mapToInt(integerLongEntry -> integerLongEntry.getKey() * numberOfRolls);
    }

    public int smallStraight()
    {
        Map<Integer, Long> pairScoreMap = getPairScoreMap();
        boolean isSmallStraight = IntStream.rangeClosed(1, 5).anyMatch(roll -> pairScoreMap.getOrDefault(roll, 0L) == 0);
        return isSmallStraight ? 0 : 15;
    }

    public int largeStraight()
    {
        Map<Integer, Long> pairScoreMap = getPairScoreMap();
        boolean isSmallStraight = IntStream.rangeClosed(2, 6).anyMatch(roll -> pairScoreMap.getOrDefault(roll, 0L) == 0);
        return isSmallStraight ? 0 : 20;
    }

    public int fullHouse()
    {
        Map<Integer, Long> pairScoreMap = getPairScoreMap();

        Optional<Map.Entry<Integer, Long>> pairEntry = pairScoreMap.entrySet().stream()
                .filter(entrySet -> entrySet.getValue() == 2L)
                .findAny();
        Optional<Map.Entry<Integer, Long>> threeOfAKind = pairScoreMap.entrySet().stream()
                .filter(entrySet -> entrySet.getValue() == 3L)
                .findAny();

        if(pairEntry.isPresent() && threeOfAKind.isPresent()) {
            return pairEntry.get().getKey() * 2 + threeOfAKind.get().getKey() * 3;
        } else {
            return 0;
        }
    }

    public int chance()
    {
        return dice.stream().mapToInt(i -> i).sum();
    }

    public int yatzy()
    {
        boolean isYatzy = getPairScoreMap().entrySet().stream()
                .anyMatch(entrySet -> entrySet.getValue() == 5L);
        return isYatzy ? 50 : 0;
    }

    private Map<Integer, Long> getPairScoreMap() {
        return dice.stream()
                .collect(Collectors.groupingBy(number -> number, Collectors.counting()));
    }
}



