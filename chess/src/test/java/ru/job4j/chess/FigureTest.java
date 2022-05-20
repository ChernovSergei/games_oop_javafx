package ru.job4j.chess;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;

import org.junit.Test;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.Cell;

public class FigureTest {
    public FigureTest(){}

    @Test
    public void bishopBlackPositionA1() {
        Figure bishopBlack = new BishopBlack(Cell.A1);
        Cell position = bishopBlack.position();
        assertThat(position, is(Cell.A1));
    }

    @Test
    public void bishopBlackPositionCopy() {
        Cell position = Cell.B3;
        Figure bishopBlack = new BishopBlack(position);
        Figure copy = bishopBlack.copy(position);
        assertThat(copy, samePropertyValuesAs(bishopBlack));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenInvalidWay() {
        Cell currentPosition = Cell.A2;
        Cell wrongPosition = Cell.E2;
        BishopBlack bBlack = new BishopBlack(currentPosition);
        bBlack.way(wrongPosition);
    }
}
