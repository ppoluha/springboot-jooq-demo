package se.hkr.java.db.repositories;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.hkr.java.db.generated.tables.records.EmployeeRecord;

import java.util.List;
import java.util.Optional;

import static se.hkr.java.db.generated.tables.Employee.EMPLOYEE;

@Repository
public class EmployeeRepository {
    @Autowired
    private DSLContext db;

    public List<EmployeeRecord> findAll() {
        return db.selectFrom(EMPLOYEE)
                .fetch();
    }

    public void save(EmployeeRecord employee) {
        db.insertInto(EMPLOYEE)
                .set(employee)
                .execute();
    }

    public Optional<EmployeeRecord> findById(Long id) {
        return db.selectFrom(EMPLOYEE)
                .where(EMPLOYEE.ID.eq(id))
                .fetchOptional();
    }
}
