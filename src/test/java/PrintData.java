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
            Collection<Driver> drivers = Factory.getInstance().getDriverDAO().getDriversByBus(bus);
            //Set<Driver> drivers = bus.getDrivers();
            drivers.forEach((driver) -> System.out.println("Имя : " + driver.getName() + "   Фамилия: " + driver.getSurname()));
        }
    }
}

