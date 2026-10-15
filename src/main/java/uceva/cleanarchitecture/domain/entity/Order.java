package uceva.cleanarchitecture.domain.entity;

/**
 * Entidad que representa un pedido del sistema.
 *
 * @remarks
 * El estado (status) debe ser uno de los siguientes valores:
 * - "Pendiente"
 * - "Enviado"
 * - "Entregado"
 * - "Cancelado"
 */
public class Order {
    public Integer id;
    public String customer;
    public Integer total;
    public String createdAt;
    public String status;

    public Order(Integer id, String customer, Integer total, String createdAt, String status) {
        this.id = id;
        this.customer = customer;
        this.total = total;
        this.createdAt = createdAt;
        this.status = status;
    }
}