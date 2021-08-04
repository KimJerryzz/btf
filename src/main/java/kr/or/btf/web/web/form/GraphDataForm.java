package kr.or.btf.web.web.form;

import kr.or.btf.web.domain.web.enums.GraphDvType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class GraphDataForm extends SearchForm {

    private Long graphPid;
    private Long dataPid;
    private String colNm;
    private Float colValue1;
    private Float colValue2;
    private Float colValue3;
    private Integer colSno;

    private Long[] dataPidArr;
    private String[] colNmArr;
    private Float[] colValue1Arr;
    private Float[] colValue2Arr;
    private Float[] colValue3Arr;
    private Integer[] colSnoArr;

}
