import com.bradik.dao.*;
import com.bradik.logic.*;
import com.bradik.utils.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by Brad on 15.04.2017.
 */
public class CreateData {

    public static void main(String[] args) throws SQLException {

        FullTest.generateData();

        HibernateUtil.shutdown();
    }
}
