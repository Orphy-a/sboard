package kr.co.sboard.repository;

import kr.co.sboard.dto.TermsDTO;
import kr.co.sboard.entity.Terms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermsRepository extends JpaRepository<Terms, Integer> {

}
