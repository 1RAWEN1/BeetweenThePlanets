import greenfoot.Actor;

public class Splash extends Actor {
    int damage;
    int radius;
    int teamNum;

    public Splash(int damage, int radius, int teamNum){
        this.damage = damage;
        this.radius = radius;
        this.teamNum = teamNum;
    }

    public void act(){
        for(Structures st : getIntersectingObjects(Structures.class)){
            if(st.teamNum != teamNum)
            st.damage(damage);
        }

        for(Unit u : getIntersectingObjects(Unit.class)){
            if(u.teamNum != teamNum)
                u.damage(damage);
        }
    }
}
