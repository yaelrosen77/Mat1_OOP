package observer;

import org.jetbrains.annotations.NotNull;

public class ConcreteMember implements Member{
    private String data;            //data that member stores from updates

    public String getData() {
        return data;
    }

    public void update(UndoableStringBuilder usb) {         //Get an updated info from groupadmin
        data = usb.toString();
    }

    public String toString(){
       return(this.data);
    }

}
