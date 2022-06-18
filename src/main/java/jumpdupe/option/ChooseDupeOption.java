package main.java.jumpdupe.option;

public class ChooseDupeOption {

    public void JumputiDupeSingle (int multiplier){
        DupeJumputiSingle[] dupeJumputiSingles = new DupeJumputiSingle[multiplier];
        for(int i = 0;i<multiplier;i++) dupeJumputiSingles[i] = new DupeJumputiSingle();
        for(int i = 0;i<multiplier;i++) dupeJumputiSingles[i].start();
    }

    public void JumputiDupeAll (int multiplier){
        DupeJumputiAll[] dupeJumputiAlls = new DupeJumputiAll[multiplier];
        for(int i = 0;i<multiplier;i++) dupeJumputiAlls[i] = new DupeJumputiAll();
        for(int i = 0;i<multiplier;i++) dupeJumputiAlls[i].start();
    }

    public void JumputiDupeMissions (int multiplier){
        DupeJumputiMission[] dupeJumputiMissions = new DupeJumputiMission[multiplier];
        for(int i = 0;i<multiplier;i++) dupeJumputiMissions[i] = new DupeJumputiMission();
        for(int i = 0;i<multiplier;i++) dupeJumputiMissions[i].start();
    }

}
