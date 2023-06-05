package com.khube.crm.enquiry.main.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.khube.crm.enquiry.main.entity.Enquiry;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Integer> {

	public Enquiry findEnquiryByProductId(@Param("productId") Integer productId);

	public Enquiry findByproductIdAndDateOfEnquiry(@RequestParam("productId") Integer productId,
																  @RequestParam("dateOfEnquiry") Date dateOfEnquiry);
}
