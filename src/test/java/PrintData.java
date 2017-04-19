import com.bradik.dao.Factory;
import com.bradik.logic.Bus;
import com.bradik.logic.Driver;
import com.bradik.logic.Route;
import com.bradik.utils.HibernateUtil;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Brad on 18.04.2017.
 */
public class PrintData {
    public static void main(String[] args) throws SQLException {

        FullTest.printData();

        HibernateUtil.shutdown();

    }
}

