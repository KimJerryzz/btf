package kr.or.btf.web.web.form;

import kr.or.btf.web.domain.web.enums.ActionType;
import kr.or.btf.web.domain.web.enums.GraphDvType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
public class GraphMasterForm extends SearchForm {

    private Long id;

    @Enumerated(EnumType.STRING)
    private GraphDvType graphDvTy;

    private String graphNm;

}
