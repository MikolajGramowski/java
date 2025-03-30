package com.nhlstenden.exam;

import java.util.HashMap;
import java.util.HashSet;

public class Tournament {
    private HashSet<Match> matches;

    public Tournament(HashSet<Match> matches) {
        this.matches = matches;
    }

    public HashSet<Match> getMatches() {
        return matches;
    }

    public void setMatches(HashSet<Match> matches) {
        this.matches = matches;
    }

    public String getWinnerOfTournament() {
        HashMap<Team, Integer> teamWins = new HashMap<>();

        for (Match match : matches) {
            Team winner = match.getWinner();
            if (winner == null) {
                continue;
            }

            teamWins.put(winner, teamWins.getOrDefault(winner, 0) + 1);
        }

        Team tournamentWinner = null;
        int maxWins = 0;

        for (Team team : teamWins.keySet()) {
            int wins = teamWins.get(team);
            if (wins > maxWins) {
                maxWins = wins;
                tournamentWinner = team;
            }
        }

        assert tournamentWinner != null;
        return tournamentWinner.getName();
    }
}
