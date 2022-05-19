package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

public class LogicTest {

    @Ignore
    @Test(expected = ImpossibleMoveException.class)
    public void invalidMoveC1toH7()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H7);
    }

    @Test(expected = FigureNotFoundException.class)
    public void nonexistentFigureChecker()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C2, Cell.H6);
    }

    @Test(expected = OccupiedCellException.class)
    public void pawnsOnTheWay()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new PawnBlack(Cell.H6));
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }
}