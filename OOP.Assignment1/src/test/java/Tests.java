import observer.ConcreteMember;
import observer.GroupAdmin;
import observer.JvmUtilities;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    void testGroupadmin() {
        GroupAdmin lior = new GroupAdmin();
        lior.insert(0,"Yael");
        assertEquals("Yael",lior.getObservable().toString());
        lior.append(" is very nice");
        assertEquals("Yael is very nice",lior.getObservable().toString());
        lior.delete(12,lior.getObservable().toString().length());
        assertEquals("Yael is very",lior.getObservable().toString());
        lior.undo();
        assertEquals("Yael is very nice",lior.getObservable().toString());
        lior.undo();
        assertEquals("Yael",lior.getObservable().toString());
        lior.undo();
        assertEquals("",lior.getObservable().toString());
    }

    @Test
    void testConcretemember() {
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

    @Test
    void JVMUtilTests(){
        GroupAdmin observable = new GroupAdmin();
        logger.info(()-> JvmUtilities.objectTotalSize(observable));
        logger.info(()->JvmUtilities.objectFootprint(observable));

        ConcreteMember c1 = new ConcreteMember();
        ConcreteMember c2 = new ConcreteMember();
        ConcreteMember c3 = new ConcreteMember();

        observable.register(c1);
        logger.info(()-> JvmUtilities.objectTotalSize(observable));

        observable.register(c2);
        observable.register(c3);
        logger.info(()-> JvmUtilities.objectTotalSize(observable));
        logger.info(()->JvmUtilities.objectFootprint(observable));
        logger.info(()-> JvmUtilities.objectTotalSize(c1));
        logger.info(()-> JvmUtilities.objectTotalSize(c2));

        observable.append("Size change");
        logger.info(()-> JvmUtilities.objectTotalSize(observable));
        logger.info(()-> JvmUtilities.objectTotalSize(c1));
        logger.info(()-> JvmUtilities.objectTotalSize(c3));
        observable.delete(5,observable.getObservable().toString().length());
        logger.info(()->JvmUtilities.objectFootprint(observable));
        logger.info(()-> JvmUtilities.objectTotalSize(observable));
        observable.undo();
        logger.info(()-> JvmUtilities.objectTotalSize(observable));
        logger.info(()->JvmUtilities.objectFootprint(observable));

        logger.info(() -> JvmUtilities.jvmInfo());

    }
}
