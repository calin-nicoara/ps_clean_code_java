package ro.nci.cleancodejava.clean;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YatzyCleanTest {

    @Test
    public void testOnes() {
        assertEquals(1, new YatzyClean(1, 2, 3, 4, 5).ones());
        assertEquals(2, new YatzyClean(1, 2, 1, 4, 5).ones());
        assertEquals(0, new YatzyClean(6, 2, 2, 4, 5).ones());
        assertEquals(4, new YatzyClean(1, 2, 1, 1, 1).ones());
    }

    @Test
    public void testTwos() {
        assertEquals(4, new YatzyClean(1, 2, 3, 2, 6).twos());
        assertEquals(10, new YatzyClean(2, 2, 2, 2, 2).twos());
    }

    @Test
    public void testThrees() {
        assertEquals(6, new YatzyClean(1, 2, 3, 2, 3).threes());
        assertEquals(12, new YatzyClean(2, 3, 3, 3, 3).threes());
    }

    @Test
    public void testFours() {
        assertEquals(12, new YatzyClean(4, 4, 4, 5, 5).fours());
        assertEquals(8, new YatzyClean(4, 4, 5, 5, 5).fours());
        assertEquals(4, new YatzyClean(4, 5, 5, 5, 5).fours());
    }

    @Test
    public void testFives() {
        assertEquals(10, new YatzyClean(4, 4, 4, 5, 5).fives());
        assertEquals(15, new YatzyClean(4, 4, 5, 5, 5).fives());
        assertEquals(20, new YatzyClean(4, 5, 5, 5, 5).fives());
    }

    @Test
    public void testSixes() {
        assertEquals(0, new YatzyClean(4, 4, 4, 5, 5).sixes());
        assertEquals(6, new YatzyClean(4, 4, 6, 5, 5).sixes());
        assertEquals(18, new YatzyClean(6, 5, 6, 6, 5).sixes());
    }

    @Test
    public void testOnePair() {
        assertEquals(6, new YatzyClean(3, 4, 3, 5, 6).getOnePairScore());
        assertEquals(10, new YatzyClean(5, 3, 3, 3, 5).getOnePairScore());
        assertEquals(12, new YatzyClean(5, 3, 6, 6, 5).getOnePairScore());
    }

    @Test
    public void testTwoPairs() {
        assertEquals(16, new YatzyClean(3, 3, 5, 4, 5).getTwoPairsScore());
        assertEquals(16, new YatzyClean(3, 3, 5, 5, 5).getTwoPairsScore());
    }

    @Test
    public void testThreeOfAKind() {
        assertEquals(9, new YatzyClean(3, 3, 3, 4, 5).getThreeOfAKindScore());
        assertEquals(15, new YatzyClean(5, 3, 5, 4, 5).getThreeOfAKindScore());
        assertEquals(9, new YatzyClean(3, 3, 3, 3, 5).getThreeOfAKindScore());
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, new YatzyClean(3, 3, 3, 3, 5).getFourOfAKindScore());
        assertEquals(20, new YatzyClean(5, 5, 5, 4, 5).getFourOfAKindScore());
    }

    @Test
    public void smallStraight() {
        assertEquals(15, new YatzyClean(1, 2, 3, 4, 5).smallStraight());
        assertEquals(15, new YatzyClean(2, 3, 4, 5, 1).smallStraight());
        assertEquals(0, new YatzyClean(1, 2, 2, 4, 5).smallStraight());
    }

    @Test
    public void largeStraight() {
        assertEquals(20, new YatzyClean(6, 2, 3, 4, 5).largeStraight());
        assertEquals(20, new YatzyClean(2, 3, 4, 5, 6).largeStraight());
        assertEquals(0, new YatzyClean(1, 2, 2, 4, 5).largeStraight());
    }

    @Test
    public void fullHouse() {
        assertEquals(18, new YatzyClean(6, 2, 2, 2, 6).fullHouse());
        assertEquals(0, new YatzyClean(2, 3, 4, 5, 6).fullHouse());
    }

    @Test
    public void chanceSumOfAllDice() {
        assertEquals(15, new YatzyClean(2, 3, 4, 5, 1).chance());
        assertEquals(16, new YatzyClean(3, 3, 4, 5, 1).chance());
    }

    @Test
    public void yatzy() {
        assertEquals(50, new YatzyClean(4, 4, 4, 4, 4).yatzy());
        assertEquals(50, new YatzyClean(6, 6, 6, 6, 6).yatzy());
        assertEquals(0, new YatzyClean(6, 6, 6, 6, 3).yatzy());
    }
}