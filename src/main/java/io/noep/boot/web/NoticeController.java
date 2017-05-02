package io.noep.boot.web;

import io.noep.boot.entity.Notice;
import io.noep.boot.service.NoticeService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User : taehoon
 * Date : 2017. 5. 2.
 * Time : 오후 12:21
 * Desc :
 */
@RestController
@RequestMapping("/notices")
public class NoticeController {

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    private final NoticeService noticeService;

    @GetMapping
    public List<Notice> findAll(@RequestParam(required = false, name = "q") String query,
                                @PageableDefault Pageable pageable) {
        return noticeService.findAll(query, pageable);
    }

    @GetMapping("/{noticeSeq}")
    public Notice findOne(@PathVariable Long noticeSeq) {
        return noticeService.findOne(noticeSeq);
    }

    @PostMapping
    public Notice post(@RequestBody Notice notice) {

        return noticeService.post(notice.getTitle(), notice.getContent());

    }

    @DeleteMapping("/{noticeSeq}")
    public void deleteOne(@PathVariable Long noticeSeq) {
        noticeService.delete(noticeSeq);
    }
}
