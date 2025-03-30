package com.nhlstenden.exam;

import java.time.LocalDateTime;
import java.util.HashSet;

public class Match {
    private Team teamA;
    private Team teamB;
    private HashSet<Point> points;

    public Match(Team teamA, Team teamB, HashSet<Point> points) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.points = points;
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public HashSet<Point> getPoints() {
        return points;
    }

    public void setPoints(HashSet<Point> points) {
        this.points = points;
    }

    public void scorePoint(Teams team, int jerseyNumber) {
        if (team == Teams.teamA) {
            for (Player player : teamA.getPlayers()) {
                if (player.getJerseyNumber() == jerseyNumber) {
                    points.add(new Point(player, LocalDateTime.now()));
                }
            }
        } else {
            for (Player player : teamB.getPlayers()) {
                if (player.getJerseyNumber() == jerseyNumber) {
                    points.add(new Point(player, LocalDateTime.now()));
                }
            }
        }
    }

    public int countPoints(Team team) {
        int pointsCount = 0;
        for (Point point : points) {
            for (Player player : team.getPlayers()) {
                if (point.getPlayer().getId().equals(player.getId())) {
                    pointsCount++;
                }
            }
        }
        return pointsCount;
    }

    public Team getWinner() {
        int teamAPoints = this.countPoints(teamA);
        int teamBPoints = this.countPoints(teamB);

        if ((teamAPoints < 25 && teamBPoints < 25) || (Math.abs(teamAPoints - teamBPoints) < 2)) {
            return null;
        } else if (teamAPoints > teamBPoints) {
            return teamA;
        } else {
            return teamB;
        }
    }

    public String retrieveInformation() {
        int teamAPoints = this.countPoints(teamA);
        int teamBPoints = this.countPoints(teamB);
        String winner = "";
        String loser = "";

        if ((teamAPoints < 25 && teamBPoints < 25) || (Math.abs(teamAPoints - teamBPoints) < 2)) {
            winner = "Unresolved";
            loser = "Unresolved";
        } else if (teamAPoints > teamBPoints) {
            winner = teamA.getName();
            loser = teamB.getName();
        } else {
            winner = teamB.getName();
            loser = teamA.getName();
        }
        return "{\n" +
                "\"" + "winner\": " + "\"" + winner + "\"," + "\n" +
                "\"" + "loser\": " + "\"" + loser + "\"," + "\n" +
                "\"" + teamA.getName() + "\": " + "\"" + teamAPoints + "\"," + "\n" +
                "\"" + teamB.getName() + "\": " + "\"" + teamBPoints + "\"," + "\n" +
                "\"" + "Point difference\": " + "\"" + Math.abs(teamAPoints - teamBPoints) + "\"" + "\n" +
                "}";
    }
}
