package Models;

import lombok.AccessLevel;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;


@Table(name = "team")
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;
 // dopisac name unice
    private String name;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Player> playerList;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany( mappedBy = "team")
    private List<Game> game;

    @Setter(AccessLevel.NONE)
    private Long totalScore;

    public Team() {
    }

    public Team(String name, List<Player> playerList, List<Game> game, Long totalScore) {
        this.name = name;
        this.playerList = playerList;
        this.game = game;
        this.totalScore = totalScore;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Game> getGame() {
        return game;
    }

    public void setGame(List<Game> game) {
        this.game = game;
    }

    public Long getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Long totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", name='" + name + '\'' +
                ", playerList=" + playerList +
                ", game=" + game +
                ", totalScore=" + totalScore +
                '}';
    }
}
