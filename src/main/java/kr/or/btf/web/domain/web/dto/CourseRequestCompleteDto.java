package kr.or.btf.web.domain.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class  CourseRequestCompleteDto {
    private Long cmplHistPid;
    private Long atnlcReqPid;
    private Long crsMstPid;
    private Long crsPid;
    private Integer sn;
    private String ttl;
    private Long crssqPid;
    private String procNm;
    private String procPer;
    private String crsNm;
}
