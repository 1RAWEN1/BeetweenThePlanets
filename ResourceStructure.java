import greenfoot.Greenfoot;

import java.util.ArrayList;

public class ResourceStructure extends Structures{

    boolean selectStructure;
    ArrayList<Structures> structures1;

    int millisStep;

    public void checkStructures(){
        if(MyWorld.addStructure) {
            for (int i1 = 0; i1 < 4; i1++) {
                rotation = i1 * 90;
                startX = getX();
                startY = getY();

                setLocation(startX + (int) Math.cos(Math.toRadians(rotation)), startY + (int) Math.sin(Math.toRadians(rotation)));
                structures1 = (ArrayList<Structures>) getIntersectingObjects(Structures.class);
                setLocation(startX, startY);
                for (Structures st1 : structures1) {
                    if (st1.isBuilt()) {
                        addStructure = true;
                        for (Structures st : structures) {
                            if (st == st1) {
                                addStructure = false;
                                break;
                            }
                        }
                        if (st1.isConnected(this)) {
                            addStructure = false;
                        }

                        if (addStructure && st1.type == 1) {
                            structures.add(st1);
                        }
                    }
                }
            }
        }
    }

    public void checkStructures(int rot){
        if(MyWorld.addStructure) {
            rotation = rot;
            startX = getX();
            startY = getY();

            setLocation(startX + (int) Math.cos(Math.toRadians(rotation)), startY + (int) Math.sin(Math.toRadians(rotation)));
            structures1 = (ArrayList<Structures>) getIntersectingObjects(Structures.class);
            setLocation(startX, startY);
            for (Structures st1 : structures1) {
                if (st1.isBuilt()) {
                    addStructure = true;
                    for (Structures st : structures) {
                        if (st == st1) {
                            addStructure = false;
                            break;
                        }
                    }
                    if (st1.isConnected(this)) {
                        addStructure = false;
                    }

                    if (addStructure && st1.type == 1) {
                        structures.add(st1);
                    }
                }
            }
        }
    }

    boolean addStructure;
    public void changeStructureList(){
        if(selectStructure && Greenfoot.mousePressed(null)){
            try{
                addStructure = true;
                for(Structures st : structures){
                    if(st==MyWorld.mi.getClickedObject()){
                        addStructure = false;
                    }
                }
                if(addStructure && MyWorld.mi.getClickedObject()!=this){
                    structures.add(MyWorld.mi.getClickedObject());
                }
                else if(!addStructure && MyWorld.mi.getClickedObject()!=this){
                    structures.remove(MyWorld.mi.getClickedObject());
                }
            }catch(Exception e){}
        }
    }

    public void removeNullStructures(){
        if(MyWorld.deleteStructure) {
            for (int i1 = 0; i1 < structures.size(); i1++) {
                if (structures.get(i1).getWorld() == null) {
                    structures.remove(i1);
                    i1--;
                }
            }
        }
    }


    int i;
    int getRes;


    //ArrayList<Integer> nonTransportedRes = new ArrayList<>();
    public void transportRes(int resType){
        if(resNum[resType]>0 && structures.size()>0 && i<structures.size()){
            try{
                if(structures.get(i).maxResourсes != 0 && structures.get(i).resNum[resType]<structures.get(i).maxResourсes
                        || structures.get(i).maxResourсes == 0 && structures.get(i).notFully()){
                    getRes=0;
                    for(int i1=0;i1<structures.get(i).needRes.size();i1++){
                        if(structures.get(i).needRes.get(i1)==resType){
                            getRes=1;
                            break;
                        }
                    }
                    if(getRes==1){
                        structures.get(i).resNum[resType]++;
                        resNum[resType]--;
                    }

                    if(structures.get(i).needRot){
                        structures.get(i).giveResFromRot = (int) (180 * Math.atan2(structures.get(i).y - y, structures.get(i).x - x) / Math.PI);
                    }
                }
                i++;
            }catch(Exception e){
                structures.remove(i);
            }
        }

        if(i>=structures.size()){
            i=0;
        }
    }
}
