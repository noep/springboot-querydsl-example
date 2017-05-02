package io.noep.boot.service;

import io.noep.boot.entity.Notice;
import io.noep.boot.repository.NoticeRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User : taehoon
 * Date : 2017. 5. 2.
 * Time : 오후 12:07
 * Desc : 서비스 생성이랑은 상관 없는 오류임
 */
@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public List<Notice> findAll(String query, Pageable pageable) {
        return noticeRepository.findAll(query, pageable);
    }

    public Notice post(String title, String content) {

        Notice notice = new Notice();
        notice.setTitle(title);
        notice.setContent(content);
        return noticeRepository.save(notice);
    }

    public Notice findOne(Long noticeSeq) {

        return noticeRepository.findOne(noticeSeq);
    }

    public void delete(Long noticeSeq) {
        noticeRepository.delete(noticeSeq);
    }
}
