package kr.or.btf.web.web.form;

import kr.or.btf.web.domain.web.enums.ActionType;
import kr.or.btf.web.domain.web.enums.ProcessType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
public class ActionLogForm extends SearchForm {

    private Long id;

    @Enumerated(EnumType.STRING)
    private ActionType actDvTy;

    private LocalDateTime actDtm;

    private String cnctIp;

    private String cnctUrl;

    private Long mberPid;

}
