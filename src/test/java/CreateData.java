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

        generateData();

        HibernateUtil.shutdown();
    }

    private static void generateData() throws SQLException {

        BusDAO busDAO = Factory.getInstance().getBusDAO();
        DriverDAO driverDAO = Factory.getInstance().getDriverDAO();
        RouteDAO routeDAO = Factory.getInstance().getRouteDAO();

        Bus bus;
        Driver driver;
        Route route;

        bus = new Bus("R227KR");
        driver = new Driver("Сергей", "Иванов", 27);
        route = new Route("7", 7);

        busDAO.addBus(bus);
        driverDAO.addDriver(driver);
        routeDAO.addRoute(route);

        bus.addDriver(driver);
        busDAO.updateBus(bus.getId(),bus);

        route.addBus(bus);
        routeDAO.updateRoute(route.getId(), route);


        bus = new Bus("E465XD");
        driver = new Driver("Юлия", "Сергеевна", 32);
        route = new Route("12", 12);

        busDAO.addBus(bus);
        driverDAO.addDriver(driver);
        routeDAO.addRoute(route);

        bus.addDriver(driver);
        busDAO.updateBus(bus.getId(),bus);

        route.addBus(bus);
        routeDAO.updateRoute(route.getId(), route);


    }
}
