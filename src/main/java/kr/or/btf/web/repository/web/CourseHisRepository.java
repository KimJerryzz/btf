package kr.or.btf.web.repository.web;

import kr.or.btf.web.domain.web.CourseHis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseHisRepository extends JpaRepository<CourseHis, Long> {

    Optional<CourseHis> findTopByMberPidAndCrssqPidOrderByAtnlcHourDescAtnlcDtmDesc(Long mberPid, Long crssqPid);

}
