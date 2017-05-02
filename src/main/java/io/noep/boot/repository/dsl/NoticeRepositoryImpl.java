package io.noep.boot.repository.dsl;

import com.querydsl.core.BooleanBuilder;
import io.noep.boot.entity.Notice;
import io.noep.boot.entity.QNotice;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * User : taehoon
 * Date : 2017. 5. 2.
 * Time : 오전 11:42
 * Desc :
 */
public class NoticeRepositoryImpl extends QueryDslRepositorySupport implements CustomNoticeRepository {

    private QNotice notice = QNotice.notice;

    public NoticeRepositoryImpl() {
        super(Notice.class);
    }

    @Override
    public List<Notice> findAll(String query, Pageable pageable) {

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        if (!StringUtils.isEmpty(query)) {
            booleanBuilder.and(
                    notice.title.containsIgnoreCase(query)
                    .or(notice.content.containsIgnoreCase(query)));
        }

        return getQuerydsl().applyPagination(pageable, from(notice))
                .where(booleanBuilder)
                .fetch();
    }
}
