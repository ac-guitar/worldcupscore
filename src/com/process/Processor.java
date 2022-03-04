package com.process;

import com.obj.Match;
import com.obj.TeamScore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Processor {

    Collection<Match> matches;
    Match currentMatch;
    int matchCode = 0;
    boolean matchStatus = false;

    public void init(){

        matches = new ArrayList<>();

        String homeTeam;
        String awayTeam;
        int choice;
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        while(true) {

            //create menu
            System.out.println("### World Cup Score ###");
            System.out.println("Press 1 to start a game");
            System.out.println("Press 2 to finish a game");
            System.out.println("Press 3 to update a game score");
            System.out.println("Press 4 to get a summary");
            System.out.println("Press 5 to quit\n \n ");

            System.out.println("Select your option:");
            choice = scanner.nextInt();

            switch (choice) {

                // Start a game
                case 1:

                    if(matchCode == 5){
                        System.out.println("You can't add more matches. \n");
                    }
                    else if(matchStatus){
                        System.out.println("You have to finish the current match. \n");
                    }
                    else{
                        System.out.println("Enter the first team ");
                        homeTeam = scanner.next();
                        System.out.println("Enter the second team");
                        awayTeam = scanner.next();
                        createMatch(homeTeam, awayTeam);
                    }

                    break;

                // Finish a game
                case 2:
                    if(!matchStatus){
                        System.out.println("First start a game. \n");
                    }
                    else{
                        finishMatch();
                    }
                    break;

                // Update score
                case 3:

                    if(!matchStatus){
                        System.out.println("First start a game. \n");
                    }
                    else{
                        System.out.println("Enter the Home team score.");
                        int homeScore = scanner.nextInt();
                        System.out.println("Enter the Away team score");
                        int awayScore = scanner.nextInt();
                        updateMatch(homeScore, awayScore);
                        System.out.println("Current match: \n");
                        showCurrentMatch(currentMatch);
                    }
                    break;

                // Summary
                case 4:

                    if(!matches.isEmpty()){
                        System.out.println("Cup summary \n");
                        for(Match match : matches){
                            showCurrentMatch(match);
                            System.out.println("\n");
                        }
                    }
                    else{
                        System.out.println("There are no matches. Please start a game. \n");
                    }

                    break;

                // Quit
                case 5:
                    System.exit(0);
                    // invalid option
                default:
                    System.out.println("Invalid option. Select an option from 1 to 5. \\n\\n");
            }
        }

    }

    public void createMatch(String homeTeam, String awayTeam){
        currentMatch = new Match();
        TeamScore homeTeamScore = new TeamScore();
        homeTeamScore.setTeamName(homeTeam);
        homeTeamScore.setScore(0);
        TeamScore awayTeamScore = new TeamScore();
        awayTeamScore.setTeamName(awayTeam);
        awayTeamScore.setScore(0);
        currentMatch.setMatchCode(matchCode++);
        currentMatch.setHomeTeam(homeTeamScore);
        currentMatch.setAwayTeam(awayTeamScore);
        matchStatus = true;
    }

    public void updateMatch(int homeScore, int awayScore){
        currentMatch.getAwayTeam().setScore(homeScore);
        currentMatch.getHomeTeam().setScore(awayScore);
    }

    public void finishMatch(){
        matchStatus = false;
        matches.add(currentMatch);
        System.out.println("Match finished. \n");
    }

    public void showCurrentMatch(Match currentMatch){
        System.out.println(currentMatch.getHomeTeam().getTeamName() + " " + currentMatch.getHomeTeam().getScore()  + " - " +
                currentMatch.getAwayTeam().getTeamName() + " " + currentMatch.getAwayTeam().getScore());
    }

}
