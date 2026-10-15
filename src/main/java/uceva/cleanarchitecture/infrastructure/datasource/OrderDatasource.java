package uceva.cleanarchitecture.infrastructure.datasource;

import com.github.javafaker.Faker;
import uceva.cleanarchitecture.domain.entity.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Datasource encargado de generar pedidos simulados.
 *
 * Esta clase pertenece a la <b>capa de Infrastructure</b>
 * y actúa como una fuente de datos (Datasource).
 *
 * Utiliza la librería Faker para generar información falsa de pedidos.
 *
 * No contiene lógica de negocio.
 * No implementa repositorios del dominio.
 *
 * Es consumida por OrderRepositoryImpl, que se encarga
 * de adaptar los datos al dominio y exponerlos mediante
 * el contrato OrderRepository.
 */
public class OrderDatasource {

    private Faker faker = new Faker();
    private final Random random = new Random();
    private final String[] statuses = {"Pendiente", "Enviado", "Entregado", "Cancelado"};

    public List<Order> getAll(int countOrders){
        List<Order> orders = new ArrayList<Order>();
        for (int i = 1; i <= countOrders; i++) {
            orders.add(generateOrder(i));
        }
        return orders;
    }

    private Order generateOrder(Integer id){
        String customer = faker.name().fullName();
        int total = faker.number().numberBetween(10000, 500001);
        String createdAt = faker.date().past(30, TimeUnit.DAYS).toInstant().toString();
        String status = statuses[random.nextInt(statuses.length)];
        return new Order(id, customer, total, createdAt, status);
    }
}