package com.nhlstenden.exam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;

public class MatchTest {
    private Team teamA;
    private Team teamB;
    private Match match;
    private Player playerA1;
    private Player playerB1;

    @BeforeEach
    void setUp() {
        HashSet<Player> playersA = new HashSet<>();
        playerA1 = new Player("Lionel Messi", 10);
        playersA.add(playerA1);
        playersA.add(new Player("Cristiano Ronaldo", 7));

        HashSet<Player> playersB = new HashSet<>();
        playerB1 = new Player("Erling Haaland", 19);
        playersB.add(playerB1);
        playersB.add(new Player("Luka Modrić", 14));

        teamA = new Team(playersA, "Hawks");
        teamB = new Team(playersB, "Mavericks");
        match = new Match(teamA, teamB, new HashSet<>());
    }

    @Test
    void getTeamA_afterInitialization_returnsCorrectTeam() {
        assertEquals(teamA, match.getTeamA());
    }

    @Test
    void setTeamA_whenChangingTeam_teamIsUpdated() {
        Team newTeam = new Team(new HashSet<>(), "New Team");
        match.setTeamA(newTeam);
        assertEquals(newTeam, match.getTeamA());
    }

    @Test
    void getTeamB_afterInitialization_returnsCorrectTeam() {
        assertEquals(teamB, match.getTeamB());
    }

    @Test
    void setTeamB_whenChangingTeam_teamIsUpdated() {
        Team newTeam = new Team(new HashSet<>(), "New Team");
        match.setTeamB(newTeam);
        assertEquals(newTeam, match.getTeamB());
    }

    @Test
    void scorePoint_whenTeamAScores_pointIsAdded() {
        match.scorePoint(Teams.teamA, 10);
        assertEquals(1, match.getPoints().size());
    }

    @Test
    void scorePoint_whenTeamBScores_pointIsAdded() {
        match.scorePoint(Teams.teamB, 19);
        assertEquals(1, match.getPoints().size());
    }

    @Test
    void countPoints_whenTeamHasPoints_returnsCorrectCount() {
        match.scorePoint(Teams.teamA, 10);
        match.scorePoint(Teams.teamA, 7);
        match.scorePoint(Teams.teamB, 19);

        assertEquals(2, match.countPoints(teamA));
        assertEquals(1, match.countPoints(teamB));
    }

    @Test
    void getWinner_whenScoreIsBelowMinimum_returnsNull() {
        match.scorePoint(Teams.teamA, 10);
        assertNull(match.getWinner());
    }

    @Test
    void getWinner_whenTeamAWins_returnsTeamA() {
        for (int i = 0; i < 25; i++) {
            match.scorePoint(Teams.teamA, 10);
        }
        for (int i = 0; i < 20; i++) {
            match.scorePoint(Teams.teamB, 19);
        }
        assertEquals(teamA, match.getWinner());
    }

    @Test
    void getWinner_whenTeamBWins_returnsTeamB() {
        for (int i = 0; i < 20; i++) {
            match.scorePoint(Teams.teamA, 10);
        }
        for (int i = 0; i < 25; i++) {
            match.scorePoint(Teams.teamB, 19);
        }

        assertEquals(teamB, match.getWinner());
    }

    @Test
    void retrieveInformation_whenMatchIsUnresolved_showsUnresolvedWinner() {
        match.scorePoint(Teams.teamA, 10);
        String info = match.retrieveInformation();
        assertTrue(info.contains("\"winner\": \"Unresolved\""));
    }

    @Test
    void retrieveInformation_whenTeamAWins_showsTeamAAsWinner() {
        for (int i = 0; i < 25; i++) {
            match.scorePoint(Teams.teamA, 10);
        }
        for (int i = 0; i < 20; i++) {
            match.scorePoint(Teams.teamB, 19);
        }

        String info = match.retrieveInformation();
        assertTrue(info.contains("\"winner\": \"Hawks\""));
        assertTrue(info.contains("\"loser\": \"Mavericks\""));
    }
}