package kr.or.btf.web.repository.web;

import kr.or.btf.web.domain.web.CourseRequest;
import kr.or.btf.web.domain.web.Postscript;
import kr.or.btf.web.domain.web.PostscriptImage;
import kr.or.btf.web.web.form.CourseRequestForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostscriptImageRepository extends JpaRepository<PostscriptImage, Long> {

    List<PostscriptImage> findAllByPostscriptPid(Long postscriptPid);

    void deleteByFlPid(Long flPid);
}

