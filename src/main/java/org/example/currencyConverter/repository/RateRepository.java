package org.example.currencyConverter.repository;

import org.example.currencyConverter.model.Rate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends CrudRepository<Rate,Long> {

/*
    @Query(value = "SELECT COUNT(subscriptions.customer_id) FROM subscriptions WHERE service_id = :id", nativeQuery = true)
    Long getSubsById(Long id);
*/

}
