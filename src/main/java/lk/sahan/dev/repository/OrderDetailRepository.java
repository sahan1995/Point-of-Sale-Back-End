package lk.sahan.dev.repository;

import lk.sahan.dev.entity.OrderDetail;
import lk.sahan.dev.entity.OrderDetail_PK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,OrderDetail_PK> {
}
