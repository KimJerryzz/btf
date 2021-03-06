package kr.or.btf.web.services.web;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.or.btf.web.domain.web.FileInfo;
import kr.or.btf.web.domain.web.QFileDownloadHis;
import kr.or.btf.web.domain.web.QFileInfo;
import kr.or.btf.web.repository.web.FileDownloadHisRepository;
import kr.or.btf.web.repository.web.FileInfoRepository;
import kr.or.btf.web.web.form.FileInfoForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FileInfoService {

    private final JPAQueryFactory queryFactory;
    private final FileInfoRepository fileInfoRepository;
    private final FileDownloadHisRepository fileDownloadHisRepository;

    public List<FileInfo> list(FileInfoForm fileInfoForm) {
        QFileInfo qFileInfo = QFileInfo.fileInfo;
        QFileDownloadHis qFileDownloadHis = QFileDownloadHis.fileDownloadHis;

        OrderSpecifier<Long> orderSpecifier = qFileInfo.id.desc();

        BooleanBuilder builder = new BooleanBuilder();
        builder.and(qFileInfo.dataPid.eq(fileInfoForm.getDataPid()));
        builder.and(qFileInfo.tableNm.eq(fileInfoForm.getTableNm()));
        if (fileInfoForm.getDvTy() != null) {
            builder.and(qFileInfo.dvTy.eq(fileInfoForm.getDvTy()));
        }

        List<FileInfo> list = queryFactory
                .select(Projections.fields(FileInfo.class,
                        qFileInfo.id,
                        qFileInfo.dvTy,
                        qFileInfo.flNm,
                        qFileInfo.chgFlNm,
                        qFileInfo.dataPid,
                        qFileInfo.regDtm,
                        qFileInfo.flExtsn,
                        qFileInfo.flPth,
                        qFileInfo.flSz,
                        ExpressionUtils.as(
                                JPAExpressions.select(qFileDownloadHis.count())
                                        .from(qFileDownloadHis)
                                        .where(qFileInfo.id.eq(qFileDownloadHis.flPid)),
                                "downloadCnt")
                ))
                .from(qFileInfo)
                .where(builder)
                .orderBy(orderSpecifier)
                .fetch();

        return list;
    }

    @Transactional
    public FileInfo save(FileInfo fileInfo) {
        try {
            fileInfoRepository.save(fileInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileInfo;
    }

    public FileInfo load(Long id) {
        if(id != null) {
            return fileInfoRepository.findById(id).orElseGet(FileInfo::new);
        }else{
            return new FileInfo();
        }
    }

    @Transactional
    public boolean delete(FileInfoForm form) {

        try {
            fileDownloadHisRepository.deleteByFlPid(form.getId());
            fileInfoRepository.deleteById(form.getId());
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public FileInfo findByFlPthAndChgFlNm(String fl_pth, String chg_fl_nm) {
        return fileInfoRepository.findByFlPthAndChgFlNm(fl_pth, chg_fl_nm);
    }
}
