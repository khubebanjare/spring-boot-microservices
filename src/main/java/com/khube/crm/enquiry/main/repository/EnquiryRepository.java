package com.khube.crm.enquiry.main.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.khube.crm.enquiry.main.entity.Enquiry;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Integer> {

	public List<Enquiry> findByProductId(@Param("productId") Integer productId);

	public List<Enquiry> findByProductIdAndDateOfEnquiry(@RequestParam("productId") Integer productId,
														 @RequestParam("dateOfEnquiry") LocalDate dateOfEnquiry);
}
