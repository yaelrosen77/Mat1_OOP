package observer;

import java.util.ArrayList;

public class GroupAdmin implements Sender{


    private UndoableStringBuilder observable = new UndoableStringBuilder();    //The observable type of data to follow
    private ArrayList<Member> observers = new ArrayList<Member>();      //     //The member database


    public UndoableStringBuilder getObservable() {
        return observable;
    }
    @Override
    public void register(Member obj) {      //register a new member method
        observers.add(obj);
    }

    @Override
    public void unregister(Member obj) {                //unregister the specified member from database
            observers.remove(obj);
    }


    //All the methods below are implemented from UndoableStringBuilder class
    //After each use of the original method from the class, there is a notification for all members of the group
    @Override
    public void insert(int offset, String obj) {
        observable.insert(offset,obj);
        notify_all();
    }

    @Override
    public void append(String obj) {
        observable.append(obj);
        notify_all();
    }

    @Override
    public void delete(int start, int end) {
        observable.delete(start,end);
        notify_all();
    }

    @Override
    public void undo() {
        observable.undo();
        notify_all();
    }

    //Sending the updated USB to each member of the group
    private void notify_all(){
        for(Member i: observers){
            i.update(observable);
        }
    }
}






