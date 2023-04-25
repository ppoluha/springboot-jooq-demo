package se.hkr.java.db.repositories;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.hkr.java.db.generated.tables.records.CustomerRecord;

import java.util.List;
import java.util.Optional;

import static se.hkr.java.db.generated.tables.Customer.CUSTOMER;

@Repository
public class CustomerRepository {

    @Autowired
    private DSLContext db;
    public void save(CustomerRecord customer) {
        db.insertInto(CUSTOMER)
                .set(customer)
                .execute();
    }

    public List<CustomerRecord> findAll() {
        return db.selectFrom(CUSTOMER)
                .fetch();
    }

    public Optional<CustomerRecord> findById(Long customerId) {
        return db.selectFrom(CUSTOMER)
                .where(CUSTOMER.ID.eq(customerId))
                .fetchOptional();
    }
}
