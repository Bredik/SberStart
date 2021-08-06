package ru.borisova.dittask53_v2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.borisova.dittask53_v2.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
