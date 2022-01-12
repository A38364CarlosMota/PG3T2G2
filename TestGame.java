package T2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGame {
    @Test
    public void testBasicTeam() {
        TeamUtils.BasicTeam bt = new TeamUtils.BasicTeam( "Benfica", 3);
        assertEquals("Benfica", bt.getName());
        assertEquals(3, bt.getPoints());
    }

    @Test
    public void testGameWin() {
        TeamUtils.Game g = new TeamUtils.Game("Benfica - Porto  1");
        assertEquals("Benfica", g.visited.getName());
        assertEquals(3, g.visited.getPoints());
        assertEquals("Porto", g.visitor.getName());
        assertEquals(0, g.visitor.getPoints());
        assertEquals('1', g.getResult());
    }

    @Test
    public void testGameLost() {
        TeamUtils.Game g = new TeamUtils.Game("Sporting - Benfica  2");
        assertEquals("Sporting", g.visited.getName());
        assertEquals(0, g.visited.getPoints());
        assertEquals("Benfica", g.visitor.getName());
        assertEquals(3, g.visitor.getPoints());
        assertEquals('2', g.getResult());
    }

    @Test
    public void testGameTied() {
        TeamUtils.Game g = new TeamUtils.Game("Sporting - Porto  X");
        assertEquals("Sporting", g.visited.getName());
        assertEquals(1, g.visited.getPoints());
        assertEquals("Porto", g.visitor.getName());
        assertEquals(1, g.visitor.getPoints());
        assertEquals('X', g.getResult());
    }

}
