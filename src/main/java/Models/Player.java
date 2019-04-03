package Models;

import javax.persistence.*;

@Table(name = "player")
@Entity

public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playerId")
    private Long playerId;
// unice combination of id and name
    @Column(name = "firstName")
    private String firstName;

    @Column(name = "surName")
    private String surName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "experience")
    // default value = 0;
    private Integer experience;

    @Column(name = "isInjured")
    private Boolean isInjured;

    @ManyToOne
    @JoinColumn(name = "teamId")
    private Team team;

    public Player() {
    }

    public Player(String firstName, String surName, Integer age, Integer experience,
                  Boolean isInjured, Team team) {
        this.firstName = firstName;
        this.surName = surName;
        this.age = age;
        this.experience = experience;
        this.isInjured = isInjured;
        this.team = team;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Boolean getInjured() {
        return isInjured;
    }

    public void setInjured(Boolean injured) {
        isInjured = injured;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                '}';
    }
}
