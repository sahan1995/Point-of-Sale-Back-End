package lk.sahan.dev.repository;

import lk.sahan.dev.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,String> {
}
