package uceva.cleanarchitecture.domain.repository;

import uceva.cleanarchitecture.domain.entity.Order;
import java.util.List;

/**
 * Contrato del repositorio de pedidos.
 *
 * Esta clase abstracta pertenece a la <b>capa de Domain</b>
 * y define el contrato que deben cumplir todas las
 * implementaciones de repositorios de pedidos.
 *
 * El dominio no conoce detalles de infraestructura
 * ni sabe de bases de datos, APIs o frameworks.
 */
public abstract class OrderRepository {
    public abstract List<Order> getAll(int countOrders);
}