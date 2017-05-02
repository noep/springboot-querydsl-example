package io.noep.boot.repository;

import io.noep.boot.entity.Notice;
import io.noep.boot.repository.dsl.CustomNoticeRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User : taehoon
 * Date : 2017. 5. 2.
 * Time : 오전 11:40
 * Desc :
 */
public interface NoticeRepository extends JpaRepository<Notice, Long>, CustomNoticeRepository {
}
