package uceva.cleanarchitecture.infrastructure.repository;

import uceva.cleanarchitecture.domain.entity.Order;
import uceva.cleanarchitecture.domain.repository.OrderRepository;
import uceva.cleanarchitecture.infrastructure.datasource.OrderDatasource;

import java.util.List;

/**
 * Implementación concreta del repositorio de pedidos.
 *
 * Esta clase pertenece a la <b>capa de Infrastructure</b>
 * y actúa como un adaptador (Repository Implementation) entre:
 *
 * - El contrato del dominio {@link OrderRepository}
 * - La fuente de datos {@link OrderDatasource}
 *
 * Su responsabilidad es:
 * - Cumplir el contrato definido por el dominio
 * - Delegar la obtención de datos al datasource
 * - Adaptar o transformar los datos si fuese necesario
 *
 * No contiene lógica de negocio.
 * No debe ser utilizada directamente por los casos de uso.
 *
 * Los casos de uso dependen únicamente del contrato
 * {@link OrderRepository}, no de esta implementación.
 */
public class OrderRepositoryImpl extends OrderRepository {

    private final OrderDatasource orderDatasource;

    public OrderRepositoryImpl(OrderDatasource orderDatasource){
        this.orderDatasource = orderDatasource;
    }

    @Override
    public List<Order> getAll(int countOrders) {
        return orderDatasource.getAll(countOrders);
    }
}