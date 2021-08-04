package kr.or.btf.web.web.form;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
public class CourseMasterRelForm extends SearchForm {

    private Long crsMstPid;
    private Long crsPid;
    private Integer sn;
    private Integer[] snArr;

}
