import com.bradik.dao.*;
import com.bradik.logic.*;
import com.bradik.utils.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by Brad on 15.04.2017.
 */
public class Test {
    public static void main(String[] args) throws SQLException {

        generateData();
        printData();


        HibernateUtil.shutdown();

    }

    private static void printData() throws SQLException {

        System.out.println("========Все маршруты=========");
        Collection<Route> routes = Factory.getInstance().getRouteDAO().getAllRoutes();
        for (Route route : routes) {
            System.out.println("Маршрут : " + route.getName() + "  Номер маршрута : " + route.getNumber());
            //Collection<Bus> busses = Factory.getInstance().getBusDAO().getBussesByRoute(route);
            Set<Bus> busses = route.getBusses();
            for (Bus bus : busses)
                System.out.println("Автобус № " + bus.getNumber());
        }

        System.out.println();

        System.out.println("========Все автобусы=========");
        Collection<Bus> busses = Factory.getInstance().getBusDAO().getAllBusses();
        for (Bus bus : busses) {
            System.out.println("Автобус № " + bus.getNumber());
            //Collection drivers = Factory.getInstance().getDriverDAO().getDriversByBus(bus);
            Set<Driver> drivers = bus.getDrivers();
            drivers.forEach((driver) -> System.out.println("Имя : " + driver.getName() + "   Фамилия: " + driver.getSurname()));
        }
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
