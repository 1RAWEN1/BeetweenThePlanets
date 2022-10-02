import greenfoot.Greenfoot;

import java.util.ArrayList;

public class Node extends Structures{
    ArrayList<Structures> getters = new ArrayList<>();
    ArrayList<Structures> consumers = new ArrayList<>();
    ArrayList<Structures> batteries = new ArrayList<>();
    ArrayList<Node> nodes = new ArrayList<>();

    boolean start = true;
    public void doMainActions(){
        if(type==0){
            if(start){
                needEnergy = -1;
                start = false;
            }
            updateStructureLocation();

            if(Mouse.mousePressed && !isTouching(NatObstical.class) && !isTouching(Structures.class)){
                if(canBeBuild()){
                    type=1;
                }
            }
        }
        else if(type==1 && isBuilt()){
            isClick();

            changeStructureList();

            removeNullStr();

            distributeEnergy();

            drawConnections(getters);
            drawConnections(consumers);
            drawConnections1(nodes);
        }
    }

    public void distributeEnergy(){
        energy = 0;

        for(Structures getter : getters){
            if(getter.energy > 0) {
                energy += getter.energy;
                getter.energy = 0;
            }
        }

        if(energy > 0) {
            for (Structures consumer : consumers) {
                if (consumer.needEnergy < energy) {
                    consumer.haveEnergy = true;
                }

                energy -= consumer.needEnergy;
            }

            updateEnergyValue(energy);
        }
    }

    public void updateEnergyValue(int energy1){
        energy = energy1;
        for(Node n : nodes){
            n.updateEnergyValue(energy1);
        }
    }

    public void removeNullStr(){
        if(MyWorld.deleteStructure) {
            getters.removeIf(g -> g.getWorld() == null);
            consumers.removeIf(c -> c.getWorld() == null);
            batteries.removeIf(b -> b.getWorld() == null);
            nodes.removeIf(n -> n.getWorld() == null);
        }
    }

    public void changeStructureList(){
        if(MyWorld.selectedStructure == this && Greenfoot.mousePressed(null)){
            try{
                addStructure = true;
                for(Structures st : getters){
                    if(st==MyWorld.mi.getClickedObject()){
                        addStructure = false;
                    }
                }
                for(Structures st : consumers){
                    if(st==MyWorld.mi.getClickedObject()){
                        addStructure = false;
                    }
                }
                for(Structures st : nodes){
                    if(st==MyWorld.mi.getClickedObject()){
                        addStructure = false;
                    }
                }
                if(addStructure && MyWorld.mi.getClickedObject()!=this){
                    if(MyWorld.mi.getClickedObject().needEnergy == -1) {
                        Node n2 = (Node)MyWorld.mi.getClickedObject();
                        boolean add = true;
                        for(Node n1 : n2.nodes){
                            if(n1 == this){
                                add = false;
                                break;
                            }
                        }
                        if(add) {
                            nodes.add((Node) MyWorld.mi.getClickedObject());
                        }
                    }
                    else if(MyWorld.mi.getClickedObject().needEnergy > 0) {
                        addConsumer(MyWorld.mi.getClickedObject());
                    }
                    else if(MyWorld.mi.getClickedObject().energyICanCreate > 0) {
                        addGetter(MyWorld.mi.getClickedObject());
                    }
                }
                else if(!addStructure && MyWorld.mi.getClickedObject()!=this){
                    if(MyWorld.mi.getClickedObject().needEnergy == -1) {
                        nodes.remove((Node)MyWorld.mi.getClickedObject());
                    }
                    else if(MyWorld.mi.getClickedObject().needEnergy > 0) {
                       removeConsumer(MyWorld.mi.getClickedObject());
                    }
                    else if(MyWorld.mi.getClickedObject().energyICanCreate > 0) {
                        removeGetter(MyWorld.mi.getClickedObject());
                    }
                }
            }catch(Exception e){}
        }
    }

    public void addGetter(Structures getter){
        getters.add(getter);
        for(Node n : nodes){
            n.addGetter(getter);
        }
    }

    public void addConsumer(Structures consumer){
        consumers.add(consumer);
        for(Node n : nodes){
            n.addConsumer(consumer);
        }
    }

    public void removeGetter(Structures getter){
        getters.remove(getter);
        for(Node n : nodes){
            n.removeGetter(getter);
        }
    }

    public void removeConsumer(Structures consumer){
        consumers.remove(consumer);
        for(Node n : nodes){
            n.removeConsumer(consumer);
        }
    }
}
