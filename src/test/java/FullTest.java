import com.bradik.dao.BusDAO;
import com.bradik.dao.DriverDAO;
import com.bradik.dao.Factory;
import com.bradik.dao.RouteDAO;
import com.bradik.logic.Bus;
import com.bradik.logic.Driver;
import com.bradik.logic.Route;
import com.bradik.utils.HibernateUtil;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Brad on 19.04.2017.
 */
public class FullTest {

    public static void main(String[] args) throws SQLException {

        generateData();

        printData();

        HibernateUtil.shutdown();

    }

    public static void generateData() throws SQLException {

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

        bus = busDAO.getBusByNymber("R227KR");
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

    public static void printData() throws SQLException {

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
            Collection<Driver> drivers = Factory.getInstance().getDriverDAO().getDriversByBus(bus);
            //Set<Driver> drivers = bus.getDrivers();
            drivers.forEach((driver) -> System.out.println("Имя : " + driver.getName() + "   Фамилия: " + driver.getSurname()));
        }
    }
}
