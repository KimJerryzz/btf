package kr.or.btf.web.web.form;

import kr.or.btf.web.domain.web.enums.UserRollType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;

@Getter
@Setter
public class CourseForm extends SearchForm {

    private Long id;
    private String stepTy;
    private String mberDvTy;
    private String crsNm;
    private String crsCn;
    private String imgFl;
    private Long courseItemCnt;
    private Long courseTargetCnt;
    private String regPsNm;
    private Long atnlcReqPid;
    private Long crsMstPid;
}
