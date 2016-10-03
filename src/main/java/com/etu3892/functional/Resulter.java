package com.etu3892.functional;


import com.etu3892.db.mysql.MySQLCompetDAO;
import com.etu3892.db.entities.Competition;
import com.etu3892.db.entities.Match;
import com.etu3892.db.entities.Predict;
import com.etu3892.db.entities.TeamPart;
import com.etu3892.db.mysql.MySQLMatchDAO;
import com.etu3892.db.mysql.MySQLPredictDAO;
import com.etu3892.db.mysql.MySQLTeamPartDAO;

import java.sql.SQLException;
import java.util.List;

public class Resulter {
    public static void ComputeResult(Match match) throws SQLException {
        int h = match.getHomeGls(), a = match.getAwayGls();
        TeamPart home = MySQLTeamPartDAO.getByTeamIdAndLeagueId(match.getHome().getTeamId(),match.getLeague().getLeagueId());
        TeamPart away = MySQLTeamPartDAO.getByTeamIdAndLeagueId(match.getAway().getTeamId(),match.getLeague().getLeagueId());
        home.setPld(home.getPld()+1); home.setGc(home.getGc()+a); home.setGs(home.getGs()+h);
        away.setPld(away.getPld()+1); away.setGc(away.getGc()+h); away.setGs(away.getGs()+a);
        if (h>a) home.setPts(home.getPts()+3);
        else if (h<a) away.setPts(away.getPts()+3);
        else {
            home.setPts(home.getPts()+1);
            away.setPts(away.getPts()+1);
        }
        MySQLTeamPartDAO.updateRoster(home);
        MySQLTeamPartDAO.updateRoster(away);
    }

    public static void ComputePredict(Predict predict, Match match) throws SQLException {
        int prH = predict.getHomePr(), prA = predict.getAwayPr(), mH = match.getHomeGls(), mA = match.getAwayGls();
        Competition competition = MySQLCompetDAO.findByUserAndLeague(predict.getUser(),match.getLeague());
        if (competition==null) competition = new Competition(0,match.getLeague(),predict.getUser(),0,0);
        int prAdv = prH - prA, mAdv = mH - mA;
        if (prA==mA && prH==mH) {
            competition.setPoints(competition.getPoints()+5);
            competition.setScores(competition.getScores()+1);
            predict.setPoints(5);
        } else if (prAdv==mAdv) {
            competition.setPoints(competition.getPoints()+3);
            predict.setPoints(3);
        } else if ((prAdv>0 && mAdv>0)||(prAdv<0 && mAdv<0)){
            if (prH==mH || prA == mA) {
                competition.setPoints(competition.getPoints() + 2);
                predict.setPoints(2);
            }
            else {
                competition.setPoints(competition.getPoints()+1);
                predict.setPoints(1);
            }
        } else predict.setPoints(0);
        MySQLPredictDAO.updatePts(predict);
        MySQLCompetDAO.update(competition);
    }


}
