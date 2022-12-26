package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMemberTest {

    @Test
    void tests() {
        GroupAdmin yael = new GroupAdmin();
        ConcreteMember lior = new ConcreteMember();
        ConcreteMember lior2 = new ConcreteMember();
        yael.register(lior);
        yael.register(lior2);
        yael.append("test the update");
        assertEquals(lior.getData(),yael.getObservable().toString());
        yael.append(" again");
        assertEquals(lior2.getData(),yael.getObservable().toString());
    }
}