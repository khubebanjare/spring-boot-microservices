package com.khube.crm.enquiry.main.repository;

import com.khube.crm.enquiry.main.entity.Enquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Integer> {
}
