package com.evaluation.demo.repository;


import com.evaluation.demo.model.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository <Contact,Long> {

}
