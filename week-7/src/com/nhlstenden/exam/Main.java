package com.nhlstenden.exam;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Player> hawksPlayers = new HashSet<>();
        HashSet<Player> mavericksPlayers = new HashSet<>();
        HashSet<Player> titansPlayers = new HashSet<>();
        HashSet<Player> warriorsPlayers = new HashSet<>();

        hawksPlayers.add(new Player("Lionel Messi", 10));
        hawksPlayers.add(new Player("Cristiano Ronaldo", 7));
        hawksPlayers.add(new Player("Neymar Jr.", 11));
        hawksPlayers.add(new Player("Kylian Mbappé", 12));
        hawksPlayers.add(new Player("Kevin De Bruyne", 17));
        hawksPlayers.add(new Player("Robert Lewandowski", 9));

        mavericksPlayers.add(new Player("Erling Haaland", 19));
        mavericksPlayers.add(new Player("Luka Modrić", 14));
        mavericksPlayers.add(new Player("Virgil van Dijk", 4));
        mavericksPlayers.add(new Player("Mohamed Salah", 15));
        mavericksPlayers.add(new Player("Karim Benzema", 22));
        mavericksPlayers.add(new Player("Bruno Fernandes", 8));

        titansPlayers.add(new Player("Zlatan Ibrahimović", 21));
        titansPlayers.add(new Player("Gareth Bale", 3));
        titansPlayers.add(new Player("Sergio Ramos", 5));
        titansPlayers.add(new Player("Toni Kroos", 8));
        titansPlayers.add(new Player("Paul Pogba", 6));
        titansPlayers.add(new Player("Antoine Griezmann", 7));

        warriorsPlayers.add(new Player("Andres Iniesta", 10));
        warriorsPlayers.add(new Player("Xavi Hernandez", 6));
        warriorsPlayers.add(new Player("Gerard Piqué", 3));
        warriorsPlayers.add(new Player("David Villa", 7));
        warriorsPlayers.add(new Player("Wayne Rooney", 9));
        warriorsPlayers.add(new Player("Frank Lampard", 8));

        Team hawks = new Team(hawksPlayers, "Hawks");
        Team mavericks = new Team(mavericksPlayers, "Mavericks");
        Team titans = new Team(titansPlayers, "Titans");
        Team warriors = new Team(warriorsPlayers, "Warriors");

        HashSet<Match> matches = new HashSet<>();
        matches.add(new Match(hawks, mavericks, new HashSet<>()));
        matches.add(new Match(titans, warriors, new HashSet<>()));
        matches.add(new Match(hawks, warriors, new HashSet<>()));
        matches.add(new Match(mavericks, titans, new HashSet<>()));

        Tournament tournament = new Tournament(matches);

        for (Match match : matches) {
            Player[] teamAPlayers = match.getTeamA().getPlayers().toArray(new Player[0]);
            Player[] teamBPlayers = match.getTeamB().getPlayers().toArray(new Player[0]);

            if (Math.random() > 0.5) {
                int teamAPoints = 25 + (int) (Math.random() * 6);
                for (int i = 0; i < teamAPoints; i++) {
                    Player scorer = teamAPlayers[(int) (Math.random() * teamAPlayers.length)];
                    match.scorePoint(Teams.teamA, scorer.getJerseyNumber());
                }

                int teamBPoints = (int) (Math.random() * 23);
                for (int i = 0; i < teamBPoints; i++) {
                    Player scorer = teamBPlayers[(int) (Math.random() * teamBPlayers.length)];
                    match.scorePoint(Teams.teamB, scorer.getJerseyNumber());
                }
            } else {
                int teamBPoints = 25 + (int) (Math.random() * 6);
                for (int i = 0; i < teamBPoints; i++) {
                    Player scorer = teamBPlayers[(int) (Math.random() * teamBPlayers.length)];
                    match.scorePoint(Teams.teamB, scorer.getJerseyNumber());
                }

                int teamAPoints = (int) (Math.random() * 23);
                for (int i = 0; i < teamAPoints; i++) {
                    Player scorer = teamAPlayers[(int) (Math.random() * teamAPlayers.length)];
                    match.scorePoint(Teams.teamA, scorer.getJerseyNumber());
                }
            }
        }

        System.out.println(tournament.getWinnerOfTournament());
    }
}
