package kr.or.btf.web.web.form;

import kr.or.btf.web.domain.web.enums.UserRollType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
public class CourseRequestForm extends SearchForm {

    private Long id;
    private LocalDateTime regDtm;
    private String confmAt;
    private String areaNm;
    private String schlNm;
    private Integer grade;
    private String ban;
    private Integer no;
    private Long crsMstPid;
    private Long mberPid;
    private Integer sn;
}
