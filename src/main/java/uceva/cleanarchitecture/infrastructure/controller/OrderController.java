package uceva.cleanarchitecture.infrastructure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import uceva.cleanarchitecture.application.usecase.GetAllOrdersUseCase;
import uceva.cleanarchitecture.domain.entity.Order;
import java.util.List;

@RestController
@RequestMapping("/orders")
@Tag(name = "Orders", description = "Operaciones sobre pedidos")
public class OrderController {

    private final GetAllOrdersUseCase getAllOrdersUseCase;

    public OrderController(GetAllOrdersUseCase getAllOrdersUseCase){
        this.getAllOrdersUseCase = getAllOrdersUseCase;
    }

    @GetMapping("/{countOrders}")
    @Operation(summary = "Obtener listado de pedidos", description = "Retorna una lista de pedidos generados dinámicamente según la cantidad solicitada.")
    @ApiResponse(responseCode = "200", description = "Lista de pedidos generados")
    @Parameter(description = "Cantidad de pedidos a generar", example = "10")
    public List<Order> getAll(@PathVariable int countOrders) {
        return getAllOrdersUseCase.execute(countOrders);
    }
}