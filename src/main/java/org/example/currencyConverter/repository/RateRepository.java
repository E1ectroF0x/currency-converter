package org.example.currencyConverter.repository;

import org.example.currencyConverter.model.Rate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends CrudRepository<Rate,Long> {
}
