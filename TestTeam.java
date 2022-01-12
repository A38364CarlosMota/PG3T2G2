package T2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTeam {
    @Test
    public void testTeamConstruct() {
        TeamUtils.Team bt = new TeamUtils.Team( "Benfica");
        assertEquals("Benfica", bt.getName());
        assertEquals(0, bt.getPoints());
        assertEquals(0, bt.playedGames());
        assertEquals("\"Benfica\", 0 pontos em 0 jogos", bt.toString());
    }

    @Test
    public void testTeamAddGame() {
        TeamUtils.Team bt = new TeamUtils.Team( "Benfica");
        bt.addGame( 1 );
        assertEquals(1, bt.getPoints());
        assertEquals(1, bt.playedGames());
        assertEquals("\"Benfica\", 1 ponto num jogo", bt.toString());

        bt.addGame( 3 );
        assertEquals(4, bt.getPoints());
        assertEquals(2, bt.playedGames());
        assertEquals("\"Benfica\", 4 pontos em 2 jogos", bt.toString());
    }
}
