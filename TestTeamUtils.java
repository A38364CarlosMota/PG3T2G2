package T2;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static T2.TeamUtils.loadFrom;
import static T2.TeamUtils.processTable;

public class TestTeamUtils {
    private final static String GAMES_TEST = "Benfica - Porto 1\nSporting - Benfica 2\nSporting - Porto X\n";

    @Test
    public void testLoadFrom() throws IOException {
        Map<String, TeamUtils.Team> teams = new TreeMap<>();
        loadFrom(teams, new BufferedReader( new StringReader(GAMES_TEST) ));
        assertEquals(3, teams.size());
        String expectedKeys = "[Benfica, Porto, Sporting]";
        assertEquals(expectedKeys, teams.keySet().toString());
        String expectedValues = "[\"Benfica\", 6 pontos em 2 jogos, \"Porto\", 1 ponto em 2 jogos, \"Sporting\", 1 ponto em 2 jogos]";
        assertEquals(expectedValues, teams.values().toString());
    }

    @Test
    public void testToTable() throws IOException {
        Map<String, TeamUtils.Team> teams = new TreeMap<>();
        loadFrom(teams, new BufferedReader( new StringReader(GAMES_TEST)) );
        SortedMap<Integer, TreeSet<String>> table =
                TeamUtils.toTable( teams, Integer::compareTo, TreeSet::new);
        assertEquals(2, table.size());
        String expectedKeys = "[1, 6]";
        assertEquals(expectedKeys, table.keySet().toString());
        String expectedValues = "[[Porto, Sporting], [Benfica]]";
        assertEquals(expectedValues, table.values().toString());
    }

    @Test
    public void testProcessTable() throws IOException {
        Map<String, TeamUtils.Team> teams = new TreeMap<>();
        loadFrom(teams, new BufferedReader( new StringReader(GAMES_TEST)));
        SortedMap<Integer, TreeSet<String>> table =
                TeamUtils.toTable( teams, Integer::compareTo, TreeSet::new);
        StringBuilder result = new StringBuilder();
        processTable(table, (points, teamName) -> result.append(points + " - " + teamName+"; "));
        String expectedValues = "1 - Porto; 1 - Sporting; 6 - Benfica; ";
        assertEquals(expectedValues, result.toString());
    }
}
