package kr.or.btf.web.web.form;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Transient;

@Getter
@Setter
public class CourseMasterForm extends SearchForm {

    private Long id;
    private String mberDvTy;
    private String crsNm;
    private String crsCn;
    private String imgFl;
    private String openAt;
}
