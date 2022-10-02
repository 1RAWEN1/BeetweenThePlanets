import greenfoot.Actor;

public class Bullet extends Actor {
    int speed;

    int damage;

    int teamNum;

    boolean splash;

    boolean homing;

    int radius;

    public Bullet(int speed, int damage, int teamNum){
        this.speed = speed;
        this.damage = damage;
        this.teamNum = teamNum;
    }

    public Bullet(int speed, int damage, boolean homing, int teamNum){
        this.speed = speed;
        this.damage = damage;
        this.homing = homing;
        this.teamNum = teamNum;
    }

    public Bullet(int speed, int damage, boolean splash, int radius, boolean homing, int teamNum, double x, double y){
        this.speed = speed;
        this.damage = damage;
        this.splash = splash;
        this.radius = radius;
        this.homing = homing;
        this.teamNum = teamNum;
        this.x = x;
        this.y = y;
    }

    int range = 100;
    int dRot = 2;
    int rot;
    int rotToTarget;

    Structures target2;
    int minDistance;

    Unit target1;

    Actor target;

    double x;
    double y;
    public void act(){
        move();

        if(homing){
            target = null;
            target1 = null;
            target2 = null;
            minDistance = 100;
            for(Structures s : getObjectsInRange(range, Structures.class)){
                if(s.teamNum != teamNum && Math.sqrt(Math.pow(getX() - s.getX(), 2) + Math.pow(getY() - s.getY(), 2)) < minDistance){
                    target2 = s;
                    minDistance = (int)Math.sqrt(Math.pow(getX() - s.getX(), 2) + Math.pow(getY() - s.getY(), 2));
                }
            }

            for(Unit u : getObjectsInRange(range, Unit.class)){
                if(u.teamNum != teamNum && Math.sqrt(Math.pow(getX() - u.getX(), 2) + Math.pow(getY() - u.getY(), 2)) < minDistance){
                    target1 = u;
                    target2 = null;
                    minDistance = (int)Math.sqrt(Math.pow(getX() - u.getX(), 2) + Math.pow(getY() - u.getY(), 2));
                }
            }

            rot = getRotation();
            target = target1 != null ? target1 : target2;
            turnTowards(target.getX(), target.getY());
            rotToTarget = getRotation();
            setRotation(rot);

            if(rotToTarget >= rot || rot - rotToTarget > 180){
                turn(dRot);
            }
            else{
                turn(-dRot);
            }
        }

        damage();
    }

    public void updateLocation(){
        setLocation((getWorld().getWidth() / 2) + (int)x - Player.x, (getWorld().getHeight() / 2) + (int)y - Player.y);
    }

    public void move(){
        x += speed * Math.cos(Math.toRadians(getRotation()));
        y += speed * Math.sin(Math.toRadians(getRotation()));

        if(x < 0){
            x = 0;
        }
        else if(x > MyWorld.x1 * 10){
            x = MyWorld.x1 * 10;
        }
        if(y < 0){
            y = 0;
        }
        else if(y > MyWorld.y1 * 10){
            y = MyWorld.y1 * 10;
        }

        updateLocation();
    }

    public void damage(){
        Structures st = (Structures)getOneIntersectingObject(Structures.class);
        Unit u = (Unit)getOneIntersectingObject(Unit.class);
        if(u != null && u.teamNum != teamNum){
            if(!splash) {
                u.damage(damage);
            }
            else{
                Splash s = new Splash(damage, radius, teamNum);
                getWorld().addObject(s, getX(), getY());
            }
            getWorld().removeObject(this);
        }
        else if(st != null && st.teamNum != teamNum){
            if(!splash) {
                st.damage(damage);
            }
            else{
                Splash s = new Splash(damage, radius, teamNum);
                getWorld().addObject(s, getX(), getY());
            }
            getWorld().removeObject(this);
        }
    }
}
