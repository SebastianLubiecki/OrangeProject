package Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Games")
public class Game {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long gameId;

    private String teamHome;

    private String teamAway;

    @ManyToMany
    private List<Team> team;

    @Column(name = "teamHomeScore", nullable = false)
    private Integer teamHomeScore;

    @Column(name = "teamAwayScore", nullable = false)
    private Integer teamAwayScore;

    @Column(name = "isTeamHomeWin", nullable = false)
    private Boolean isTeamHomeWin;

    @Column(name = "isTeamAwayWin", nullable = false)
    private Boolean isTeamAwayWin;



    public Game() {
    }

    public Game(String teamHome, String teamAway, Integer teamHomeScore,
                Integer teamAwayScore, Boolean isTeamHomeWin, Boolean isTeamAwayWin, List<Team> team) {
        this.teamHome = teamHome;
        this.teamAway = teamAway;
        this.teamHomeScore = teamHomeScore;
        this.teamAwayScore = teamAwayScore;
        this.isTeamHomeWin = isTeamHomeWin;
        this.isTeamAwayWin = isTeamAwayWin;
        this.team = team;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getTeamHome() {
        return teamHome;
    }

    public void setTeamHome(String teamHome) {
        this.teamHome = teamHome;
    }

    public String getTeamAway() {
        return teamAway;
    }

    public void setTeamAway(String teamAway) {
        this.teamAway = teamAway;
    }

    public Integer getTeamHomeScore() {
        return teamHomeScore;
    }

    public void setTeamHomeScore(Integer teamHomeScore) {
        this.teamHomeScore = teamHomeScore;
    }

    public Integer getTeamAwayScore() {
        return teamAwayScore;
    }

    public void setTeamAwayScore(Integer teamAwayScore) {
        this.teamAwayScore = teamAwayScore;
    }

    public Boolean getTeamHomeWin() {
        return isTeamHomeWin;
    }

    public void setTeamHomeWine(Boolean teamHomeWin) {
        isTeamHomeWin = teamHomeWin;
    }

    public Boolean getTeamAwayWine() {
        return isTeamAwayWin;
    }

    public void setTeamAwayWine(Boolean teamAwayWin) {
        isTeamAwayWin = teamAwayWin;
    }

    public List<Team> getTeam() {
        return team;
    }

    public void setTeam(List<Team> team) {
        this.team = team;
    }
}
