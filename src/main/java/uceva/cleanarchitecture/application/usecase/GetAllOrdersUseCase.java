package uceva.cleanarchitecture.application.usecase;

import uceva.cleanarchitecture.domain.entity.Order;
import uceva.cleanarchitecture.domain.repository.OrderRepository;

import java.util.List;

/**
 * Caso de uso para obtener un listado de pedidos.
 *
 * Esta clase pertenece a la <b>capa de Application</b>
 * y representa una regla de negocio de la aplicación.
 *
 * Su responsabilidad es orquestar la obtención de pedidos
 * delegando en el repositorio correspondiente.
 */
public class GetAllOrdersUseCase {
    private final OrderRepository orderRepository;

    public GetAllOrdersUseCase(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public List<Order> execute(int countOrders){
        return orderRepository.getAll(countOrders);
    }
}