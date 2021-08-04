package kr.or.btf.web.web.form;

import kr.or.btf.web.domain.web.enums.BanDvTy;
import kr.or.btf.web.domain.web.enums.LinkTargetType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class BannerForm extends SearchForm{

    private Long id;
    private String banNm;
    private String dsc;
    @Enumerated(EnumType.STRING)
    private BanDvTy banDvTy;
    private String banLink;

    @Enumerated(EnumType.STRING)
    private LinkTargetType linkTrgtTy;
    private String stYmd;
    private String edYmd;
    private String regPsId;
    private LocalDateTime regDtm;
    private String updPsId;
    private LocalDateTime updDtm;
    private String delAt;
    private String useAt;

}
