package io.noep.boot.repository.dsl;

import io.noep.boot.entity.Notice;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * User : taehoon
 * Date : 2017. 5. 2.
 * Time : 오전 11:42
 * Desc :
 */
public interface CustomNoticeRepository {

    List<Notice> findAll(String query, Pageable pageable);
}
