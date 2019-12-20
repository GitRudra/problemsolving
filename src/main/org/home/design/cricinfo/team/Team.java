package org.home.design.cricinfo.team;



public class Team {
    private Coach coach;
    private TeamSquad squad;
    private Playing11 playing11;

    public Team() {

    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public TeamSquad getSquad() {
        return squad;
    }

    public void setSquad(TeamSquad squad) {
        this.squad = squad;
    }

    public Playing11 getPlaying11() {
        return playing11;
    }

    public void setPlaying11(Playing11 playing11) {
        this.playing11 = playing11;
    }
}
