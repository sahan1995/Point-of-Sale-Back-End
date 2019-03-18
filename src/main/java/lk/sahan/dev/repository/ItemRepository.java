package lk.sahan.dev.repository;

import lk.sahan.dev.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,String> {
}
