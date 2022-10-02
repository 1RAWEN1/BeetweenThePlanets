import greenfoot.Actor;

public class Unit extends Actor {
    int fullHp;
    int hp;
    int teamNum;
    boolean air;

    int speed;
    int rotSpeed;

    int damage;
    boolean splash;
    int radius;
    boolean homing;
    int bulletSpeed;

    Structures target2;
    Unit target1;
    Actor target;
    int minDistance;
    int range;
    int rot;
    int dRot;
    int rotToTarget;

    public void doMainAction(){
        if(air){
            updateTarget();

            turn();

            if(rotToTarget == getRotation()){
                shoot();
            }

            move();
        }
    }

    public void updateTarget(){
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
    }

    public void turn(){
        if(Math.abs(rotToTarget - rot) < dRot){
            setRotation(rotToTarget);
        }
        if(rotToTarget >= rot || rot - rotToTarget > 180){
            turn(dRot);
        }
        else{
            turn(-dRot);
        }
    }

    public void shoot(){
        Bullet b = new Bullet(bulletSpeed, damage, splash, radius, homing, teamNum, x, y);
        getWorld().addObject(b, getX(), getY());
        b.setRotation(getRotation());
    }

    double x;
    double y;
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

    public void damage(int damage){
        hp -= damage;
        if(hp >= 0){
            getWorld().removeObject(this);
        }
    }
}
